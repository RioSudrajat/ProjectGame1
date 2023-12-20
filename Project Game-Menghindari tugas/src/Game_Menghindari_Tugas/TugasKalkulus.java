
package Game_Menghindari_Tugas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class TugasKalkulus extends GameObject {

    private Handler handler;

    public TugasKalkulus(int x, int y, ID id, Handler handler) {
        super(x, y, id); // Memanggil konstruktor superclass (GameObject) dengan koordinat (x, y) dan ID yang diberikan
        this.handler = handler;
        kecX = 9;       // Mengatur kecepatan awal objek pada sumbu X
        kecY = 9;       // Mengatur kecepatan awal objek pada sumbu Y
    }

    
     public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,16,16);
     }
 
    public void update() {
        x += kecX; // Memperbarui posisi objek pada sumbu X berdasarkan kecepatan
        y += kecY; // Memperbarui posisi objek pada sumbu Y berdasarkan kecepatan

        // Logika untuk memantulkan objek ketika mencapai batas layar
        if (y <= 0 || y >= 429) kecY *= -1; // Membalikkan arah pergerakan jika mencapai batas atas atau bawah
        if (x <= 0 || x >= 624) kecX *= -1; // Membalikkan arah pergerakan jika mencapai batas kiri atau kanan

        handler.addObject(new jejak((int)x, (int)y,ID.jejak,Color.blue, 16, 16, 0.03f, handler));
    }

    public void render(Graphics g) {



        g.setColor(Color.blue); // Mengatur warna untuk menggambar objek musuh

        g.fillRect((int)x,(int) y, 16, 16); // Menggambar persegi panjang merah pada koordinat (x, y) dengan lebar dan tinggi 16 pixel
    }
}
