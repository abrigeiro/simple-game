package personal;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

import org.lwjgl.opengl.Display;
import org.lwjgl.input.Keyboard;

import personal.entities.Bag;
import personal.entities.Coin;
import personal.entities.Creature;
import personal.entities.Player;
import personal.entities.Position;
import personal.entities.interfaces.Item;
import personal.graphics.Gamezone;
import personal.graphics.SquareTile;
import personal.graphics.TileType;
import personal.graphics.helper.Graphics;


public class App {
    
        private static final Integer TILE_SIZE = 48;
        private static final Integer WIDTH_IN_TILES = 15;
        private static final Integer HEIGHT_IN_TILES = 15;
        private static final Integer NUMBER_OF_MOBS = 5;
        private static final Integer NUMBER_OF_ITEMS = 7;

    public App(){

        ArrayList<Creature> enemies;
        LinkedList<Item> items;
        Bag bag;
        Player player;

        //InitializeScreen and Game Zone
        Graphics.initializeScreen(TILE_SIZE*WIDTH_IN_TILES, TILE_SIZE*HEIGHT_IN_TILES);
        Gamezone grid = new Gamezone(TILE_SIZE, WIDTH_IN_TILES, HEIGHT_IN_TILES);
        
        enemies = createEnemies(NUMBER_OF_MOBS);
        items = createItems(NUMBER_OF_ITEMS);

        Position position = new Position(WIDTH_IN_TILES-1, HEIGHT_IN_TILES-1);
        player = new Player(position, TILE_SIZE, new SquareTile(position.getCurrentX(), position.getCurrentY(), TILE_SIZE, TileType.PLAYER_BLUE));

        position = new Position(WIDTH_IN_TILES-1, HEIGHT_IN_TILES-1);
        Creature enemy = new Creature(position, TILE_SIZE, new SquareTile(position.getCurrentX(), position.getCurrentY(), TILE_SIZE, TileType.ENEMY));

        while (!Display.isCloseRequested()){
            
            while (Keyboard.next()){                
                if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
                    player.moveLeft();
                    break;
                }
                if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
                    player.moveRight();
                    break;
                }
                if(Keyboard.isKeyDown(Keyboard.KEY_UP)) {
                    player.moveUp();
                    break;
                }
                if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
                    player.moveDown();
                    break;
                }
                enemy.randomMove();
            }

            player.update();
            enemy.update();
                        
            grid.draw();
            enemy.draw();
            player.draw();

            Display.update();
            Display.sync(60);
        }

        Display.destroy();
    }

    private LinkedList<Item> createItems(Integer numberOfItems) {
        LinkedList<Item> items = new LinkedList<>();
        for(int i=0; i < numberOfItems; i++){
            items.add(new Coin(new Position(WIDTH_IN_TILES-1, HEIGHT_IN_TILES-1)));            
        }
        return items;
    }

    private ArrayList<Creature> createEnemies(Integer numberOfMobs) {
        ArrayList<Creature> creatures = new ArrayList<>();
        Position position;
        for(int i=0; i < numberOfMobs; i++){
            position = new Position(WIDTH_IN_TILES-1, HEIGHT_IN_TILES-1);
            creatures.add(new Creature(position, TILE_SIZE, new SquareTile(position.getCurrentX(), position.getCurrentY(), TILE_SIZE, TileType.ENEMY)));
        }
        return creatures;
    }

    public static void main(String[] args) throws Exception {
        final String userDir = System.getProperty("user.dir");
        final String nativeLibDir = userDir + File.separator + "lib" + File.separator + "native" + File.separator;
        System.setProperty("org.lwjgl.librarypath", nativeLibDir);
        new App();
    }
}

