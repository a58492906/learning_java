package io.kimmking.cache.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Multiset;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import io.kimmking.cache.entity.User;
import io.kimmking.cache.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-07-13 17:21
 */
@Component
public class CuavaCacheHandler {

    @Autowired
    UserMapper userMapper;

    ListeningExecutorService backgroundRefreshPools =
            MoreExecutors.listeningDecorator(new ThreadPoolExecutor(10, 10,
                    0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>()));

    /**
     * guava cache 缓存实体
     */
    LoadingCache<Integer, User> cache = CacheBuilder.newBuilder()
            // 缓存刷新时间
            .refreshAfterWrite(10, TimeUnit.MINUTES)
            // 设置缓存个数
            .maximumSize(500)
            .build(new CacheLoader<Integer, User>() {
                @Override
                // 当本地缓存命没有中时，调用load方法获取结果并将结果缓存
                public User load(Integer appKey) {
                    return getEntryFromDB(appKey);
                }

                @Override
                // 刷新时，开启一个新线程异步刷新，老请求直接返回旧值，防止耗时过长
                public ListenableFuture<User> reload(Integer key, User oldValue) throws Exception {
                    return backgroundRefreshPools.submit(() -> getEntryFromDB(key));
                }

                // 数据库进行查询
                private User getEntryFromDB(Integer id) {

                    return userMapper.find(id);
                }
            });

    /**
     * 对外暴露的方法
     * 从缓存中取entry，没取到就走数据库
     */
    public User getUser(Integer id) throws ExecutionException {
        return cache.get(id);
    }

    /**
     * 销毁时关闭线程池
     */
    @PreDestroy
    public void destroy(){
        try {
            backgroundRefreshPools.shutdown();
        } catch (Exception e){
            System.out.println("thread pool showdown error!e:{}"+e.getMessage());
        }

    }
}
