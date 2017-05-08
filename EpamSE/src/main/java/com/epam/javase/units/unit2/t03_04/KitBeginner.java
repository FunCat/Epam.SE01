package com.epam.javase.units.unit2.t03_04;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class KitBeginner {
    private static List<Stationery> template = new ArrayList<Stationery>();
    private static KitBeginner link;

    private KitBeginner() {
        template.add(new GraphitePencil(23.4f,3.3f, Pencil.typeShape.ROUND, "Koh-i-Noor ", GraphitePencil.typeSoftness.HB));
        template.add(new Eraser(34.5f, Eraser.typeSize.MEDIUM, Eraser.typeMaterial.RUBBER));
        template.add(new BallpointPen(15.3f, Color.BLACK, 1.2f, "Parker", BallpointPen.typeRefill.G2));
    }

    public static List<Stationery> getKitBeginnerTemplate() {
        if(link == null) link = new KitBeginner();
        return template;

    }

    public static KitBeginner getKitBeginner() {
        if(link == null) link = new KitBeginner();
        return link;
    }

    public static List<Stationery> addKitBeginnerTemplate(List<Stationery> list) {
        List<Stationery> newList = list;
        if(link == null) link = new KitBeginner();
        for (Stationery good : template) {
            newList.add(good);
        }
        return newList;
    }
}
