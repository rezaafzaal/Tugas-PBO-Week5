import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Database.init();

        
        String nrp = JOptionPane.showInputDialog("Masukkan NRP:");
        String pw = JOptionPane.showInputDialog("Masukkan Password:");

        Mahasiswa mhs = Database.login(nrp, pw);
        if (mhs == null) {
            JOptionPane.showMessageDialog(null, "Login gagal! NRP atau password salah.");
            return;
        }

        JOptionPane.showMessageDialog(null, "Selamat datang, " + mhs.getNrp());

        String pilihan;
        do {
            // tampilkan menu
            pilihan = JOptionPane.showInputDialog(
                "=== MENU KRS ===\n" +
                "1. Lihat Profil\n" +
                "2. Lihat Daftar Kelas\n" +
                "3. Ambil Kelas\n" +
                "4. Drop Kelas\n" +
                "5. Lihat Kelas yang Diambil\n" +
                "0. Keluar\n" +
                "Masukkan pilihan:"
            );

            if (pilihan == null) break; 

            switch (pilihan) {
                case "1": // Profil
                    mhs.tampilkanProfilGUI();
                    break;

                case "2": // Daftar kelas
                    StringBuilder sbKelas = new StringBuilder("=== Daftar Kelas ===\n");
                    for (Kelas k : Database.daftarKelas) {
                        sbKelas.append(k).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, sbKelas.toString());
                    break;

                case "3": // Ambil kelas
                    String kode = JOptionPane.showInputDialog("Masukkan kode kelas yang ingin diambil:");
                    Kelas ambil = Database.cariKelas(kode);
                    if (ambil != null) {
                        if (mhs.ambilKelas(ambil)) {
                            JOptionPane.showMessageDialog(null, "Berhasil ambil kelas " + ambil.getMatkul().getNama());
                        } else {
                            JOptionPane.showMessageDialog(null, "Gagal ambil kelas (penuh / SKS melebihi batas)");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Kelas tidak ditemukan.");
                    }
                    break;

                case "4": // Drop kelas
                    String kodeDrop = JOptionPane.showInputDialog("Masukkan kode kelas yang ingin di-drop:");
                    Kelas drop = Database.cariKelas(kodeDrop);
                    if (drop != null) {
                        mhs.dropKelas(drop);
                        JOptionPane.showMessageDialog(null, "Kelas berhasil di-drop.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Kelas tidak ditemukan.");
                    }
                    break;

                case "5": 
                    mhs.tampilkanKelasGUI();
                    break;

                case "0": 
                    JOptionPane.showMessageDialog(null, "Terima kasih. Keluar...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Pilihan tidak valid!");
            }
        } while (!"0".equals(pilihan));
    }
}
