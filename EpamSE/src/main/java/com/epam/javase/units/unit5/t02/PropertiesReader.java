package com.epam.javase.units.unit5.t02;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesReader {

    private Path path;
    private Properties prop = new Properties();

    public PropertiesReader(Path path) {
        this.path = path;
        load();
    }

    public PropertiesReader(String path) {
        this.path = getFile(path).toPath();
        load();
    }

    public static void main(String[] args) {
        PropertiesReader pr = new PropertiesReader("config.properties");
        System.out.println("ex1 = " + pr.getProperty("ex1"));
        System.out.println(pr.getProperty("ex4"));

    }

    public void load(){
        try(InputStream input = new FileInputStream(path.toFile())) {
            prop.load(input);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File getFile(String path){
        File file = null;
        try {
            file = findFile(path);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(3);
        }
        return file;
   }

    public static File findFile(String path) throws FileNotFoundException {
        File file;
        try {
            file = new File(PropertiesReader.class.getResource(path).getFile());
        }
        catch(NullPointerException e){
            throw new FileNotFoundException("Properties file " + path + " not found!");
        }
        return file;
    }


    public String getProperty(String property){
        String res = "";
        try {
            res = findProperty(property);
        }
        catch (NoSuchFieldError e){
            System.out.println(e.getMessage());
        }
        return res;
    }

    public String findProperty(String property){
        String res =  prop.getProperty(property);
        if(res == null){
            throw new NoSuchFieldError("Property " + property + " not found!");
        }
        return res;
    }
}
