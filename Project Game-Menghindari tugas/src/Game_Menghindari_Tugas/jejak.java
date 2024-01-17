package Game_Menghindari_Tugas;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class jejak extends GameObject {

    // Variabel untuk mengatur tingkat transparansi objek jejak
    private float Alpha = 1;

    // Variabel untuk menangani objek jejak di dalam game
    private Handler handler;

    // Warna objek jejak
    private Color color;

    // Ukuran lebar dan tinggi objek jejak
    private int Width, Height;

    // Masa hidup objek jejak
    private float Life;

    // Konstruktor untuk objek jejak
    public jejak(int x, int y, ID id, Color color, int Width, int Height, float Life, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.color = color;
        this.Width = Width;
        this.Height = Height;
        this.Life = Life;
    }

    // Metode untuk memperbarui objek jejak
    public void update() {
        // Mengurangi tingkat transparansi seiring berjalannya waktu
        if (Alpha > Life) {
            Alpha -= (Life - 0.0001f);
        } else {
            // Jika tingkat transparansi kurang dari masa hidup, hapus objek jejak dari handler
            handler.removeObject(this);
        }
    }

    // Metode untuk merender objek jejak
    public void render(Graphics g) {
        // Membuat objek Graphics2D untuk mengatur tingkat transparansi
        Graphics2D g2d = (Graphics2D) g;
        // Mengatur tingkat transparansi
        g2d.setComposite(makeTransparent(Alpha));

        // Menggambar objek jejak dengan warna dan ukuran yang ditentukan
        g.setColor(color);
        g.fillRect((int) x, (int) y, Width, Height);

        // Mengembalikan tingkat transparansi ke normal setelah menggambar objek
        g2d.setComposite(makeTransparent(1));
    }

    // Metode untuk membuat objek AlphaComposite dengan tingkat transparansi tertentu
    private AlphaComposite makeTransparent(float Alpha) {
        int Type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(Type, Alpha);
    }

    // Metode untuk mendapatkan batas objek (tidak digunakan dalam contoh ini)
    public Rectangle getBounds() {
        return null;
    }
}