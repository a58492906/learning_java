package io.kimmking.cache.controller;

import io.kimmking.cache.cache.RedisLockAnnotation;
import io.kimmking.cache.cache.RedisLockTypeEnum;
import io.kimmking.cache.entity.User;
import io.kimmking.cache.pushsub.PushService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.awt.print.Book;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@RestController
@EnableAutoConfiguration
public class UserController {

   @Resource
   private  PushService  pushService;
    
    @RequestMapping("/user/find")
    @RedisLockAnnotation(typeEnum = RedisLockTypeEnum.ONE, lockTime = 3)
    User find(Integer id) {
        return new User(1,"KK", 28);
    }

    @RequestMapping("/user/list")
    List<User> list() {
        return Arrays.asList(new User(
                1,"KK", 28),
                             new User(2,"CC", 18));
    }

    @RequestMapping("pushMsgToAll")
        String    pushMsgToAll() {
        pushService.pushMsgToAll("test");
        return "success";
    }



    @GetMapping("/testRedisLock")
    @RedisLockAnnotation(typeEnum = RedisLockTypeEnum.ONE, lockTime = 3)
    public Book testRedisLock(@RequestParam("userId") Long userId) {
        try {
            System.out.println("睡眠执行前");
            Thread.sleep(10000);
            System.out.println("睡眠执行后");
        } catch (Exception e) {
           e.printStackTrace();
            System.out.println("has some error");

        }
        return null;
    }
}