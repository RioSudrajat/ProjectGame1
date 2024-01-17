package Game_Menghindari_Tugas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class TugasLaprak extends GameObject {

    private Handler handler;
    private GameObject playerObject;

    public TugasLaprak(int x, int y, ID id, Handler handler) {
        super(x, y, id); // Memanggil konstruktor superclass (GameObject) dengan koordinat (x, y) dan ID yang diberikan
        this.handler = handler;
        for (int i = 0; i< handler.object.size(); i++){
            if(handler.object.get(i).getid() == ID.Player) {
                playerObject = handler.object.get(i);
            }
        }
    }

    
     public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,16,16);
     }
 
    public void update() {
        x += kecX; // Memperbarui posisi objek pada sumbu X berdasarkan kecepatan
        y += kecY; // Memperbarui posisi objek pada sumbu Y berdasarkan kecepatan
        float stopDistance = 200;

    

         float distance = (float) Math.sqrt((x - playerObject.getX()) * (x - playerObject.getX())
            + (y - playerObject.getY()) * (y - playerObject.getY()));

    // Menentukan jarak ambang batas untuk berhenti dan mulai mengejar lagi
     // Ganti nilai sesuai kebutuhan

    boolean stopChasing;
    if (distance > stopDistance) {
        // Pemain berada di luar jarak ambang batas, SmartEnemy berhenti
        stopChasing = true;
    } else {
        // Pemain mendekati atau berada dalam jarak ambang batas, SmartEnemy mengejar lagi
        stopChasing = false;
    }

    if (!stopChasing) {
        // Hanya jika tidak berhenti, hitung kecepatan dan lakukan pergerakan
        float diffX = x - playerObject.getX() - 8;
        float diffY = y - playerObject.getY() - 8;

        kecX = (float) ((-3.0 / distance) * diffX);
        kecY = (float) ((-3.0 / distance) * diffY);
    }

        

        // Logika untuk memantulkan objek ketika mencapai batas layar
        if (y <= 0 || y >= 429) kecY *= -1; // Membalikkan arah pergerakan jika mencapai batas atas atau bawah
        if (x <= 0 || x >= 624) kecX *= -1; // Membalikkan arah pergerakan jika mencapai batas kiri atau kanan

        handler.addObject(new jejak((int)x,(int) y,ID.jejak,Color.GREEN, 16, 16, 0.03f, handler));
    }

    public void render(Graphics g) {



        g.setColor(Color.GREEN); // Mengatur warna untuk menggambar objek musuh

        g.fillRect((int)x,(int) y, 16, 16); // Menggambar persegi panjang merah pada koordinat (x, y) dengan lebar dan tinggi 16 pixel
    }
}