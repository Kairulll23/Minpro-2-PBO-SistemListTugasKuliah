package model;

public class TugasKelompok extends Tugas {
    private String namaKelompok;
    private int jumlahAnggota;

    public TugasKelompok(String kodeTugas, String namaMatkul, String detailTugas, String dateline, String namaKelompok, int jumlahAnggota) {
        super(kodeTugas, namaMatkul, detailTugas, dateline);
        this.namaKelompok = namaKelompok;
        this.jumlahAnggota = jumlahAnggota;
    }

    public String getNamaKelompok() { return namaKelompok; }
    public void setNamaKelompok(String namaKelompok) { this.namaKelompok = namaKelompok; }

    public int getJumlahAnggota() { return jumlahAnggota; }
    public void setJumlahAnggota(int jumlahAnggota) { this.jumlahAnggota = jumlahAnggota; }

    @Override
    public String getTipeTugas() {
        return "Kelompok";
    }

    @Override
    public String cetakBaris() {
        String infoKelompok = namaKelompok + " (" + jumlahAnggota + " Org)";
        return String.format("| %-8s | %-10s | %-16s | %-22s | %-18s | %-20s |", 
                getKodeTugas(), getTipeTugas(), getNamaMatkul(), getDetailTugas(), getDateline(), infoKelompok);
    }
}