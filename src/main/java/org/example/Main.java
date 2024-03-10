import java.util.Scanner;

class Mahasiswa {
    private String nama, nim, jurusan;
    private static final String UNIVERSITAS = "Universitas_Muhammadiyah_Malang";

    public Mahasiswa(String nama, String nim, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    public static String tampilUniversitas() {
        return UNIVERSITAS;
    }

    private static Mahasiswa[] daftarMahasiswa = new Mahasiswa[100];
    private static int jumlahMahasiswa = 0;

    public static void addDaftarMahasiswa(String nama, String nim, String jurusan) {
        if (jumlahMahasiswa < daftarMahasiswa.length) {
            Mahasiswa mahasiswaBaru = new Mahasiswa(nama, nim, jurusan);
            daftarMahasiswa[jumlahMahasiswa] = mahasiswaBaru;
            jumlahMahasiswa++;
            System.out.println("Data mahasiswa berhasil ditambahkan.");
        } else {
            System.out.println("Kapasitas data mahasiswa penuh.");
        }
    }

    public static void tampilDataMahasiswa() {
        if (jumlahMahasiswa == 0) {
            System.out.println("Belum ada data mahasiswa yang dimasukkan.");
        } else {
            System.out.println("Data Mahasiswa:");
            System.out.println("Universitas: " + tampilUniversitas());
            for (int i = 0; i < jumlahMahasiswa; i++) {
                System.out.println("Nama: " + daftarMahasiswa[i].getNama() + ", NIM: " + daftarMahasiswa[i].getNim() + ", Jurusan: " + daftarMahasiswa[i].getJurusan());
            }
        }
    }

    // Getter untuk atribut
    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getJurusan() {
        return jurusan;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");
            int pilihMenu = input.nextInt();

            switch (pilihMenu) {
                case 1:
                    System.out.print("Masukkan nama Mahasiswa: ");
                    input.nextLine(); // membersihkan buffer
                    String nama = input.nextLine();
                    System.out.print("Masukkan NIM Mahasiswa: ");
                    String nim = input.nextLine();
                    while (nim.length() != 15) {
                        System.out.println("NIM Harus 15 Digit!!!");
                        System.out.print("Masukkan NIM Mahasiswa: ");
                        nim = input.nextLine();
                    }
                    System.out.print("Masukkan jurusan Mahasiwa: ");
                    String jurusan = input.nextLine();
                    Mahasiswa.addDaftarMahasiswa(nama, nim, jurusan);
                    break;
                case 2:
                    Mahasiswa.tampilDataMahasiswa();
                    break;
                case 3:
                    System.out.print("Adios");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Tidak Valid Coba Lagi.");
            }
        }
    }
}