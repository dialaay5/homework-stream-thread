package com.threads;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
   /*
   public static void arrayFunction(){
        int[] arr = new int[100];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100) + 1;
        }
        System.out.println(Thread.currentThread().getName() + Arrays.toString(arr));
    }
    */

    //First solution - use synchronization
   /*
    private static volatile int i = 0;
    private static synchronized int get_i_and_increment() {
        return i++;
     }
    */

    //Second solution - use Atomic
    private static AtomicInteger i = new AtomicInteger(0);
    private static int get_i_and_increment(){
        return i.getAndIncrement();
    }
    static HashMap<Integer,Boolean> map = new HashMap<>();

    private static void printArray(){
        int [] arr = new int[100];
        Random rand = new Random();
        int i = get_i_and_increment();
        Integer number;
        while (i < arr.length) {
                number = rand.nextInt(100) + 1;
            synchronized (Main.class) {
                while (map.containsKey(number)) {
                    number = rand.nextInt(100) + 1;
                }
                map.put(number, true);
            }
                arr[i] = number;
                i = get_i_and_increment();
            }

        System.out.println(Thread.currentThread().getName() + Arrays.toString(arr));
    }



    public static void main(String[] args) {
        System.out.println("exercise thread 2:");
        System.out.println("Daemon thread in Java is a service provider thread that provides services to the user thread.\n"+
                "Its life depend on the mercy of user threads i.e. when all the user threads dies, JVM terminates this thread automatically.\n"+
                "Daemon threads are useful for background supporting tasks such as garbage collection,\n"+
                "releasing memory of unused objects and removing unwanted entries from the cache. Most of the JVM threads are daemon threads\n"+
                "כמו במשחק שיש תריד טיימר, אז כאשר מסתיים המשחק אין טעם בלהמשיך בתריד הזה\n ");

        System.out.println("exercise thread 3:");
        System.out.println("Each core contains a complete CPU capable of executing a thread. Many modern processors support hyperthreading: each physical core behaves as if it is actually two cores,\n"+
                "so it can run two threads simultaneously (e.g. execute one thread while the other is waiting on a cache miss).\n");

        System.out.println("exercise thread 4:");
        System.out.println("The run() method is the method that contains the code that will be executed by the thread when it is started. When a thread is created, its run() method is not automatically executed.\n"+
                "Instead, the run() method must be called explicitly by the start() method or by calling run() directly on the thread object. When run() is called directly, the code will run in the same thread of execution as the caller.\n" +
                "The start() method is used to start a new thread of execution. When the start() method is called, a new thread is created and its run() method is executed in a separate thread of execution.\n");

        System.out.println("exercise thread 5:");
        System.out.println("Join method in Java allows one thread to wait until another thread completes its execution. In simpler words, it means it waits for the other thread to die.\n");

        System.out.println("exercise thread 6:");
        System.out.println("These collections are designed to be used in multi-threaded applications where multiple threads may attempt to access and modify the same data concurrently.\n"+
                "היתרונות:- יש לו מנגנון נעילה והוא נועל את עצמו לבד, וזה מוניע מבעיות בתרדים\n" +
                "החסרונות:- אי אפשר לגשת למבנה הזה מכיוון שהוא תמיד נעול,ויש מצב שיפגע בביצועים כי צריכים לרוץ על כל המבנה אם רוצים לבדוק משהו\n");

        System.out.println("exercise thread 7:");
        System.out.println("כן, יכול להוביל לגישה כפולה\n");

        System.out.println("exercise thread 8:");
        System.out.println("נהוג להשתמש בנעילת משתנים שהם סטטיים\n");

        System.out.println("exercise thread 9:");
        System.out.println(":: פעולה סטטית, מאפשרת להפוך קוד לקריא יותר ומובן יותר, ולחסוך בכתיבת קוד, הולך לפונקצייה ושולח לה כפרמטר פונקצייה אחרת שצריכים לבציע\n");






        Thread t1 = new Thread(Main :: printArray);
        Thread t2 = new Thread(Main :: printArray);
        Thread t3 = new Thread(Main :: printArray);
        Thread t4 = new Thread(Main :: printArray);
        Thread t5 = new Thread(Main :: printArray);


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();




    }
}
