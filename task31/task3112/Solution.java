package com.javarush.task.task31.task3112;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
C:\Temp
D:/MyDownloads
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {


        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();

        String[] nameFileArray = url.getFile().split("/");
        String nameFile = nameFileArray[nameFileArray.length - 1];

        Path tempFile = Files.createTempFile("temp-",".tmp");
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);

        return Files.move(tempFile, downloadDirectory.resolve(nameFile));
    }
}
