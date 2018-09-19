package za.co.wethinkcode.swingy.model.artifacts;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.swingy.model.Artifact;

@Getter
@Setter
public class Armour extends Artifact {

    private int defence;

    public Armour(String name, int defence) {
        super(name);
        this.type = "Armour";
        this.defence = defence;
    }
}
