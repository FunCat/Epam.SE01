package com.epam.javase.units.unit2.t03_04;

import java.util.Scanner;

public class ColoredPencil extends Pencil {
    enum typePencil {WATERCOLOR, PASTEL};

    int countPencils;
    private typePencil type;

    public ColoredPencil(float price, float diameter, typeShape shape, String firm, int countPencils, typePencil type) {
        super(price, "ColoredPencil", diameter, shape, firm);
        this.countPencils = countPencils;
        this.type = type;
    }

    @Override
    public String toString() {
        return "ColoredPencil\n\tprice\t\t" + getPrice() +
                "\n\tdiameter\t" + getDiameter() +
                "\n\tshape\t\t" + getShape() +
                "\n\tfirm\t\t" + getFirm() +
                "\n\tcount\t\t" + countPencils +
                "\n\ttype\t\t" + type;
    }

    public static ColoredPencil createNewColoredPencil(){
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

            System.out.print("Counts pencil: ");
            int counts = sc.nextInt();

            System.out.println("Type pencil: ");
            for (typePencil type : typePencil.values()) {
                System.out.println("[" + type.ordinal() + "] " + type.toString());
            }
            System.out.print("Enter a number of type pencil: ");
            ordinal = sc.nextInt();
            typePencil type = typePencil.values()[ordinal];

            return new ColoredPencil(price, diameter, shape, firm, counts, type);
        }
        catch(Exception ex){
            System.out.println("You entered the wrong value!");
            return null;
        }
    }
}
