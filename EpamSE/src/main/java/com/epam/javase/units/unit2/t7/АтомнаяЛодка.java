package com.epam.javase.units.unit2.t7;

import java.lang.annotation.Documented;

public class АтомнаяЛодка {
    private ДвигательДляАтомнойЛодки engine;

    public АтомнаяЛодка() {
        this.engine = new ДвигательДляАтомнойЛодки();
    }

    @Author(
        name = "Petrov Sergey",
        date = "08/05/2017"
    )
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
