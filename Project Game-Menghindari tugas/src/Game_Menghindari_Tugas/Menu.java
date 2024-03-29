package Game_Menghindari_Tugas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter{
    private Game game;
    private Handler handler;
    private  Random r = new Random();
    private HP hp;

    public Menu(Game game, Handler handler, HP hp){
        this.game=game;
        this.hp=hp;
        this.handler=handler;
    }
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        if(game.gameState == STATE.menu){
        if(mouseOver(mx, my, 200, 100, 200, 64)){
            game.gameState = STATE.game;
            handler.removeEnemys();
            handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
            handler.addObject(new TugasFisdas(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.Fisdas, handler));   
            }
        
        //help button
        if(mouseOver(mx, my, 200, 200, 200, 64)){
            game.gameState = STATE.help;
            }
        //quit button
        if(mouseOver(mx, my, 200, 300, 200, 64)){
            System.exit(0);
            }
        }
        //back button for help
        if(game.gameState == STATE.help){
            if(mouseOver(mx, my, 200, 340, 200, 64)){
                game.gameState = STATE.menu;
                return;
            }
        }
        //try again
        if(game.gameState == STATE.end){
            if(mouseOver(mx, my, 200, 300, 200, 64)){
            game.gameState = STATE.game;
            hp.setLevel(1);
            hp.setScore(0);
            handler.removeEnemys();//czyscimy wrogow z ekr. głównego
            handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
            handler.addObject(new TugasFisdas(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.Fisdas, handler));   
            }
        }        
    }
    
    public void mouseReleased(MouseEvent e){      
    }
    
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x + width){
            if(my> y && my < y+ height){
                return true;
            } else return false;
        }else return false;
    }
    
    public void update(){       
    }
    
    public void render(Graphics g){
        if(game.gameState == STATE.menu){
        Font fnt = new Font("arial", 1,50);
        Font fnt1 = new Font("arial", 1, 30);
        
        g.setFont(fnt);
        g.setColor(Color.MAGENTA);
        g.drawString("Menu", 235, 80);
        
        g.setFont(fnt1);
        g.drawRect(200, 100, 200, 64);
        g.drawString("Play", 270, 140);
        
        g.setColor(Color.MAGENTA);
        g.drawRect(200, 200, 200, 64);
        g.drawString("Help", 270, 240);
        
        g.setColor(Color.MAGENTA);
        g.drawRect(200, 300, 200, 64);
        g.drawString("Quit", 270, 340);
        }
        else if (game.gameState == STATE.help){
        Font fnt = new Font("arial", 1,50);
        Font fnt1 = new Font("arial", 1, 30);
        
        g.setFont(fnt);
        g.setColor(Color.MAGENTA);
        g.drawString("Help", 250, 80);
        
        g.setFont(fnt1);
        g.drawString("Use WASD or arrows to move player", 50, 200);
        g.drawString("and escape from enemies.", 120, 240);
        g.drawString("ENTER -Start/Restart.", 150, 280);
        g.drawString("Space - pause.", 180,320);
        
        
        g.drawRect(200, 340, 200, 64);
        g.drawString("Back", 270, 380);
        }
        else if (game.gameState == STATE.end){
        Font fnt = new Font("arial", 1,50);
        Font fnt1 = new Font("arial", 1, 30);
        
        g.setFont(fnt);
        g.setColor(Color.MAGENTA);
        g.drawString("Game Over", 200, 80);
        
        g.setFont(fnt1);
        g.drawString("You lost", 230, 180);
        g.drawString("Your score " +hp.getScore(), 180, 240);
        
        g.drawRect(200, 300, 200, 64);
        g.drawString("Try Again", 220, 340);
        }       
    }    

    
}
