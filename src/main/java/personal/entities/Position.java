package personal.entities;

import java.util.Objects;
import java.util.Random;

public class Position {

    private Integer maxX;
    private Integer maxY;

    private Integer currentX;
    private Integer currentY;

    /**
     * Create a new Position (X,Y) with defined X and Y limits.
     * 
     * @param maxX the maximum value that X can have
     * @param maxY the maximum value that Y can have
     * @param currentX the value of X
     * @param currentY the value of Y
     */

    public Position(Integer maxX, Integer maxY, Integer currentX, Integer currentY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.currentX = currentX;
        this.currentY = currentY;
    }

    /**
     * Generates a new random position within the bounds defined by maxX and maxY.
     * 
     * @param maxX the maximum value that X can have
     * @param maxY the maximum value that Y can have
     */

    public Position(Integer maxX, Integer maxY) {
        Random random = new Random();
        this.maxX = maxX;
        this.maxY = maxY;
        this.currentX = random.nextInt(maxX+1);
        this.currentY = random.nextInt(maxY+1);
    }

    public Position() {
    }
    public void setMaxX(Integer maxX) {
        this.maxX = maxX;
    }
    public void setMaxY(Integer maxY) {
        this.maxY = maxY;
    }

    public Position maxX(Integer maxX) {
        setMaxX(maxX);
        return this;
    }

    public Position maxY(Integer maxY) {
        setMaxY(maxY);
        return this;
    }

    /**
     * Increments the X postion by the received value, truncating it at minimal or maximum value;
     * 
     * @param valueToIncrementBy add this value to the current X
     * @return the altered postion
     */
    public Position incrementCurrentX(Integer valueToIncrementBy){
        Integer incrementedX = currentX + valueToIncrementBy;
        if(incrementedX < 0){
            incrementedX = 0;
        }else{
            if(incrementedX > maxX){
                incrementedX = maxX;
            }
        }
        currentX = incrementedX;

        return this;
    }

    /**
     * Increments the Y postion by the received value, truncating it at minimal or maximum value;
     * 
     * @param valueToIncrementBy add this value to the current Y
     * @return the altered postion
     */
    public Position incrementCurrentY(Integer valueToIncrementBy){
        Integer incrementedY = currentY + valueToIncrementBy;
        if(incrementedY < 0){
            incrementedY = 0;
        }else{
            if(incrementedY > maxX){
                incrementedY = maxX;
            }
        }
        currentY = incrementedY;

        return this;
    }

    public Integer getMaxX() {
        return this.maxX;
    }


    public Integer getMaxY() {
        return this.maxY;
    }

    public Integer getCurrentX() {
        return this.currentX;
    }

    public void setCurrentX(Integer currentX) {
        this.currentX = currentX;
    }

    public Integer getCurrentY() {
        return this.currentY;
    }

    public void setCurrentY(Integer currentY) {
        this.currentY = currentY;
    }

    public Position currentX(Integer currentX) {
        setCurrentX(currentX);
        return this;
    }

    public Position currentY(Integer currentY) {
        setCurrentY(currentY);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Position)) {
            return false;
        }
        Position position = (Position) o;
        return Objects.equals(currentX, position.currentX) && Objects.equals(currentY, position.currentY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxX, maxY, currentX, currentY);
    }

    @Override
    public String toString() {
        return "{" +
            " maxX='" + getMaxX() + "'" +
            ", maxY='" + getMaxY() + "'" +
            ", currentX='" + getCurrentX() + "'" +
            ", currentY='" + getCurrentY() + "'" +
            "}";
    }

    
}
