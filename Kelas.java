import java.util.ArrayList;

public class Kelas {
    private String kodeKelas;
    private MataKuliah matkul;
    private Dosen dosenPengajar;
    private int kapasitas;
    private ArrayList<Mahasiswa> peserta;

    public Kelas(String kodeKelas, MataKuliah matkul, Dosen dosenPengajar, int kapasitas) {
        this.kodeKelas = kodeKelas;
        this.matkul = matkul;
        this.dosenPengajar = dosenPengajar;
        this.kapasitas = kapasitas;
        this.peserta = new ArrayList<>();
    }

    public String getKodeKelas() { return kodeKelas; }
    public MataKuliah getMatkul() { return matkul; }
    public Dosen getDosenPengajar() { return dosenPengajar; }

    public boolean tambahPeserta(Mahasiswa mhs) {
        if (peserta.size() < kapasitas) {
            peserta.add(mhs);
            return true;
        }
        return false;
    }

    public void hapusPeserta(Mahasiswa mhs) {
        peserta.remove(mhs);
    }

    @Override
    public String toString() {
        return kodeKelas + " | " + matkul + 
               " | Dosen: " + dosenPengajar.getNama() +
               " | Kapasitas: " + kapasitas + 
               " | Terisi: " + peserta.size();
    }
}
