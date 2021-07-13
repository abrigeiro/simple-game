package personal.graphics;

public class Gamezone {    

    //Bydimensional array with pre-defined size assures continuous memory and predictable access time
    private SquareTile[][] map;
    private final int tileSize;
    private final int mapWidthInTiles;
    private final int mapHeightInTiles;

    public Gamezone(int tileSize, int gmzWidthInTiles, int gmzHeightInTiles) {        
        this.tileSize = tileSize;
        this.mapWidthInTiles = gmzWidthInTiles;
        this.mapHeightInTiles = gmzHeightInTiles;

        map = new SquareTile[gmzWidthInTiles][gmzHeightInTiles];
        for ( int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++) {
                map [i][j] = new SquareTile(i * tileSize,j * tileSize, tileSize, TileType.GRASS);
            }
        }
    }

    public void draw(){
        for ( SquareTile[] line : map){
            for (SquareTile tile : line) {
                tile.draw();
            }
        }
    }

    public void setTile(int xCord, int yCord, TileType tileType){
        if (isValidPosition(xCord, yCord)){
            map[xCord][yCord] = new SquareTile(xCord*tileSize, yCord*tileSize, tileSize, tileType);
        }
    }

    public SquareTile setTile(int xCord, int yCord){
        return map[xCord][yCord];
    }

    public int getGamezoneWidth(){
        return mapWidthInTiles;
    }

    public int getGamezoneHeight(){
        return mapHeightInTiles;
    }

    public int getTileSize(){
        return tileSize;
    }

    public boolean isValidPosition(int xCord, int yCord){
        return (0 < xCord && xCord < mapWidthInTiles) && (0 < yCord && yCord < mapHeightInTiles);
    }
}
