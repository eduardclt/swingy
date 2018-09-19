package za.co.wethinkcode.swingy.model.characters;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.swingy.model.Character;

@Getter
@Setter
public class Monk extends Hero{

    Monk(String name){
        super(name, "Wooden Mace", "Robe", "Material hood", 34, 16);
    }

    Monk(String name, int level, int xp, String weapon, String armour, String helm)
    {
        super(name, level, xp, weapon, armour, helm, 34, 16);
    }


}
