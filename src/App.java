import java.util.Scanner;

public class App {

    static void InitialData() {

        MenuNode mahasiswa = new MenuNode("Mahasiswa");
        MenuNode dosen = new MenuNode("Dosen");
        MenuNode keuangan = new MenuNode("Keuangan");

        Functions.root.addChild(mahasiswa);
        Functions.root.addChild(dosen);
        Functions.root.addChild(keuangan);

        mahasiswa.addChild(new MenuNode("KRS"));
        mahasiswa.addChild(new MenuNode("Jadwal"));
        mahasiswa.addChild(new MenuNode("Nilai"));

        dosen.addChild(new MenuNode("Input Nilai"));
        dosen.addChild(new MenuNode("Presensi"));

        keuangan.addChild(new MenuNode("Pembayaran"));
        keuangan.addChild(new MenuNode("Tagihan"));
    }

    static void help() {
        System.out.println("\n=== Bantuan ===");
        System.out.println("/h - Tampilkan bantuan ini");
        System.out.println("/q - Keluar dari program");
        System.out.println("/f - Cari menu/submenu");
        System.out.println("/a - Tambah menu/submenu");
        System.out.println("/s - Urutkan menu dan submenu");

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nTekan Enter untuk kembali...");
        scanner.nextLine();
        home();
    }

    static void run(String input) {
        switch (input) {
            case "/h":
                help();
                break;
            case "/q":
                System.exit(0);
                break;
            case "/a":
                Functions.addMenu();
                home();
                break;
            case "/s":
                Functions.sortMenu();
                home();
                break;
            case "/f":
                Functions.searchMenu();
                home();
                break;
            default:
                System.out.println("Perintah tidak valid");
                home();
                break;
        }
    }

    static void home() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Aplikasi Menu ===");
        System.out.println("Ketik /h untuk bantuan");

        Functions.allMenu(true);
        System.out.print("\nMasukkan Perintah: ");
        String input = scanner.nextLine();

        run(input);
    }

    public static void main(String[] args) throws Exception {
        InitialData();
        home();
    }
}
