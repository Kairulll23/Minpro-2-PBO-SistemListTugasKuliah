package sistem;

public class Pengguna {
    private String nim;
    private String nama;

    public Pengguna(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public String getNim() { return nim; }
    public String getNama() { return nama; }
}