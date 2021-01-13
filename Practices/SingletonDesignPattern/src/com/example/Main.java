package com.example;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        MyApplication app1 = new MyApplication();
        Thread.sleep(1000);
        MyApplication app2=new MyApplication();

        app1.createLog("Log1_1");
        app1.createLog("Log1_2");

        OtherSection app3=new OtherSection();
        app3.doSomething();
        Logger.getInstance().write("In Main");

        app2.createLog("Log2_1");
        app2.createLog("Log2_2");

        System.out.println("Done.");

    }
}
