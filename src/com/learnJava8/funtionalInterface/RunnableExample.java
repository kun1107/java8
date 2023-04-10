package com.learnJava8.funtionalInterface;

public class RunnableExample {
    public static void main(String[] args) {

        /*Old style code*/
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("Normal Runnable");
            }
        };
        new Thread(run).start();

/*Java * Style code*/

        Runnable run1 = () -> System.out.println("Java8 runnable");
        new Thread(run1).start();

        new Thread(() -> System.out.println("Runnable 3")).start();
    }
}
