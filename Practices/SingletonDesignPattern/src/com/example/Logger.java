package com.example;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private String fileName;
    private PrintWriter writer;

    private static Logger instance=null;

    private Logger() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        fileName = formatter.format(date) + ".txt";
        try {
            writer = new PrintWriter(fileName, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void write(String data) {
        Date date = new Date();
        String log = date.toString() + "--" + data;
        writer.println(log);
        writer.flush();
    }

    public static Logger getInstance(){
        if(instance==null)
            instance=new Logger();
        return instance;
    }
}
