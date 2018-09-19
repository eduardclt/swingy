package za.co.wethinkcode.swingy.model.characters;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.swingy.model.Character;

@Getter
@Setter
public class Sorcerer extends Hero{

    Sorcerer(String name){
        super(name, "Wooden wand", "Leather chest plate", "Leather hat",36,14);
    }

    Sorcerer(String name, int level, int xp, String weapon, String armour, String helm)
    {
        super(name, level, xp, weapon, armour, helm, 36, 14 );
    }


}
