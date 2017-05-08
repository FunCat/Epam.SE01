package com.epam.javase.units.unit2.t03_04;

import java.util.*;

public class Goods {
    private List<Stationery> listGoods = new ArrayList<Stationery>();
    private static PriceComparator priceComparator = new PriceComparator();
    private static NameComparator nameComparator = new NameComparator();
    private static BiComparator priceAndNameComparator = new BiComparator(priceComparator, nameComparator);

    public static void main(String[] args) {
        Goods myGoods = new Goods();
        readCommand(myGoods);
    }

    /** Add a new good at the listGoods */
    public void addNewGood(){
        System.out.println("Choose a thing:");
        System.out.println("[1] FountainPen");
        System.out.println("[2] BallpointPen");
        System.out.println("[3] GraphitePencil");
        System.out.println("[4] ColoredPencil");
        System.out.println("[5] Eraser");
        System.out.println("[6] Cancel");
        System.out.print("Enter the index of thing: ");
        Scanner line = new Scanner(System.in);
        int id = line.nextInt();
        if(id == 6) return;
        Stationery good = null;
        switch(id){
            case 1:
                good = FountainPen.createNewFountainPen();
                break;
            case 2:
                good = BallpointPen.createNewBallpointPen();
                break;
            case 3:
                good = GraphitePencil.createNewGraphitePencil();
                break;
            case 4:
                good = ColoredPencil.createNewColoredPencil();
                break;
            case 5:
                good = Eraser.createNewEraser();
                break;
        }
        if(good == null) return;
        listGoods.add(good);
    }

    /** Remove the good form listGoods by index */
    public void removeGood(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the index: ");
        int index = sc.nextInt();
        if(index < 1 || index > listGoods.size()) {
            System.out.println("Thing with this index is absent!");
            return;
        }
        System.out.println("Thing successfully deleted!");
        listGoods.remove(index - 1);
    }

    /** Count the total price of all the goods */
    public float countTotalPrice(){
        float res = 0.0f;
        for (Stationery good : listGoods) {
            res += good.getPrice();
        }
        return res;
    }


    /** Watch all goods in the listGoods */
    public void watchListGoods(){
        System.out.println("================= List goods ====================");
        int count = 1;
        for (Stationery good : listGoods) {
            System.out.println(count++ + ") " + good);
            System.out.println("=================================================");
        }
        System.out.println("Total price = " + this.countTotalPrice());
        System.out.println("=================================================");
    }

    /** Sorting listGoods by price */
    public void sortByPrice(){
        Collections.sort(listGoods, priceComparator);
        System.out.println("End of sorting!");
    }

    /** Sorting listGoods by name */
    public void sortByName(){
        Collections.sort(listGoods, nameComparator);
        System.out.println("End of sorting!");
    }

    /** Sorting listGoods by price and name */
    public void sortByPriceAndName(){
        Collections.sort(listGoods, priceAndNameComparator);
        System.out.println("End of sorting!");
    }

    /** Wait for a command in the console */
    public final static void readCommand(Goods goods){
        while (true){
            System.out.println("Enter the command number:");
            System.out.println("[1] Add a new thing");
            System.out.println("[2] Remove the thing by its index");
            System.out.println("[3] Watch the list of things");
            System.out.println("[4] Add things from Kit Beginner");
            System.out.println("[5] Sort things by price");
            System.out.println("[6] Sort things by name");
            System.out.println("[7] Sort things by price and name");
            System.out.println("[8] Exit");
            System.out.print("Command number: ");
            Scanner sc = new Scanner(System.in);
            int commandNumber = sc.nextInt();
            System.out.println();
            if(commandNumber == 8) break;
            switch(commandNumber){
                case 1:
                    goods.addNewGood();
                    break;
                case 2:
                    goods.removeGood();
                    break;
                case 3:
                    goods.watchListGoods();
                    break;
                case 4:
                    goods.listGoods = KitBeginner.addKitBeginnerTemplate(goods.listGoods);
                    System.out.println("Template successfully added!");
                    break;
                case 5:
                    goods.sortByPrice();
                    break;
                case 6:
                    goods.sortByName();
                    break;
                case 7:
                    goods.sortByPriceAndName();
                    break;
                default:
                    System.out.println("You enter the wrong command number! Try again!");
            }
            System.out.println();
        }
    }
}

class PriceComparator implements Comparator<Stationery> {

    public int compare(Stationery o1, Stationery o2) {
        return (int)(o1.getPrice() - o2.getPrice());
    }
}

class NameComparator implements Comparator<Stationery> {

    public int compare(Stationery o1, Stationery o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class BiComparator implements Comparator<Stationery>{
    private Comparator<Stationery> com1;
    private Comparator<Stationery> com2;


    public BiComparator(Comparator<Stationery> priceComparator, Comparator<Stationery> nameComparator) {
        this.com1 = priceComparator;
        this.com2 = nameComparator;
    }

    public int compare(Stationery o1, Stationery o2) {
        int res = com1.compare(o1, o2);
        if(res == 0)
            com2.compare(o1, o2);
        return res;
    }
}