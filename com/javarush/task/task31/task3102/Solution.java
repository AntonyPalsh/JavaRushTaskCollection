package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new ArrayList<>();
        List<Path> files = Files.walk(Paths.get(root))
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());

        for (Path file : files) {
            list.add(file.toString());
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
