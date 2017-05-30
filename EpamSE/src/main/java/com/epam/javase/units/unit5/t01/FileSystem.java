package com.epam.javase.units.unit5.t01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSystem {

    private String path;
    private String cpath;
    private String arg;

    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        if(args.length == 1){
            fs.path = args[0];
            File file = new File(fs.path);
            if(file.isFile())
                fs.readFile(file);
            else if(file.isDirectory())
                fs.readDirectory(file);
            else
                soutSyntax();
        }
        else if(args.length == 2){
            fs.arg = args[0];
            fs.path = args[1];
            if(!"-r".equals(fs.arg)){soutSyntax(); return;}
            File file = new File(fs.path);
            if(file.isFile())
                fs.removeFile(file);
            else
                soutSyntax();
        }
        else if(args.length == 3){
            fs.arg = args[0];
            fs.cpath = args[1];
            fs.path = args[2];
            if(!"-c".equals(fs.arg)){soutSyntax(); return;}
            File file = new File(fs.path);
            File cfile = new File(fs.cpath);
            if(file.isFile())
                fs.copyFile(file, cfile);
            else
                soutSyntax();
        }
        else{
            soutSyntax();
        }
    }

    public static void soutSyntax() {
        System.out.println("Error in the command syntax.\n\tjava [-c cpath] [-r] path");
        System.out.println("This program with no arguments shows the file or directory and all contents.");
        System.out.println("Arguments:\n\t[-c cpath] - copy file by the cpath.");
        System.out.println("\t[-r] - remove file.");
    }

    public void readFile(File file){
        System.out.println("File " + file.getName() + ":\n====== Start File ======");
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            while(br.ready()){
                System.out.println(br.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("======= End File =======");
    }

    public void readDirectory(File directory){
        File[] files = directory.listFiles();
        System.out.println("Directory " + directory.getName() + ":\n====== Start Directory ======");
        for (File file : files) {
            System.out.println("\t" + file.getName());
        }
        System.out.println("======= End Directory =======");
    }

    public void copyFile(File file, File cfile){
        if(cfile.exists()){
            System.out.println("This file already exists!");
            return;
        }
        Path from = file.toPath();
        Path to = cfile.toPath();
        System.out.println(to);
        try {
            Files.copy(from, to);
        } catch (IOException e) {
            System.out.println("Failed copying file! Check the syntax of command!");
            soutSyntax();
        }
        System.out.println("Successful copy file!");
    }

    public void removeFile(File file){
        Path path = file.toPath();
        try {
            Files.delete(path);
        } catch (IOException e) {
            System.out.println("Failed deleting file! Check the syntax of command!");
            soutSyntax();
        }
        System.out.println("Successful remove file!");
    }
}
