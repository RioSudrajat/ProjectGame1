package Game_Menghindari_Tugas;
import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
    
    // Atribut ini adalah sebuah LinkedList yang akan digunakan untuk menyimpan objek-objek permainan.
    LinkedList<GameObject> object = new LinkedList<GameObject>();

    // Metode untuk memperbarui (update) semua objek dalam daftar
    public void update(){
        // Loop melalui semua objek dalam daftar
        for(int i = 0; i < object.size(); i++){
            GameObject objectSementara = object.get(i); // Ambil objek sementara dari daftar

            objectSementara.update(); // Panggil metode 'update' pada objek sementara
        }
    }

    // Metode untuk menggambar (paintComponent) semua objek dalam daftar
    public void render(Graphics g){
        // Loop melalui semua objek dalam daftar
        for(int i = 0; i < object.size(); i++){
            GameObject objectSementara = object.get(i); // Ambil objek sementara dari daftar

            objectSementara.render(g); // Panggil metode 'paintComponent' pada objek sementara
        }
    }
    public void removeEnemys(){
        for (int i = 0; i<object.size();i++){
            GameObject objectSementara = object.get(i);
            if(objectSementara.getid() !=ID.Player){
                removeObject(objectSementara);
                i--;
            }
        }
    }

    // Metode untuk menambahkan objek baru ke dalam daftar objek
    public void addObject(GameObject object){
        this.object.add(object); // Tambahkan objek ke dalam LinkedList 'object'
    }

    // Metode untuk menghapus objek dari daftar objek
    public void removeObject(GameObject object){
        this.object.remove(object); // Hapus objek dari LinkedList 'object'
    }
}
