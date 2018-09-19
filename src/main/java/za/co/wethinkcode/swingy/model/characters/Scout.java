package za.co.wethinkcode.swingy.model.characters;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.swingy.model.Character;

@Getter
@Setter
public class Scout extends Hero{

    Scout(String name){
        super(name, "Wooden dagger","Leather vest", "Leather helm",30,19 );
    }

    Scout(String name, int level, int xp, String weapon, String armour, String helm)
    {
        super(name, level, xp, weapon, armour, helm, 30, 19);
    }


}
