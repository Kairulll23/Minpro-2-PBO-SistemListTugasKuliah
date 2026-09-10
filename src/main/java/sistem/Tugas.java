package sistem;

import java.util.ArrayList;
import java.util.Scanner;

public class Tugas {
    private final ArrayList<Storage> listTugasKu = new ArrayList<>();
    private final Scanner scan = new Scanner(System.in);

    // Menu Utama & Pengolahan Input
    public void olahMenu(Pengguna user) {
        boolean lanjut = true;
        System.out.println("\nSelamat Datang, " + user.getNama() + " (" + user.getNim() + ")!");

        while (lanjut) {
            System.out.println("\n=== SISTEM LIST TUGAS KULIAH ===");
            System.out.println("1. Tambah Tugas Baru (Create)");
            System.out.println("2. Tampilkan Daftar Tugas (Read)");
            System.out.println("3. Ubah Data Tugas (Update)");
            System.out.println("4. Hapus Tugas (Delete)");
            System.out.println("5. Keluar Aplikasi");
            System.out.print("Pilih menu (1-5): ");

            int pil = bacaAngka();

            switch (pil) {
                case 1:
                    tambahTugas();
                    break;
                case 2:
                    tampilkanTugas();
                    break;
                case 3:
                    editTugas();
                    break;
                case 4:
                    hapusTugas();
                    break;
                case 5:
                    lanjut = false;
                    System.out.println("\nTerima kasih, program selesai.");
                    break;
                default:
                    System.out.println("[!] Pilihan menu tidak tersedia. Silakan pilih 1-5.");
            }
        }
    }

    // --- Helper Input & Validasi ---
    private int bacaAngka() {
        while (!scan.hasNextInt()) {
            System.out.println("[!] Input harus berupa angka.");
            System.out.print("Pilih menu: ");
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

    private Storage cariTugas(String kodeTugas) {
        for (Storage t : listTugasKu) {
            if (t.getKodeTugas().equalsIgnoreCase(kodeTugas)) {
                return t;
            }
        }
        return null;
    }

    // --- FITUR CRUD ---
    // CREATE
    public void tambahTugas() {
        System.out.println("\n--- TAMBAH TUGAS BARU ---");
        String kode = bacaTeks("Kode Tugas (contoh: T01): ");

        if (cariTugas(kode) != null) {
            System.out.println("[!] Kode tugas sudah digunakan, silakan pakai kode lain.");
            return;
        }

        String matkul = bacaTeks("Nama Mata Kuliah: ");
        String detail = bacaTeks("Catatan Tugas: ");
        String dateline = bacaTeks("Deadline Tanggal & Jam (contoh: 2026-09-15 23:59): ");

        listTugasKu.add(new Storage(kode, matkul, detail, dateline));
        System.out.println("[+] Tugas berhasil ditambahkan.");
    }

    // READ
    public void tampilkanTugas() {
        if (listTugasKu.isEmpty()) {
            System.out.println("\n[!] Belum ada data tugas yang tersimpan.");
            return;
        }

        System.out.println("\n====================================================================================================");
        System.out.printf("| %-8s | %-18s | %-28s | %-20s |\n", "KODE", "MATA KULIAH", "CATATAN TUGAS", "DEADLINE (TGL & JAM)");
        System.out.println("====================================================================================================");
        for (Storage t : listTugasKu) {
            System.out.println(t.cetakBaris());
        }
        System.out.println("====================================================================================================");
    }

    // UPDATE
    public void editTugas() {
        System.out.println("\n--- UBAH DATA TUGAS ---");
        String kode = bacaTeks("Masukkan Kode Tugas yang ingin diubah: ");
        Storage t = cariTugas(kode);

        if (t == null) {
            System.out.println("[!] Kode tugas tidak ditemukan.");
            return;
        }

        t.setNamaMatkul(bacaTeks("Nama Mata Kuliah Baru: "));
        t.setDetailTugas(bacaTeks("Catatan Tugas Baru: "));
        t.setDateline(bacaTeks("Deadline Tanggal & Jam Baru (contoh: 2026-09-15 23:59): "));

        System.out.println("[+] Data tugas berhasil diperbarui.");
    }

    // DELETE
    public void hapusTugas() {
        System.out.println("\n--- HAPUS TUGAS ---");
        String kode = bacaTeks("Masukkan Kode Tugas yang ingin dihapus: ");
        Storage t = cariTugas(kode);

        if (t != null) {
            listTugasKu.remove(t);
            System.out.println("[+] Tugas berhasil dihapus.");
        } else {
            System.out.println("[!] Kode tugas tidak ditemukan.");
        }
    }
}