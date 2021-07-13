package personal.graphics;

import java.util.Objects;

import org.newdawn.slick.opengl.Texture;

import personal.graphics.helper.Graphics;

public class SquareTile {

    private float x, y, side;
    private Texture texture;
    private TileType type;

    public SquareTile(float x, float y, float side, TileType tileType) {
        this.x = x;
        this.y = y;
        this.side = side;
        this.type = tileType;
        this.texture = Graphics.loadTexture(tileType.textureUri, "PNG");
    }

    public SquareTile() {
    }

    public SquareTile(float x, float y, float side, Texture texture, TileType type) {
        this.x = x;
        this.y = y;
        this.side = side;
        this.texture = texture;
        this.type = type;
    }
    public void setSide(float side) {
        this.side = side;
    }

    public SquareTile x(float x) {
        setX(x);
        return this;
    }

    public SquareTile y(float y) {
        setY(y);
        return this;
    }

    public SquareTile side(float side) {
        setSide(side);
        return this;
    }

    public SquareTile texture(Texture texture) {
        setTexture(texture);
        return this;
    }

    public SquareTile type(TileType type) {
        setType(type);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SquareTile)) {
            return false;
        }
        SquareTile squareTile = (SquareTile) o;
        return x == squareTile.x && y == squareTile.y && side == squareTile.side && Objects.equals(texture, squareTile.texture) && Objects.equals(type, squareTile.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, side, texture, type);
    }

    @Override
    public String toString() {
        return "{" +
            " x='" + getX() + "'" +
            ", y='" + getY() + "'" +
            ", side='" + getSide() + "'" +
            ", texture='" + getTexture() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }

    public void draw(){
        Graphics.drawTextureSquare(x, y, side, side, texture);
    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSide() {
        return this.side;
    }
    
    public Texture getTexture() {
        return this.texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public TileType getType() {
        return this.type;
    }

    public void setType(TileType type) {
        this.type = type;
    }
}
