package za.co.wethinkcode.swingy.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public abstract class Character {

    @NotNull
    public String name;
    public String type;
    @Min(0)
    protected int attack;
    @Min(0)
    protected int defence;
    @Min(0)
    protected int hp;

    @Min(0)
    protected int x;
    @Min(0)
    protected int y;

    @Min(0)
    @Max(10)
    public int level;

    @Min(0)
    @Max(15000)
    public int xp;

    public Character(){
        this.hp = 100;
    }

    abstract public void attack(Character character);
    abstract public void defend(Character character, int damage);
}
