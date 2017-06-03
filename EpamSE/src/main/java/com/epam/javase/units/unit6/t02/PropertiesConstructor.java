package com.epam.javase.units.unit6.t02;

import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertiesConstructor<K, V> {
    private Path path;
    private Map<String, String> prop = new HashMap<>();
    private Pattern pattern = Pattern.compile("^(\\w*)=+(.*)");

    public PropertiesConstructor(Path path) {
        this.path = path;
        load();
    }

    public PropertiesConstructor(String path) {
        this.path = getFile(path).toPath();
        load();
    }

    private void load(){
        try(BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            while(br.ready()){
                String line = br.readLine();
                Matcher matcher = pattern.matcher(line);
                if(matcher.find()) prop.put(matcher.group(1), matcher.group(2));
            }
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
        if(prop.containsKey(property)) {
            return prop.get(property);
        }
        else
            throw new NoSuchFieldError("Property " + property + " not found!");
    }

}
