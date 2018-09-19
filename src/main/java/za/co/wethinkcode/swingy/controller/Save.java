package za.co.wethinkcode.swingy.controller;

import za.co.wethinkcode.swingy.model.characters.Hero;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Save {
    public static PrintWriter writer;


    public void saveNewHero(Hero hero){
        try {
            writer = new PrintWriter(new FileOutputStream("heroes.txt", true));

        } catch (IOException exc){
            System.out.println("There was a problem writing to the file");
            System.out.println(exc.toString());
        }

        writer.println(hero.getName() + "," + hero.getClass().getSimpleName() + "," +
                hero.getLevel() + "," + hero.getXp() + "," + hero.getWeapon() + "," +
                hero.getArmour() + "," + hero.getHelm());

        writer.close();
    }

    public void saveGame(List<Hero> heroes){
        try {
            writer = new PrintWriter(new FileOutputStream("heroes.txt"));

        } catch (IOException exc){
            System.out.println("There was a problem writing to the file");
            System.out.println(exc.toString());
        }

        for (Hero hero:heroes) {
            writer.println(hero.getName() + "," + hero.getClass().getSimpleName() + "," +
                    hero.getLevel() + "," + hero.getXp() + "," + hero.getWeapon() + "," +
                    hero.getArmour() + "," + hero.getHelm());
        }
        writer.close();
    }
}
