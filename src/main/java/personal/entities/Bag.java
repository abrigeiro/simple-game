package personal.entities;

import java.util.LinkedList;
import java.util.List;

import personal.entities.interfaces.Item;
import personal.graphics.SquareTile;

public class Bag implements Item {

    private Position position;
    private SquareTile tile;
    private LinkedList<Item> content;

    public Bag(Position position, SquareTile tile) {
        this.position = position;
        this.tile = tile;
        this.content = new LinkedList<>();
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Item> getContent() {
        return content;
    }

    public void addItem(Item item) {
        content.add(item);
    }

    public void draw(){
        tile.draw();
    }
    
}
