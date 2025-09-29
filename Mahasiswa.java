import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Mahasiswa {
    private String nrp;
    private String nama;
    private String asal;
    private double ipk;
    private String password;
    private ArrayList<Kelas> kelasDiambil;
    private int totalSks;
    private static final int MAX_SKS = 24;

    public Mahasiswa(String nrp, String nama, String asal, double ipk, String password) {
        this.nrp = nrp;
        this.nama = nama;
        this.asal = asal;
        this.ipk = ipk;
        this.password = password;
        this.kelasDiambil = new ArrayList<>();
        this.totalSks = 0;
    }

    public String getNrp() { return nrp; }
    public String getPassword() { return password; }

    public boolean ambilKelas(Kelas k) {
        int sksBaru = totalSks + k.getMatkul().getSks();
        if (sksBaru <= MAX_SKS && k.tambahPeserta(this)) {
            kelasDiambil.add(k);
            totalSks = sksBaru;
            return true;
        }
        return false;
    }

    public void dropKelas(Kelas k) {
        if (kelasDiambil.contains(k)) {
            kelasDiambil.remove(k);
            k.hapusPeserta(this);
            totalSks -= k.getMatkul().getSks();
        }
    }

    public void tampilkanProfil() {
        System.out.println("=== Data Mahasiswa ===");
        System.out.println("NRP   : " + nrp);
        System.out.println("Nama  : " + nama);
        System.out.println("Asal  : " + asal);
        System.out.println("IPK   : " + ipk);
        System.out.println("Total SKS : " + totalSks);
    }

    public void tampilkanKelas() {
        System.out.println("Kelas yang diambil:");
        if (kelasDiambil.isEmpty()) {
            System.out.println("- Belum ada kelas diambil");
        } else {
            for (Kelas k : kelasDiambil) {
                System.out.println(k);
            }
        }
    }
    
    public void tampilkanProfilGUI() {
    String info = "=== Data Mahasiswa ===\n" +
                  "NRP   : " + nrp + "\n" +
                  "Nama  : " + nama + "\n" +
                  "Asal  : " + asal + "\n" +
                  "IPK   : " + ipk + "\n" +
                  "Total SKS : " + totalSks;
    JOptionPane.showMessageDialog(null, info);
}

public void tampilkanKelasGUI() {
    StringBuilder sb = new StringBuilder("Kelas yang diambil:\n");
    if (kelasDiambil.isEmpty()) {
        sb.append("- Belum ada kelas diambil");
    } else {
        for (Kelas k : kelasDiambil) {
            sb.append(k).append("\n");
        }
    }
    JOptionPane.showMessageDialog(null, sb.toString());
}
}
