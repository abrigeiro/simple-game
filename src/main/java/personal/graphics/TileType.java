package personal.graphics;

public enum TileType {

    BAG("personal/graphics/textures/bag64.png"),
    COIN("personal/graphics/textures/coin64.png"),
    DIRT("personal/graphics/textures/dirt64.png"),
    GRASS("personal/graphics/textures/grass64.png"),
    WATER("personal/graphics/textures/water64.png"),
    ENEMY("personal/graphics/textures/enemy64.png"),
    PLAYER_RED("personal/graphics/textures/player64_red.png"),
    PLAYER_GREEN("personal/graphics/textures/player64_green.png"),
    PLAYER_BLUE("personal/graphics/textures/player64_blue.png"),
    PLAYER_YELLOW("personal/graphics/textures/player64_yellow.png");

    String textureUri;

    TileType(String textureUri) {
        this.textureUri = textureUri;
    }
    
}
