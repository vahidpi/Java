package com.example;

public class OtherSection {
    private Logger logger;

    public OtherSection() {
        logger=Logger.getInstance();
    }

    public void doSomething(){
        logger.write("Sample log");
    }
}
