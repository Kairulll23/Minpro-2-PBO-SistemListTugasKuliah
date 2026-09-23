package model;

public class TugasIndividu extends Tugas {
    private String linkPengumpulan;

    public TugasIndividu(String kodeTugas, String namaMatkul, String detailTugas, String dateline, String linkPengumpulan) {
        super(kodeTugas, namaMatkul, detailTugas, dateline);
        this.linkPengumpulan = linkPengumpulan;
    }

    public String getLinkPengumpulan() { return linkPengumpulan; }
    public void setLinkPengumpulan(String linkPengumpulan) { this.linkPengumpulan = linkPengumpulan; }

    @Override
    public String getTipeTugas() {
        return "Individu";
    }

    @Override
    public String cetakBaris() {
        return String.format("| %-8s | %-10s | %-16s | %-22s | %-18s | %-20s |", 
                getKodeTugas(), getTipeTugas(), getNamaMatkul(), getDetailTugas(), getDateline(), "Link: " + linkPengumpulan);
    }
}