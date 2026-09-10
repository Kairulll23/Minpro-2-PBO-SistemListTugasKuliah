package sistem;

public class Storage {
    private String kodeTugas;
    private String namaMatkul;
    private String detailTugas;
    private String dateline;

    public Storage(String kodeTugas, String namaMatkul, String detailTugas, String dateline) {
        this.kodeTugas = kodeTugas;
        this.namaMatkul = namaMatkul;
        this.detailTugas = detailTugas;
        this.dateline = dateline;
    }

    public String getKodeTugas() { return kodeTugas; }
    public void setKodeTugas(String kodeTugas) { this.kodeTugas = kodeTugas; }

    public String getNamaMatkul() { return namaMatkul; }
    public void setNamaMatkul(String namaMatkul) { this.namaMatkul = namaMatkul; }

    public String getDetailTugas() { return detailTugas; }
    public void setDetailTugas(String detailTugas) { this.detailTugas = detailTugas; }

    public String getDateline() { return dateline; }
    public void setDateline(String dateline) { this.dateline = dateline; }

    public String cetakBaris() {
        return String.format("| %-8s | %-18s | %-28s | %-20s |", 
                kodeTugas, namaMatkul, detailTugas, dateline);
    }
}