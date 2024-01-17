package Game_Menghindari_Tugas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random(); // Objek Random untuk menghasilkan nilai acak
    Handler handler;
    
    public Player(int x, int y, ID id, Handler handler){
        super(x, y, id); // Memanggil konstruktor superclass (GameObject) dengan koordinat (x, y) dan ID yang diberikan
        this.handler =  handler;
    }
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,32,32);
    }

    // Metode 'update' dari superclass (GameObject) harus diwariskan dan diimplementasikan di sini.
    public void update(){
        // Implementasi logika perbaruan objek pemain, seperti pergerakan atau perhitungan lainnya.
        x += kecX;
        y += kecY;

        x = Game.pembatas((int)x, 0, Game.WIDTH - 40);
        y = Game.pembatas((int)y, 0, Game.HEIGHT - 64);

       // handler.addObject(new jejak(x, y,ID.jejak,Color.WHITE, 32, 32, 0.03f, handler));

        collision();
        if (HP.DARAH <= 0) {
            // Logika untuk game over
            System.out.println("Game Over!");
            System.exit(0); // Atau implementasi logika game over yang sesuai
        }
    }
    private void collision(){
        for (int i = 0; i < handler.object.size(); i++){

        GameObject objectSementara = handler.object.get(i);

        if (objectSementara.getid() == ID.Kalkulus || objectSementara.getid() == ID.Fisdas || objectSementara.getid() == ID.Pdp 
        || objectSementara.getid() == ID.Laprak || objectSementara.getid() == ID.daspro) {
            if (getBounds().intersects(objectSementara.getBounds())){
                HP.DARAH -= 2;
            }
        }
    }

    }
    
    public void render(Graphics g){
        g.setColor(Color.white); // Mengatur warna untuk menggambar objek pemain

        g.fillRect((int)x,(int) y, 32, 32); // Menggambar persegi panjang putih pada koordinat (x, y) dengan lebar dan tinggi 32 pixel
    }

    
}
