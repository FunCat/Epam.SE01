package com.epam.javase.units.unit2.t03_04;

import java.util.Scanner;

public class GraphitePencil extends Pencil {
    enum typeSoftness{H9, H8, H7, H6, H5, H4, H3, H2, H1, H, F, HB, B, B2, B3, B4, B5, B6, B7, B8, B9};

    private typeSoftness softness;

    public GraphitePencil(float price, float diameter, typeShape shape, String firm, typeSoftness softness) {
        super(price, "GraphitePencil", diameter, shape, firm);
        this.softness = softness;
    }

    @Override
    public String toString() {
        return "GraphitePencil\n\tprice\t\t" + getPrice() +
                "\n\tdiameter\t" + getDiameter() +
                "\n\tshape\t\t" + getShape() +
                "\n\tfirm\t\t" + getFirm() +
                "\n\tsoftness\t" + softness;
    }

    public static GraphitePencil createNewGraphitePencil(){
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Price: ");
            float price = sc.nextFloat();

            System.out.print("Diameter: ");
            float diameter = sc.nextFloat();

            System.out.println("Type shape: ");
            for (typeShape shape : typeShape.values()) {
                System.out.println("[" + shape.ordinal() + "] " + shape.toString());
            }
            System.out.print("Enter a number of type shape: ");
            int ordinal = sc.nextInt();
            typeShape shape = typeShape.values()[ordinal];

            System.out.print("Firm: ");
            String firm = sc.nextLine();
            firm = sc.nextLine();

            System.out.println("Type softness: ");
            for (typeSoftness soft : typeSoftness.values()) {
                System.out.println("[" + soft.ordinal() + "] " + soft.toString());
            }
            System.out.print("Enter a number of type softness: ");
            ordinal = sc.nextInt();
            typeSoftness softness = typeSoftness.values()[ordinal];

            return new GraphitePencil(price, diameter, shape, firm, softness);
        }
        catch(Exception ex){
            System.out.println("You entered the wrong value!");
            return null;
        }
    }
}
