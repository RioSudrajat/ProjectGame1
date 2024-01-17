package Game_Menghindari_Tugas;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JPanel {

   public Window(int width, int height, String title, Game game) {
       JFrame frame = new JFrame(title); // Membuat objek JFrame dengan judul yang diberikan

       frame.setPreferredSize(new Dimension(width, height)); // Mengatur ukuran preferensi jendela
       frame.setMaximumSize(new Dimension(width, height));   // Mengatur ukuran maksimum jendela
       frame.setMinimumSize(new Dimension(width, height));   // Mengatur ukuran minimum jendela

       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Mengatur tindakan ketika jendela ditutup (keluar dari program)
       frame.setResizable(false); // Mengatur jendela agar tidak dapat diubah ukurannya oleh pengguna
       frame.setLocationRelativeTo(null); // Mengatur posisi jendela ke tengah layar
       frame.add(game); // Menambahkan objek permainan (Game) ke dalam jendela
       frame.setVisible(true); // Membuat jendela menjadi terlihat (visible)
       game.start(); // Memulai permainan dengan memanggil metode start() dari objek permainan
   }
}