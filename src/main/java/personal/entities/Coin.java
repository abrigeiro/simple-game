package personal.entities;

import personal.entities.interfaces.Item;
import personal.graphics.SquareTile;
import personal.graphics.TileType;

public class Coin implements Item {

    private Position position;    
    private Integer value;

    public Coin(Position position) {
        this.position = position;
        this.value = 1;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getValue() {
        return value;
    }

    public void draw(){
        new SquareTile(position.getCurrentX(), position.getCurrentY(), 48, TileType.COIN).draw();
    }

}
