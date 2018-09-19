package za.co.wethinkcode.swingy.model.artifacts;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.swingy.model.Artifact;

@Getter
@Setter
public class Helm extends Artifact {
    private int hp;

    public Helm(String name, int hp) {
        super(name);
        this.type = "Helm";
        this.hp = hp;
    }
}
