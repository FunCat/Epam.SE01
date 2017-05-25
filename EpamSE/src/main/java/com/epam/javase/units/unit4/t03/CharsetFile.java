package com.epam.javase.units.unit4.t03;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CharsetFile {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(CharsetFile.class.getResource("testFile.txt").getFile()), "UTF-8"));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./src/main/resources/com/epam/javase/units/unit4/t03/testFileUTF-16.txt"), "UTF-16")); ) {
            char[] buffer = new char[10000];
            int read;
            while ((read = br.read(buffer)) != -1)
                bw.write(buffer, 0, read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
