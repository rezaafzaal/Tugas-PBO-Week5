import java.util.ArrayList;

public class Database {
    public static ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    public static ArrayList<Kelas> daftarKelas = new ArrayList<>();

    public static void init() {
        // Buat dosen
        Dosen d1 = new Dosen("19801111", "Victor Hariadi");
        Dosen d2 = new Dosen("19791212", "Fajar Baskoro");
        Dosen d3 = new Dosen("19750505", "Adhatus Solichah");
        Dosen d4 = new Dosen("19660303", "Chairul Imron");

        // Buat matkul (dengan SKS)
        MataKuliah mk1 = new MataKuliah("IF101", "Teori Graf", 3);
        MataKuliah mk2 = new MataKuliah("IF102", "Kecerdasan Artifisial", 3);
        MataKuliah mk3 = new MataKuliah("IF103", "Pemrograman Berbasis Objek", 4);
        MataKuliah mk4 = new MataKuliah("IF104", "Jaringan Komputer", 3);

        // Buat kelas (kodeKelas unik)
        daftarKelas.add(new Kelas("K01", mk1, d1, 30));
        daftarKelas.add(new Kelas("K02", mk1, d4, 25));
        daftarKelas.add(new Kelas("K03", mk2, d2, 40));
        daftarKelas.add(new Kelas("K04", mk3, d3, 35));
        daftarKelas.add(new Kelas("K05", mk4, d1, 20));

        // Daftar mahasiswa
        daftarMahasiswa.add(new Mahasiswa("5025241051", "Reza Afzaal", "Mojokerto", 4.0, "reza123"));
        daftarMahasiswa.add(new Mahasiswa("5025241152", "Ary Pasya", "Surabaya", 4.0, "pasya123"));
        daftarMahasiswa.add(new Mahasiswa("5025241153", "Hilbran Akmal", "Surabaya", 4.0, "akmal123"));
    }

    public static Mahasiswa login(String nrp, String password) {
        for (Mahasiswa m : daftarMahasiswa) {
            if (m.getNrp().equals(nrp) && m.getPassword().equals(password)) {
                return m;
            }
        }
        return null;
    }
    
    public static Kelas cariKelas(String kode) {
        for (Kelas k : daftarKelas) {
            if (k.getKodeKelas().equalsIgnoreCase(kode)) {
                return k;
            }
        }
        return null;
    }

}
