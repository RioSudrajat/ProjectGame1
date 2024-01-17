package Game_Menghindari_Tugas;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class Game extends JPanel implements Runnable {
    public static final int WIDTH = 640, HEIGHT = 480; // Lebar dan tinggi jendela permainan

    private Thread thread; // Thread yang digunakan untuk menjalankan permainan
    private boolean running = false; // Status apakah permainan sedang berjala n atau tidak(disisni saya menjadikannya false tujuannya agar jika dipanggil baru menjadi true)
    static boolean paused = false;
    private Handler handler; // untuk mendeklarasikan handler yg mengelola objek-objek dalam permainan
    private Random r;
    private HP hp;
    private Muncul muncul;
    private Menu menu;
    STATE gameState = STATE.menu;

    public Game() {
        handler = new Handler(); // Membuat objek Handler untuk mengelola objek-objek dalam permainan
        hp = new HP();
        menu = new Menu(this, handler, hp);
        this.addKeyListener(new KeyInput(handler, this, hp)); // untuk memberikan respon pada input pemain dedngan keyboard yang logikanya sudah dibuat pada objek keyInput
        this.addMouseListener(menu);
        setFocusable(true); // untuk memberikan fokus pada input pemain agar bisa digerakkan dengan keyboard
       

        new Window(WIDTH, HEIGHT, "Hindari Tugas Euy", this); // Membuat jendela permainan dengan lebar, tinggi, judul, dan panel permainan

        muncul = new Muncul(handler,hp);
        r = new Random();

        if(gameState == STATE.game){
            handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
            handler.addObject(new TugasFisdas(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.Fisdas, handler));   
        } else {
            for(int i=0; i<15; i++){
                handler.addObject(new MenuPart(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuPart, handler));
            }
        } 
    }

    public void start() {
       
        thread = new Thread(this); // Membuat thread yang akan menjalankan permainan
        thread.start(); // Memulai thread permainan
        running = true; // Mengatur status berjalan menjadi true
    }

    public void stop() {
        
       // Menghentikan thread permainan
            running = false; // Mengatur status berjalan menjadi false
      
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double FPS = 60.0; // 60 FPS
        double ns = 1000000000 / FPS;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
    
        while (running) { // Loop utama permainan selama permainan sedang berjalan
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
    
            while (delta >= 1) { // Pembaruan logika permainan sesuai dengan FPS yang ditargetkan
                update(); // Memanggil metode update() untuk memperbarui logika permainan
                delta--;
            }
    
            repaint(); // Menggambar elemen-elemen permainan
    
            frames++;
    
            if (System.currentTimeMillis() - timer > 1000) { // Menghitung FPS setiap 1 detik
                timer += 1000;
                System.out.println("FPS: " + frames); // Mencetak FPS ke konsol
                frames = 0;
            }
            
            double targetTime = System.nanoTime() + (ns - (System.nanoTime() - now));
            while (System.nanoTime() < targetTime) { // Menunda untuk mengatur FPS yang stabil
                try {
                    Thread.sleep(1); // Tidur sebentar untuk mengontrol FPS
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        stop(); // Metode untuk menghentikan permainan ketika loop selesai
    }
    
    private void update() {
        if (!paused){
        handler.update(); // Memperbarui objek-objek dalam permainan
        if(gameState == STATE.game){
        hp.update();
        muncul.update();
        if(HP.DARAH <= 0){
            HP.DARAH = 100;
            gameState = STATE.end;
            handler.object.clear();
            for(int i = 0; i <8; i++){
                handler.addObject(new MenuPart(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.MenuPart,handler));
            }
        }
        }
    }else if(gameState == STATE.menu || gameState == STATE.end){
        menu.update();
    }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT); // Menggambar latar belakang
    
        handler.render(g); // Menggambar elemen-elemen permainan
        
        if (paused) {
            g.setColor(Color.YELLOW);
            g.drawString("PAUSED", WIDTH / 2 - 40, 100);
        }
    
        if (gameState == STATE.game) {
            hp.render(g);
        } else if (gameState == STATE.menu || gameState == STATE.help || gameState == STATE.end) {
            menu.render(g);
        }
    }

    public static float pembatas(float var, float min, float max){
        if (var >= max )
            return var = max;
        else if (var <= min)
            return var = min;
        else 
            return var;
    }

    public static void main(String[] args) {
        new Game(); // Membuat objek permainan dan memulai permainan
    }
}
