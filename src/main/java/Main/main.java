package main; // Diubah dari 'Main' menjadi 'main' (huruf kecil)

import sistem.Pengguna;
import sistem.Tugas;

public class main {
    public static void main(String[] args) {
        // Inisialisasi Data Pengguna
        Pengguna mhs = new Pengguna("230101001", "Mahasiswa Praktikum");
        
        // Memanggil Class Utama Tugas
        Tugas app = new Tugas();
        app.olahMenu(mhs);
    }
}