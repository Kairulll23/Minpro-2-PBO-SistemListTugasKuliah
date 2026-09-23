package main;

import model.Mahasiswa;
import view.TugasView;

public class main {
    public static void main(String[] args) {
        Mahasiswa mhs = new Mahasiswa("2509116097", "Khairul Ikhsan");
        TugasView app = new TugasView();
        app.olahMenu(mhs);
    }
}