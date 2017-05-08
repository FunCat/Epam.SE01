package com.epam.javase.units.unit2.t03_04;

import java.util.Scanner;

public class Eraser  extends Stationery{
    enum typeSize{SMALL, MEDIUM, BIG};
    enum typeMaterial{RUBBER, SYNTHETIC, MECHANICAL};

    private typeSize size;
    private typeMaterial material;

    public Eraser(float price, typeSize size, typeMaterial material) {
        super(price, "Eraser");
        this.size = size;
        this.material = material;
    }

    @Override
    public String toString() {
        return "Eraser\n\tprice\t\t" + getPrice() +
                "\n\tsize\t\t" + size +
                "\n\tmaterial\t" + material;
    }

    public static Eraser createNewEraser(){
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Price: ");
            float price = sc.nextFloat();

            System.out.println("Type size: ");
            for (typeSize size : typeSize.values()) {
                System.out.println("[" + size.ordinal() + "] " + size.toString());
            }
            System.out.print("Enter a number of type size: ");
            int ordinal = sc.nextInt();
            typeSize size = typeSize.values()[ordinal];

            System.out.println("Type material: ");
            for (typeMaterial material : typeMaterial.values()) {
                System.out.println("[" + material.ordinal() + "] " + material.toString());
            }
            System.out.print("Enter a number of type material: ");
            ordinal = sc.nextInt();
            typeMaterial material = typeMaterial.values()[ordinal];

            return new Eraser(price, size, material);
        }
        catch(Exception ex){
            System.out.println("You entered the wrong value!");
            return null;
        }
    }

}
