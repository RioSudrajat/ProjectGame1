package Game_Menghindari_Tugas;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

    private Handler handler; // Atribut untuk menyimpan referensi ke objek handler
    private boolean [] KeyDown = new boolean[4];

    public KeyInput(Handler handler){
        this.handler = handler; // Menginisialisasi atribut handler dengan objek Handler yang diberikan

        KeyDown[0]=false;
        KeyDown[1]=false;
        KeyDown[2]=false;
        KeyDown[3]=false;
    }
    public void keyTyped(KeyEvent e) {
        
    }
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode(); // Mendapatkan kode tombol yang ditekan

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject objectSementara = handler.object.get(i); // Mendapatkan objek sementara dari handler

            if (objectSementara.getid() == ID.Player) {
                // Jika objek sementara adalah objek pemain (Player), reaksi terhadap tombol didefinisikan
                if (key == KeyEvent.VK_W){ objectSementara.setkecY(-5);KeyDown[0] = true; } // Mengatur kecepatan Y ke atas (ke atas)
                if (key == KeyEvent.VK_A){ objectSementara.setkecX(-5);KeyDown[1] = true;} // Mengatur kecepatan X ke kiri (ke kiri)
                if (key == KeyEvent.VK_S){ objectSementara.setkecY(5);KeyDown[2] = true;}  // Mengatur kecepatan Y ke bawah (ke bawah)
                if (key == KeyEvent.VK_D){ objectSementara.setkecX(5);KeyDown[3] = true;}  // Mengatur kecepatan X ke kanan (ke kanan)
            }
        }
    }
    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode(); // Mendapatkan kode tombol yang dilepas
    
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject objectSementara = handler.object.get(i); // Mendapatkan objek sementara dari handler

          
    
            if (objectSementara.getid() == ID.Player) {
                // Jika objek sementara adalah objek pemain (Player), reaksi terhadap pelepasan tombol didefinisikan
                if (key == KeyEvent.VK_W) {KeyDown[0] = false;} // Menghentikan pergerakan Y (berhenti bergerak ke atas)
                if (key == KeyEvent.VK_A) {KeyDown[1] = false;} // Menghentikan pergerakan X (berhenti bergerak ke kiri)
                if (key == KeyEvent.VK_S) {KeyDown[2] = false;} // Menghentikan pergerakan Y (berhenti bergerak ke bawah)
                if (key == KeyEvent.VK_D) {KeyDown[3] = false;} // Menghentikan pergerakan X (berhenti bergerak ke kanan)

                // vertical
                if (!KeyDown[0] && !KeyDown[2]){ objectSementara.setkecY(0);}
                // horizontal 
                if (!KeyDown[1] && !KeyDown[3]) {objectSementara.setkecX(0);}
            }
            
        }
    }
}