package Game_Menghindari_Tugas;

import java.awt.Color;
import java.awt.Graphics;

// Kelas untuk mengelola dan menampilkan informasi kesehatan (HP), skor, dan level pemain
public class HP {

    // Variabel konstan untuk nilai awal kesehatan
    public static float DARAH = 100;

    // Variabel untuk menyimpan skor pemain
    private int Score = 0;

    // Variabel untuk menyimpan level pemain
    private int level = 1;

    // Metode untuk memperbarui informasi kesehatan, memastikan nilainya berada dalam rentang 0-100
    public void update() {
        DARAH = Game.pembatas(DARAH, 0, 100);
        Score++; // Menambah skor setiap kali metode update dipanggil
    }

    // Metode untuk merender informasi kesehatan, skor, dan level pemain
    public void render(Graphics g) {
        // Menggambar batang merah sebagai representasi kesehatan maksimum
        g.setColor(Color.RED);
        g.fillRect(15, 15, 200, 32);

        // Menggambar batang hijau sesuai dengan nilai kesehatan aktual
        g.setColor(Color.GREEN);
        g.fillRect(15, 15,(int) DARAH * 2, 32);

        // Menggambar batas luar batang kesehatan
        g.setColor(Color.WHITE);
        g.drawRect(15, 15, 200, 32);

        // Menampilkan skor dan level pada layar
        g.drawString("SCORE: " + Score, 10, 64);
        g.drawString("LEVEL: " + level, 10, 80);
    }

    // Metode untuk mengatur nilai skor
    public void setScore(int Score) {
        this.Score = Score;
    }

    // Metode untuk mendapatkan nilai skor
    public int getScore() {
        return Score;
    }

    // Metode untuk mendapatkan nilai level
    public int getLevel() {
        return level;
    }

    // Metode untuk mengatur nilai level
    public void setLevel(int level) {
        this.level = level;
    }
}