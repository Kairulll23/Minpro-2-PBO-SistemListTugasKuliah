package view;

import java.util.Scanner;
import controller.TugasController;
import model.*;

public class TugasView {
    private final Scanner scan = new Scanner(System.in);
    private final TugasController controller = new TugasController();

    public void olahMenu(Mahasiswa mhs) {
        boolean lanjut = true;
        System.out.println("\nSelamat Datang, " + mhs.getNama() + " (" + mhs.getNim() + ")!");

        while (lanjut) {
            System.out.println("\n=== SISTEM LIST TUGAS KULIAH (MVC) ===");
            System.out.println("1. Tambah Tugas Baru (Create)");
            System.out.println("2. Tampilkan Daftar Tugas (Read)");
            System.out.println("3. Ubah Data Tugas (Update)");
            System.out.println("4. Hapus Tugas (Delete)");
            System.out.println("5. Keluar Aplikasi");
            System.out.print("Pilih menu (1-5): ");

            int pil = bacaAngka();

            switch (pil) {
                case 1: menuTambah(); break;
                case 2: menuTampil(); break;
                case 3: menuEdit(); break;
                case 4: menuHapus(); break;
                case 5:
                    lanjut = false;
                    System.out.println("\nTerima kasih, program selesai.");
                    break;
                default:
                    System.out.println("[!] Pilihan menu tidak valid (1-5).");
            }
        }
    }

    private int bacaAngka() {
        while (!scan.hasNextInt()) {
            System.out.println("[!] Input harus berupa angka!");
            System.out.print("Masukkan angka: ");
            scan.next();
        }
        int angka = scan.nextInt();
        scan.nextLine(); // Clear buffer
        return angka;
    }

    private String bacaTeks(String label) {
        String input;
        do {
            System.out.print(label);
            input = scan.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("[!] Inputan tidak boleh kosong.");
            }
        } while (input.isEmpty());
        return input;
    }

    private void menuTambah() {
        System.out.println("\n--- TAMBAH TUGAS BARU ---");
        System.out.println("1. Tugas Individu");
        System.out.println("2. Tugas Kelompok");
        System.out.print("Pilih Tipe Tugas (1-2): ");
        int tipe = bacaAngka();

        if (tipe != 1 && tipe != 2) {
            System.out.println("[!] Tipe tugas tidak valid.");
            return;
        }

        String kode = bacaTeks("Kode Tugas (contoh: T03): ");
        if (controller.cariTugas(kode) != null) {
            System.out.println("[!] Kode tugas sudah ada.");
            return;
        }

        String matkul = bacaTeks("Mata Kuliah: ");
        String detail = bacaTeks("Catatan Tugas: ");
        String dateline = bacaTeks("Deadline (YYYY-MM-DD HH:MM): ");

        if (tipe == 1) {
            String link = bacaTeks("Link Pengumpulan: ");
            controller.tambahTugas(new TugasIndividu(kode, matkul, detail, dateline, link));
        } else {
            String kelompok = bacaTeks("Nama Kelompok: ");
            System.out.print("Jumlah Anggota: ");
            int jml = bacaAngka();
            controller.tambahTugas(new TugasKelompok(kode, matkul, detail, dateline, kelompok, jml));
        }
        System.out.println("[+] Tugas berhasil ditambahkan.");
    }

    private void menuTampil() {
        if (controller.getAllTugas().isEmpty()) {
            System.out.println("\n[!] Belum ada data tugas.");
            return;
        }

        System.out.println("\n=========================================================================================================================");
        System.out.printf("| %-8s | %-10s | %-16s | %-22s | %-18s | %-20s |\n", "KODE", "TIPE", "MATKUL", "CATATAN", "DEADLINE", "KETERANGAN TAMBAHAN");
        System.out.println("=========================================================================================================================");
        for (Tugas t : controller.getAllTugas()) {
            System.out.println(t.cetakBaris());
        }
        System.out.println("=========================================================================================================================");
    }

    private void menuEdit() {
        System.out.println("\n--- UBAH DATA TUGAS ---");
        String kode = bacaTeks("Masukkan Kode Tugas yang ingin diubah: ");
        Tugas t = controller.cariTugas(kode);

        if (t == null) {
            System.out.println("[!] Kode tugas tidak ditemukan.");
            return;
        }

        t.setNamaMatkul(bacaTeks("Mata Kuliah Baru: "));
        t.setDetailTugas(bacaTeks("Catatan Baru: "));
        t.setDateline(bacaTeks("Deadline Baru: "));

        if (t instanceof TugasIndividu) {
            ((TugasIndividu) t).setLinkPengumpulan(bacaTeks("Link Pengumpulan Baru: "));
        } else if (t instanceof TugasKelompok) {
            ((TugasKelompok) t).setNamaKelompok(bacaTeks("Nama Kelompok Baru: "));
            System.out.print("Jumlah Anggota Baru: ");
            ((TugasKelompok) t).setJumlahAnggota(bacaAngka());
        }

        System.out.println("[+] Data tugas berhasil diperbarui.");
    }

    private void menuHapus() {
        System.out.println("\n--- HAPUS TUGAS ---");
        String kode = bacaTeks("Masukkan Kode Tugas: ");
        if (controller.hapusTugas(kode)) {
            System.out.println("[+] Tugas berhasil dihapus.");
        } else {
            System.out.println("[!] Kode tugas tidak ditemukan.");
        }
    }
} 