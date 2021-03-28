package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws Exception {
        RandomAccessFile file = new RandomAccessFile(args[0], "wr");

        if (Integer.parseInt(args[1]) > file.length()) file.seek(file.length());
        else file.seek(Long.parseLong(args[1]));

        file.write(args[2].getBytes());
        file.close();
    }
}
