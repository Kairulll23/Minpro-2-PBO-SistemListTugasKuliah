package sistem;

import java.util.Scanner;

public class InputTugas {
    private final Scanner scan = new Scanner(System.in);
    private final TugasService service = new TugasService();

    public void olahMenu() {
        boolean lanjut = true;

        while (lanjut) {
            System.out.println("\n=== SISTEM LIST TUGAS KULIAH ===");
            System.out.println("1. Tambah Tugas Baru");
            System.out.println("2. Tampilkan Daftar Tugas");
            System.out.println("3. Ubah Data Tugas");
            System.out.println("4. Hapus Tugas");
            System.out.println("5. Keluar Aplikasi");
            System.out.print("Pilih menu (1-5): ");

            int pil = bacaAngka();

            switch (pil) {
                case 1:
                    menuTambah();
                    break;
                case 2:
                    service.tampilkanTugas();
                    break;
                case 3:
                    menuEdit();
                    break;
                case 4:
                    menuHapus();
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

    private int bacaAngka() {
        while (!scan.hasNextInt()) {
            System.out.println("[!] Input harus berupa angka.");
            System.out.print("Pilih menu: ");
            scan.next();
        }
        int angka = scan.nextInt();
        scan.nextLine();
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
        String kode = bacaTeks("Kode Tugas (contoh: T01): ");
        String matkul = bacaTeks("Nama Mata Kuliah: ");
        String detail = bacaTeks("Catatan Tugas: ");
        String dateline = bacaTeks("Deadline Tanggal & Jam (contoh: 2026-09-15 23:59): ");

        Tugas t = new Tugas(kode, matkul, detail, dateline);
        if (service.tambahTugas(t)) {
            System.out.println("[+] Tugas berhasil ditambahkan.");
        } else {
            System.out.println("[!] Kode tugas sudah digunakan, silakan pakai kode lain.");
        }
    }

    private void menuEdit() {
        System.out.println("\n--- UBAH DATA TUGAS ---");
        String kode = bacaTeks("Masukkan Kode Tugas yang ingin diubah: ");

        if (service.cariTugas(kode) == null) {
            System.out.println("[!] Kode tugas tidak ditemukan.");
            return;
        }

        String matkulBaru = bacaTeks("Nama Mata Kuliah Baru: ");
        String detailBaru = bacaTeks("Catatan Tugas Baru: ");
        String datelineBaru = bacaTeks("Deadline Tanggal & Jam Baru (contoh: 2026-09-15 23:59): ");

        if (service.editTugas(kode, matkulBaru, detailBaru, datelineBaru)) {
            System.out.println("[+] Data tugas berhasil diperbarui.");
        }
    }

    private void menuHapus() {
        System.out.println("\n--- HAPUS TUGAS ---");
        String kode = bacaTeks("Masukkan Kode Tugas yang ingin dihapus: ");

        if (service.hapusTugas(kode)) {
            System.out.println("[+] Tugas berhasil dihapus.");
        } else {
            System.out.println("[!] Kode tugas tidak ditemukan.");
        }
    }
}