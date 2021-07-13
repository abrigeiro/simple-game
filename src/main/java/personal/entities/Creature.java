package personal.entities;

import java.util.Objects;
import java.util.Random;

import personal.entities.interfaces.Entity;
import personal.graphics.SquareTile;

public class Creature implements Entity{

    private Position position;
    private float size;
    private SquareTile tile;
    private static Random random = new Random();

    public Creature() {
    }

    public Creature(Creature creature){
        this.position = creature.getPosition();
        this.size = creature.getSize();
        this.tile = creature.getTile();
    }
    
    public void update() {        
        tile.setX(position.getCurrentX() * size);
        tile.setY(position.getCurrentY() * size);
    }

    public Creature(Position position, float size, SquareTile tile) {
        this.position = position;
        this.size = size;
        this.tile = tile;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public float getSize() {
        return this.size;
    }

    public SquareTile getTile() {
        return this.tile;
    }

    public void setTile(SquareTile tile) {
        this.tile = tile;
    }

    public Creature position(Position position) {
        setPosition(position);
        return this;
    }

    public Creature tile(SquareTile tile) {
        setTile(tile);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Creature)) {
            return false;
        }
        Creature creature = (Creature) o;
        return Objects.equals(position, creature.position) && size == creature.size && Objects.equals(tile, creature.tile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, size, tile);
    }

    @Override
    public String toString() {
        return "{" +
            " position='" + getPosition() + "'" +
            ", size='" + getSize() + "'" +
            ", tile='" + getTile() + "'" +
            "}";
    }

    public void moveLeft(){
        position.incrementCurrentX(-1);
    }

    public void moveRight(){
        position.incrementCurrentX(1);
    }

    public void moveUp(){
        //this seems counter intuitive but the windows grows down
        position.incrementCurrentY(-1);
    }

    public void moveDown(){
        //this seems counter intuitive but the windows grows down
        position.incrementCurrentY(1);
    }

    /**
     * Draws the object in the grid;
     */
    public void draw(){
        tile.draw();
    }

    public void randomMove() {
        switch (random.nextInt(4)) {
            case 0:
                moveLeft();
                break;
            case 1:
                moveRight();
                break;
            case 2:
                moveUp();
                break;                
            case 3:
                moveDown();
                break;
            default:
                randomMove();
                break;
        }
    }
}
