package Game_Menghindari_Tugas;

import java.util.Random;

public class Muncul {

    private Handler handler;
    private HP hp;
    private Random r = new Random();
    private int scoreTetap = 0;
   
    public Muncul(Handler handler, HP hp){
        this.handler = handler;
        this.hp = hp;
    }
    public void update(){

        scoreTetap++;

        if(scoreTetap >= 250){
            scoreTetap = 0;
            hp.setLevel(hp.getLevel() + 1);
        
        if (hp.getLevel() == 2 ){
            handler.addObject(new TugasFisdas(r.nextInt(Game.WIDTH/2-16), r.nextInt(Game.HEIGHT/2-16), ID.Fisdas, handler));
        } else if(hp.getLevel() == 3){
            handler.addObject(new TugasFisdas(r.nextInt(Game.WIDTH/2-16), r.nextInt(Game.HEIGHT/2-16), ID.Fisdas, handler));
        } else if(hp.getLevel() == 4){
            handler.addObject(new TugasKalkulus(r.nextInt(Game.WIDTH)/2-16, r.nextInt(Game.HEIGHT/2-16), ID.Kalkulus, handler));
        } else if(hp.getLevel() == 5){
            handler.addObject(new TugasLaprak(r.nextInt(Game.WIDTH)/2-16, r.nextInt(Game.HEIGHT/2-16), ID.Laprak, handler));
        } else if(hp.getLevel() == 6){
            handler.addObject(new TugasDaspro(r.nextInt(Game.WIDTH)/2-16, r.nextInt(Game.HEIGHT/2-16), ID.daspro, handler));
        } else if(hp.getLevel() == 7){
            handler.addObject(new DosenUnexpectedMove((Game.WIDTH/2)-48, -100, ID.pakInsan, handler, 2));  
        }
    }
    }
}
