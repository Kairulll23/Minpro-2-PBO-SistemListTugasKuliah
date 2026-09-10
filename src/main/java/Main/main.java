package main;

import sistem.Pengguna;
import sistem.Tugas;

public class main {
    public static void main(String[] args) {
        Pengguna mhs = new Pengguna("2509116097", "Khairul Ikhsan");
        
        Tugas app = new Tugas();
        app.olahMenu(mhs);
    }
}