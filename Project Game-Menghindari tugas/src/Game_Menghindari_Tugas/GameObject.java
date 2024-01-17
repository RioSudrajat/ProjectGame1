package Game_Menghindari_Tugas;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
    protected float x, y; // Koordinat (x, y) objek dalam layar permainan
    protected ID id; // ID objek yang digunakan untuk mengidentifikasi jenis objek
    protected float kecX, kecY; // Komponen kecepatan objek (kecepatan horizontal dan vertikal)

    public GameObject(float x, float y, ID id){
        this.x = x; // Menginisialisasi koordinat x objek
        this.y = y; // Menginisialisasi koordinat y objek
        this.id = id; // Menginisialisasi ID objek
    }

    // Metode abstrak yang harus diimplementasikan oleh subkelas.
    public abstract void update(); // Metode untuk memperbarui logika objek
    public abstract void render(Graphics g); // Metode untuk menggambar objek
    public abstract  Rectangle getBounds(); 

    // Getter dan setter untuk x dan y
    public void setX(int x){
        this.x = x; // Mengatur nilai koordinat x objek
    }
    public void setY(int y){
        this.y = y; // Mengatur nilai koordinat y objek
    }
    public float getX(){
        return x; // Mengambil nilai koordinat x objek
    }
    public float getY(){
        return y; // Mengambil nilai koordinat y objek
    }

    // Getter dan setter untuk ID objek
    public void setID(ID id){
        this.id = id; // Mengatur ID objek
    }
    public ID getid(){
        return id; // Mengambil ID objek
    }

    // Getter dan setter untuk kecepatan horizontal (kecX) dan vertikal (kecY) objek
    public void setkecX(int kecX){
        this.kecX = kecX; // Mengatur nilai kecepatan horizontal objek
    }
    public void setkecY(int kecY){
        this.kecY = kecY; // Mengatur nilai kecepatan vertikal objek
    }
    public float getkecX(){
        return kecX; // Mengambil nilai kecepatan horizontal objek
    }
    public float getkecY(){
        return kecY; // Mengambil nilai kecepatan vertikal objek
    }
}
