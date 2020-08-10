package org.robby;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class Util {
    public static String readFile(String fileName){
        Class clazz = Answer.class;
        File file = new File(clazz.getClassLoader().getResource(fileName).getFile());

        try {
            return FileUtils.readFileToString(file, "utf-8");
        } catch (IOException e) {
            return null;
        }
    }

    public static String readFileToBase64(String fileName){
        String content = readFile(fileName);
        return Base64.getEncoder().encodeToString(content.getBytes());
    }

    public static void main(String[] args) {
        System.out.println(readFile("1.txt"));
    }
}
