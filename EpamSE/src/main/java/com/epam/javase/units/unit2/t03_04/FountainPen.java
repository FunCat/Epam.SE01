package com.epam.javase.units.unit2.t03_04;

import java.awt.*;
import java.util.Scanner;

public class FountainPen extends  Pen {
    enum typeNibs{OBLIQUE, REVERSE_OBLIQUE, STUB, ITALIC, DEGREE360};
    enum typeFilling{EYEDROPPER, SELF_FILLING, PISTON_FILLING, MODERN_FILLING};

    private typeNibs nib;
    private typeFilling filling;


    public FountainPen(float price, Color color, float width, String firm, typeNibs nib, typeFilling filling) {
        super(price, "FountainPen", color, width, firm);
        this.nib = nib;
        this.filling = filling;
    }

    public typeNibs getNib() {
        return nib;
    }

    public void setNib(typeNibs nib) {
        this.nib = nib;
    }

    public typeFilling getFilling() {
        return filling;
    }

    public void setFilling(typeFilling filling) {
        this.filling = filling;
    }

    @Override
    public String toString() {
        return "FountainPen\n\tprice\t\t" + getPrice() +
                "\n\tcolor\t\tR=" + getColor().getRed() +
                "; G=" + getColor().getGreen() +
                "; B=" + getColor().getBlue() +
                "\n\twidth\t\t" + getWidth() +
                "\n\tfirm\t\t" + getFirm() +
                "\n\ttype nib\t\t" + nib +
                "\n\ttype filling\t" + filling;
    }

    public static FountainPen createNewFountainPen(){
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Price: ");
            float price = sc.nextFloat();

            System.out.print("Color: R - ");
            int r = sc.nextInt();
            System.out.print(" G - ");
            int g = sc.nextInt();
            System.out.print(" B - ");
            int b = sc.nextInt();
            Color color = new Color(r,g,b);

            System.out.print("Width: ");
            float width = sc.nextFloat();

            System.out.print("Firm: ");
            String firm = sc.nextLine();
            firm = sc.nextLine();

            System.out.println("Type nib: ");
            for (typeNibs nibs : typeNibs.values()) {
                System.out.println("[" + nibs.ordinal() + "] " + nibs.toString());
            }
            System.out.print("Enter a number of type nibs: ");
            int ordinal = sc.nextInt();
            typeNibs nibs = typeNibs.values()[ordinal];

            System.out.println("Type filling: ");
            for (typeFilling filling : typeFilling.values()) {
                System.out.println("[" + filling.ordinal() + "] " + filling.toString());
            }
            System.out.print("Enter a number of type filling: ");
            ordinal = sc.nextInt();
            typeFilling filling = typeFilling.values()[ordinal];

            return new FountainPen(price, color, width, firm, nibs, filling);
        }
        catch(Exception ex){
            System.out.println("You entered the wrong value!");
            return null;
        }
    }
}
