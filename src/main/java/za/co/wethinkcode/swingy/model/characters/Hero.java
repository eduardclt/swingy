package za.co.wethinkcode.swingy.model.characters;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.swingy.controller.EnemyController;
import za.co.wethinkcode.swingy.controller.ValidatorFactoryController;
import za.co.wethinkcode.swingy.model.Character;
import za.co.wethinkcode.swingy.view.Map;

import java.io.IOException;
import java.util.Random;

@Getter
@Setter
public abstract class Hero extends Character {

    private String weapon;
    private String armour;
    private String helm;

    Hero(){

    }

    Hero(String name, String weapon, String armour, String helm, int attack, int defence){
        this.name = name;
        this.xp = 0;
        this.level = 0;
        this.weapon = weapon;
        this.armour = armour;
        this.helm = helm;
        this.attack = attack;
        this.defence = defence;
    }

    Hero(String name, int level, int xp, String weapon, String armour, String helm, int attack, int defence){
        this.name = name;
        this.level = level;
        this.xp = xp;
        this.weapon = weapon;
        this.armour = armour;
        this.helm = helm;
        this.attack = attack + level;
        this.defence = defence + level;
    }

    public static Hero newHero(String name, String type, int level, int xp, String weapon, String armour, String helm) {
        if (name.length() <= 4)
        {
            throw new RuntimeException("Name needs to be more than 4 characters");
        }
        if (!type.equalsIgnoreCase("sorcerer") && !type.equalsIgnoreCase("monk")
                && !type.equalsIgnoreCase("scout") ) {
            throw new RuntimeException("Type needs to be a Sorcerer, Monk, or a Scout");
        }
        switch (type) {
            case "Monk":
                return(new Monk(name, level, xp, weapon, armour, helm));
            case "Sorcerer":
                return(new Sorcerer(name, level, xp, weapon, armour, helm));
            case "Scout":
                return(new Scout(name, level, xp, weapon, armour, helm));
            default:
                System.out.println("Invalid Hero");
                return (null);
        }
    }

    public static Hero newHero(String name, String type){
        if (name.length() <= 4)
        {
            throw new RuntimeException("Name needs to be more than 4 characters");
        }
        if (!type.equalsIgnoreCase("sorcerer") && !type.equalsIgnoreCase("monk")
                && !type.equalsIgnoreCase("scout") ) {
            throw new RuntimeException("Type needs to be a Sorcerer, Monk, or a Scout");
        }
        switch (type) {
            case "Monk":
                return(new Monk(name));
            case "Sorcerer":
                return(new Sorcerer(name));
            case "Scout":
                return(new Scout(name));
            default:
                System.out.println("Invalid Hero");
                return (null);
        }
    }


    public void attack(Character character) {

        character.defend(this, this.attack);

    }

    public void defend(Character character, int damage) {
        int finalDamage = damage - this.getDefence();
        finalDamage = finalDamage < 0 ? 0 : finalDamage;
        this.hp -= finalDamage;
    }

    public boolean updateStats(Enemy en)
    {
        this.setXp((int)(this.getXp() + (10 * en.getAttack() * 0.1) + (this.level * 50)));
        boolean f = checkLevelUp();
        return(f);
    }

    public boolean checkLevelUp(){
        int i = this.getLevel() + 1;
        int xp = i * 1000 + ((i - 1)*(i - 1)) * 450;

        while (i < 10) {
            if(this.getXp() > xp) {
                this.setLevel(this.getLevel() + 1);
                this.setAttack(this.getAttack() + 1);
                this.setDefence(this.getDefence() + 1);
                return (true);
            }
            i++;
            xp = i * 1000 + ((i - 1)*(i - 1)) * 450;
        }
        return (false);

        }

    public void moveNorth(Map map, EnemyController enemyController){
        map.map[this.getX()][this.getY()] = " ";
        this.setX(this.getX() - 1);
        enemyController.moveEnemies(map);
        map.populateMap();
    }

    public void moveEast(Map map, EnemyController enemyController){
        map.map[this.getX()][this.getY()] = " ";
        this.setY(this.getY() + 1);
        enemyController.moveEnemies(map);
        map.populateMap();
    }

    public void moveSouth(Map map, EnemyController enemyController){
        map.map[this.getX()][this.getY()] = " ";
        this.setX(this.getX() + 1);
        enemyController.moveEnemies(map);
        map.populateMap();
    }
    public void moveWest(Map map, EnemyController enemyController){
        map.map[this.getX()][this.getY()] = " ";
        this.setY(this.getY() - 1);
        enemyController.moveEnemies(map);
        map.populateMap();
    }

    public String randomWeapon(Enemy en)
    {
        int i = 4;
        int random = new Random().nextInt(i);
        switch (random) {
            case 1:
                if (!(this.getWeapon().equals("Iron Sword"))){
                    this.setWeapon("Iron Sword");
                    this.setAttack(this.getAttack() + 5);
                    return (this.getWeapon());
                }
                else
                    return "";
            case 2:
                if (!(this.getArmour().equals("Iron Shield"))) {
                    this.setArmour("Iron Shield");
                    this.setDefence(this.getDefence() + 5);
                    return (this.getArmour());
                }
                else
                    return "";
            case 3:
                if(!(this.getHelm().equals("Iron Helmet"))) {
                    this.setHelm("Iron Helmet");
                    this.setHp(this.getHp() + 5);
                    return (this.getHelm());
                }
                else
                    return "";
                default:
                    return "";
            }
    }

}
