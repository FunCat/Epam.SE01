package com.epam.javase.units.unit5.t02;

import java.nio.file.Path;

public class PropertiesReader{

    static PropertiesConstructor pc;

    public PropertiesReader(Path path) {
        pc = new PropertiesConstructor(path);
    }

    public PropertiesReader(String path) {
        pc = new PropertiesConstructor(path.toString());
    }

    public static void main(String[] args) {
        PropertiesReader pr = new PropertiesReader("config.properties");

        System.out.println(pr.getBoolean("varBoolean"));
        System.out.println(pr.getByte("varByte"));
        System.out.println(pr.getShort("varShort"));
        System.out.println(pr.getInt("varInt"));
        System.out.println(pr.getLong("varLong"));
        System.out.println(pr.getFloat("varFloat"));
        System.out.println(pr.getDouble("varDouble"));
        System.out.println(pr.getChar("varChar"));
        System.out.println(pr.getString("varString"));

    }



    public boolean getBoolean(String property){
        String res = pc.getProperty(property);
        if(!res.toLowerCase().equals("true") && !res.toLowerCase().equals("false"))
            throw new ClassCastException("Property '" + property + "' can't be converted to boolean.");
        boolean returnValue = false;
        returnValue = Boolean.parseBoolean(res);
        return returnValue;
    }

    public byte getByte(String property){
        String res = pc.getProperty(property);
        byte returnValue = 0;
        try {
            returnValue = Byte.parseByte(res);
        }
        catch(NumberFormatException e)
        {
            throw new NumberFormatException("Property '" + property + "' can't be converted to byte.");
        }
        return returnValue;
    }

    public short getShort(String property){
        String res = pc.getProperty(property);
        short returnValue = 0;
        try {
            returnValue = Short.parseShort(res);
        }
        catch(NumberFormatException e)
        {
            throw new NumberFormatException("Property '" + property + "' can't be converted to short.");
        }
        return returnValue;
    }

    public int getInt(String property){
        String res = pc.getProperty(property);
        int returnValue = 0;
        try {
            returnValue = Integer.parseInt(res);
        }
        catch(NumberFormatException e)
        {
            throw new NumberFormatException("Property '" + property + "' can't be converted to int.");
        }
        return returnValue;
    }

    public long getLong(String property){
        String res = pc.getProperty(property);
        long returnValue = 0;
        try {
            returnValue = Long.parseLong(res);
        }
        catch(NumberFormatException e)
        {
            throw new NumberFormatException("Property '" + property + "' can't be converted to long.");
        }
        return returnValue;
    }

    public float getFloat(String property){
        String res = pc.getProperty(property);
        float returnValue = 0;
        try {
            returnValue = Float.parseFloat(res);
        }
        catch(NumberFormatException e)
        {
            throw new NumberFormatException("Property '" + property + "' can't be converted to float.");
        }
        return returnValue;
    }

    public double getDouble(String property){
        String res = pc.getProperty(property);
        double returnValue = 0;
        try {
            returnValue = Double.parseDouble(res);
        }
        catch(NumberFormatException e)
        {
            throw new NumberFormatException("Property '" + property + "' can't be converted to double.");
        }
        return returnValue;
    }

    public char getChar(String property){
        String res = pc.getProperty(property);
        char returnValue = ' ';
        try {
            returnValue = res.charAt(0);
        }
        catch(NumberFormatException e)
        {
            throw new NumberFormatException("Property '" + property + "' can't be converted to char.");
        }
        return returnValue;
    }

    public String getString(String property){
        return pc.getProperty(property);
    }
}
