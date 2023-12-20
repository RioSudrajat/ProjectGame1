package Game_Menghindari_Tugas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class TugasPDP extends GameObject {

    private Handler handler;
    Random r = new Random();
    
    public TugasPDP(int x, int y, ID id, Handler handler) {
    super(x, y, id);
    
    this.handler = handler;
    
    kecX=(r.nextInt(5 - -5)+ -5);
    kecY=5;
    }
    @Override
    public Rectangle getBounds(){
    return new Rectangle((int)x, (int)y, 16, 16);
    }
    
    @Override
    public void update() {
        x += kecX;
        y += kecY;
        
        if (y >= Game.HEIGHT) handler.removeObject(this);
        
        handler.addObject(new jejak((int)x,(int)y, ID.jejak, Color.RED, 16, 16, 0.05f, handler));        
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y, 16, 16);
    }
}
