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

        RunnableExample[] randomNumberTasks = new RunnableExample[1];;
        try {
            randomNumberTasks[0] = new RunnableExample();
            Thread t = new Thread(randomNumberTasks[0]);
            t.start();
            // 异步执行 下面方法
                // 从Future对象上获取任务的返回值，并输
                Object result = randomNumberTasks[0].get();
                // 确保  拿到result 并输出
                System.out.println("异步计算结果为："+result);



        //这是得到的返回值



        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        } catch (InterruptedException  e) {
            e.printStackTrace();
        }

        // 然后退出main线程
      //  executor.shutdown();
    }

    static  class RunnableExample implements Runnable
    {
        // Shared object to store result
        private Object result = null;

        public void run()
        {

            // As run cannot throw any Exception
            try
            {
                Thread.sleep( 1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            // Store the return value in result when done
            result = sum();

            // Wake up threads blocked on the get() method
            synchronized(this)
            {
                notifyAll();
            }
        }

        public synchronized Object get()
                throws InterruptedException
        {
            while (result == null)
                wait();

            return result;
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