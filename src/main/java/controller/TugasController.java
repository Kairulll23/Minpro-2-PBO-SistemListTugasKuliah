package controller;

import java.util.ArrayList;
import model.Tugas;
import model.TugasIndividu;
import model.TugasKelompok;

public class TugasController {
    private final ArrayList<Tugas> listTugasKu = new ArrayList<>();

    public TugasController() {
        listTugasKu.add(new TugasIndividu("T01", "JarKom", "Membuat Topologi", "2026-09-28 23:59", "Masukkan Kedrive"));
        listTugasKu.add(new TugasKelompok("T02", "Sistam Basis Data", "Membuat Database", "2026-10-02 18:00", "Kelompok 3", 4));
    }

    public ArrayList<Tugas> getAllTugas() {
        return listTugasKu;
    }

    public Tugas cariTugas(String kodeTugas) {
        for (Tugas t : listTugasKu) {
            if (t.getKodeTugas().equalsIgnoreCase(kodeTugas)) {
                return t;
            }
        }
        return null;
    }

    public boolean tambahTugas(Tugas tugasBaru) {
        if (cariTugas(tugasBaru.getKodeTugas()) != null) {
            return false;
        }
        listTugasKu.add(tugasBaru);
        return true;
    }

    public boolean hapusTugas(String kodeTugas) {
        Tugas t = cariTugas(kodeTugas);
        if (t != null) {
            listTugasKu.remove(t);
            return true;
        }
        return false;
    }
}