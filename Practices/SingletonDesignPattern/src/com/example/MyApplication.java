package com.example;

public class MyApplication {

    private Logger logger;

    public MyApplication() {
        logger= Logger.getInstance();
    }

    public void createLog(String data){
        logger.write(data);
    }
}
