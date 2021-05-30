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

    public static void main(String[] args) {

        long start=System.currentTimeMillis();

        CallThread callThread = new CallThread();
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> submit = executor.submit(callThread);
        try {
        // 异步执行 下面方法
        Integer result = submit.get();

        //这是得到的返回值

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // 然后退出main线程
        executor.shutdown();
    }

    public static  class CallThread implements Callable<Integer> {

        @Override
        public Integer call() throws InterruptedException {
            Thread.sleep(1000);
            return sum();
        }
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