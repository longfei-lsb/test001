package com.lsb;

import java.io.File;
import java.io.IOException;

public class HelloWorld {
    public static void main(String[] args) {
        File file = new File("/Users/edz/workspace/test001.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(file.exists());
    }
}
