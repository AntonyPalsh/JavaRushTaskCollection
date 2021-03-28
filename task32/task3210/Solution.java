package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws Exception {
        RandomAccessFile file = new RandomAccessFile(args[0], "wr");

        file.seek(Long.parseLong(args[1]));
        byte[] b = new byte[args[2].length()];
        file.read(b, 0, args[2].length());
        file.seek(file.length());
        String str = new String(b);
        if (str.equals(args[2])) file.write("true".getBytes());
        else file.write("false".getBytes());
    }
}
