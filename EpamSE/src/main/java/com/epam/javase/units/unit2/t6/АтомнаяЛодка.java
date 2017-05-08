package com.epam.javase.units.unit2.t6;

public class АтомнаяЛодка {
    private ДвигательДляАтомнойЛодки engine;

    public АтомнаяЛодка() {
        this.engine = new ДвигательДляАтомнойЛодки();
    }

    class ДвигательДляАтомнойЛодки{
        public void startEngine(){
            System.out.println("Start engine!");
        }
    }

    public static void main(String[] args) {
        АтомнаяЛодка boat = new АтомнаяЛодка();
        boat.engine.startEngine();
    }

}
