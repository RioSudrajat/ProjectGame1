package Game_Menghindari_Tugas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class TugasDaspro extends GameObject {

    private Handler handler;
    Random r = new Random();
    
    public TugasDaspro(int x, int y, ID id, Handler handler) {
    super(x, y, id);
    
    this.handler = handler;
    
    kecX = 5;
    kecY = 5;        
    }   
    public Rectangle getBounds(){
    return new Rectangle((int)x, (int)y, 16, 16);
    }
    
    //memantul dari bawah
    
    public void update() {
        x += kecX;
        y += kecY;
        
        kecY +=0.3f;
        if (y <= 0) kecY = 0.5f;//mengatur kecepatan kearah bawah

        if(x <= 0 || x >= Game.WIDTH - 32){
            kecX *=-1;
        }
        if(y >= Game.HEIGHT - 54) //mengubah arah
            kecY *= -1;
        
        handler.addObject(new jejak((int)x, (int)y, ID.jejak, Color.PINK, 16, 16, 0.05f, handler));     
    }

    
    public void render(Graphics g) {
        g.setColor(Color.PINK);
        g.fillRect((int)x, (int)y, 16, 16);
    } 
}
