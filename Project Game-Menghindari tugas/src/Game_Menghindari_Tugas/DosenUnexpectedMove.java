package Game_Menghindari_Tugas;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class DosenUnexpectedMove extends GameObject {
    
    private Handler handler;
    Random r = new Random();
    
    private int timer = 50;
    private int timer2 = 50;
    private int timer3 = 300;
    
    public int unexpectedMove;
    
    public DosenUnexpectedMove(int x, int y, ID id, Handler handler, int unexpectedMove) {
    super(x, y, id);
    
    this.handler = handler;
    this.unexpectedMove = unexpectedMove;
    
    kecX=0;
    kecY=2;
           
    }
    @Override
    public Rectangle getBounds(){
    return new Rectangle((int)x, (int)y, 96, 96);
    }
    
    @Override
    public void update() {
        x += kecX;
        y += kecY;
        
        if (timer <= 0){
            kecY = 0;//bergerak kebawah dan berhenti saat timer = 0
            timer2--;//melanjutkan lagi dengan logika yang ada pada timer2
        }
        else timer--;
        
        if (timer2 <=0)
        {
            if(kecX==0) kecX=2; //jika timer = 0 maka akan bergerak secara horizontal ke kiri atau ke kanan
            
            if(kecX>0)
            kecX +=0.01f;//kecepatan pak insan
            else if(kecX<0)
            kecX -=0.01f;
            
            kecX = Game.pembatas(kecX, -10, 10);
            
            int muncul = r.nextInt(10);//pemberian tugas pdp
            if (muncul==0) handler.addObject(new TugasPDP((int)x+48, (int)y+48, ID.Pdp, handler));
        
            timer3--;//going back to the top 
            System.out.println(timer3);
            System.out.println(unexpectedMove);
        }
        
        if((timer3 <= 0)&&(unexpectedMove == 1))
        {   
            System.out.println(timer3);
            System.out.println(unexpectedMove);
            kecY = -4;         
        } else if ((timer3 <= 0)&&(unexpectedMove == 2)) kecY=0;
       
        if(x <= 0 || x >= Game.WIDTH - 96) kecX *= -1;
  
        handler.addObject(new jejak((int)x,(int)y, ID.jejak, Color.GRAY, 96, 96, 0.05f, handler));     
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect((int)x, (int)y, 96, 96);
    }   
}