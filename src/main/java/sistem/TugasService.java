package sistem;

import java.util.ArrayList;

public class TugasService {
    private final ArrayList<Tugas> listTugasKu = new ArrayList<>();

    // CREATE
    public boolean tambahTugas(Tugas t) {
        if (cariTugas(t.getKodeTugas()) != null) {
            return false;
        }
        listTugasKu.add(t);
        return true;
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
        for (Tugas t : listTugasKu) {
            System.out.println(t.cetakBaris());
        }
        System.out.println("====================================================================================================");
    }

    public Tugas cariTugas(String kodeTugas) {
        for (Tugas t : listTugasKu) {
            if (t.getKodeTugas().equalsIgnoreCase(kodeTugas)) {
                return t;
            }
        }
        return null;
    }

    // UPDATE
    public boolean editTugas(String kodeTugas, String matkulBaru, String detailBaru, String datelineBaru) {
        Tugas t = cariTugas(kodeTugas);
        if (t != null) {
            t.setNamaMatkul(matkulBaru);
            t.setDetailTugas(detailBaru);
            t.setDateline(datelineBaru);
            return true;
        }
        return false;
    }

    // DELETE
    public boolean hapusTugas(String kodeTugas) {
        Tugas t = cariTugas(kodeTugas);
        if (t != null) {
            listTugasKu.remove(t);
            return true;
        }
        return false;
    }
}