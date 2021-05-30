package bean.definition;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-05-30 15:09
 */

import java.util.concurrent.*;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 *
 * 一个简单的代码参考：
 */
public class Homework03 {
    private volatile int res;

    public static void main(String[] args) {


        long start=System.currentTimeMillis();
        long size = 1;
        CountDownLatch countDownLatch = new CountDownLatch(new Long(size).intValue());
        // 异步执行 下面方法
        // 从Future对象上获取任务的返回值，并输
        ExecutorService executorService = Executors.newFixedThreadPool(new Long(size).intValue());
        final int[] i1 = {8};

        for (int i = 0; i < size; i++) {
            //生成线程
            executorService.execute(() -> {
                try {
                    i1[0] = sum();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    //在 子线程结束的时候调用此方法,供CountDownLatch监测
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();

            // 确保  拿到result 并输出
            System.out.println("异步计算结果为："+  i1[0]);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //这是得到的返回值

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
        executorService.shutdown();
    }





    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}