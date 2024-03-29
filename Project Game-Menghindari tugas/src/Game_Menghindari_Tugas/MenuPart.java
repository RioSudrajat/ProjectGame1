package Game_Menghindari_Tugas;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class MenuPart extends GameObject {

    private Handler handler;
    
    Random r = new Random();
  
    private int red = r.nextInt(255);
    private int green = r.nextInt(255);
    private int blue = r.nextInt(255);
    
    private boolean redstatus;
    private boolean greenstatus;
    private boolean bluestatus;
  
    private Color col;
    
    public MenuPart(int x, int y, ID id, Handler handler) {
    super(x, y, id);
    
    this.handler = handler;
       
    //different velocities and different directions
    kecX=(r.nextInt(5 - -5)+ -5);//(max-min)+min;
    kecY=(r.nextInt(5 - -5)+ -5);
    
    if(kecX==0) kecX=1;
    if(kecY==0) kecY=1;
    
    }
    @Override
    public Rectangle getBounds(){
    return new Rectangle((int)x, (int)y, 16, 16);
    }
    
    @Override
    public void update() {
        x += kecX;
        y += kecY;       
    
        if(red == 255){
        redstatus = false;      
        }
        if(green == 255){
        greenstatus = false;
        }
        if(blue == 255){
        bluestatus = false;
        }
        if(red == 0){
        redstatus = true;
        }
        if(green == 0){
        greenstatus = true;
        }
        if(blue == 0){
        bluestatus = true;
        }        
         
        if (redstatus == false) red--;
        if (greenstatus == false) green--;
        if (bluestatus == false) blue--;
        if (redstatus == true) red++;
        if (greenstatus == true) green++;
        if (bluestatus == true) blue++;        
        
        
        col = new Color(red, green, blue);
        
        //color changing      
        if(x <= 0 || x >= Game.WIDTH - 32) kecX *= -1;
        if(y <= 0 || y >= Game.HEIGHT - 54) kecY *= -1;
        
        handler.addObject(new jejak((int)x, (int)y, ID.jejak, col, 16, 16, 0.05f, handler));        
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(col);
        g.fillRect((int)x, (int)y, 16, 16);
    }
  
    
}