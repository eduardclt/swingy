package za.co.wethinkcode.swingy.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public abstract class Artifact {

    @NotNull
    public String name;
    public String type;

    public Artifact(String name) {
        this.name = name;
    }
}
