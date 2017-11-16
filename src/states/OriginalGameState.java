package states;

import entities.Entity;
import entities.Snake;

import java.awt.*;

public class OriginalGameState extends State {

    public OriginalGameState(){
        addEntity(new Snake(0,0,150,150));
    }
}
