package com.epam.javase.units.unit5.t02;

import java.io.*;
import java.nio.file.Path;
import java.util.Properties;

public class PropertiesConstructor {

    private Path path;
    private Properties prop = new Properties();

    public PropertiesConstructor(Path path) {
        this.path = path;
        load();
    }

    public PropertiesConstructor(String path) {
        this.path = getFile(path).toPath();
        load();
    }

    private void load(){
        try(InputStream input = new FileInputStream(path.toFile())) {
            prop.load(input);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFile(String path){
        File file;
        try {
            file = new File(PropertiesReader.class.getResource(path).getFile());
        }
        catch(NullPointerException e){
            throw new NullPointerException("Properties file " + path + " not found!");
        }
        return file;
    }

    public String getProperty(String property){
        String res =  prop.getProperty(property);
        if(res == null){
            throw new NoSuchFieldError("Property " + property + " not found!");
        }
        return res;
    }
}
