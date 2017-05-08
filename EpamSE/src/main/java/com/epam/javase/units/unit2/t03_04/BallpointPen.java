package com.epam.javase.units.unit2.t03_04;

import java.awt.*;
import java.util.Scanner;

public class BallpointPen extends Pen{
    enum typeRefill{G2, D1};

    private typeRefill refill;

    public BallpointPen(float price, Color color, float width, String firm, typeRefill refill) {
        super(price, "BallpointPen", color, width, firm);
        this.refill = refill;
    }

    public typeRefill getRefill() {
        return refill;
    }

    public void setRefill(typeRefill refill) {
        this.refill = refill;
    }

    @Override
    public String toString() {
        return "BallpointPen\n\tprice\t\t" + getPrice() +
                "\n\tcolor\t\tR=" + getColor().getRed() +
                "; G=" + getColor().getGreen() +
                "; B=" + getColor().getBlue() +
                "\n\twidth\t\t" + getWidth() +
                "\n\tfirm\t\t" + getFirm() +
                "\n\ttype refill\t" + refill;
    }

    public static BallpointPen createNewBallpointPen(){
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

            System.out.println("Type refill: ");
            for (typeRefill refill : typeRefill.values()) {
                System.out.println("[" + refill.ordinal() + "] " + refill.toString());
            }
            System.out.print("Enter a number of type refill: ");
            int ordinal = sc.nextInt();
            typeRefill refill = typeRefill.values()[ordinal];

            return new BallpointPen(price, color, width, firm, refill);
        }
        catch(Exception ex){
            System.out.println("You entered the wrong value!");
            return null;
        }
    }
}
