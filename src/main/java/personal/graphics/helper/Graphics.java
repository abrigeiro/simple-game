package personal.graphics.helper;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.util.ResourceLoader;
import org.newdawn.slick.opengl.TextureLoader;

import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;
import java.io.InputStream;

public class Graphics {
    
    public static void initializeScreen(int SCREEN_WIDTH , int SCREEN_HEIGHT){
        Display.setTitle("Fantastic Hero");
        try {
            Display.setDisplayMode(new DisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, SCREEN_WIDTH, SCREEN_HEIGHT, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
    }

    public static void drawSquare(float x, float y, float widht, float height){
        glBegin(GL_QUADS);
        glVertex2f(x, y); //top left
        glVertex2f(x + widht, y); //top right
        glVertex2f(x + widht, y + height); //bottom right
        glVertex2f(x, y + height); //bottom left
        glEnd();
    }

    public static void drawTextureSquare(float x, float y, float widht, float height, Texture texture){
        texture.bind();
        glTranslatef(x, y, 0);//2D no need for z, this also sets the square to begin in x,y so all other below positions are in relation to this
        glBegin(GL_QUADS);

        //top left
        glTexCoord2f(0, 0);
        glVertex2f(0, 0);
        //top right
        glTexCoord2f(1, 0);
        glVertex2f(widht, 0);
        //bottom right
        glTexCoord2f(1, 1);
        glVertex2f(widht,height);
        //bottom left
        glTexCoord2f(0, 1);
        glVertex2f(0, height);

        glEnd();
        glLoadIdentity();
    }

    public static Texture loadTexture(String path, String fileType) {
        Texture texture = null;
        InputStream in = ResourceLoader.getResourceAsStream(path);
        try {
            texture = TextureLoader.getTexture(fileType, in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return texture;
    }


}
