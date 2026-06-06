import java.util.ArrayList;
import java.util.Scanner;

class MenuNode {
    String name;
    ArrayList<MenuNode> children;

    public MenuNode(String name) {
        this.name = name;
        this.children = new ArrayList<MenuNode>();
    }

    public void addChild(MenuNode child) {
        this.children.add(child);
    }
}

public class Functions {
    static MenuNode root = new MenuNode("Root");

    // b. menampilkan seluruh menu
    static void allMenu(boolean showSubmenu) {
        System.out.println("\n=== All Menu ===");
        for (int i = 0; i < root.children.size(); i++) {
            MenuNode child = root.children.get(i);
            System.out.println((i + 1) + ". " + child.name);
            if (showSubmenu) {
                for (int j = 0; j < child.children.size(); j++) {
                    System.out.println("  " + (i + 1) + (char) ('A' + j) + ". " + child.children.get(j).name);
                }
            }
        }
    }

    // a. input menu baru
    static void addMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pilih menu untuk menambah submenu:");
        allMenu(false);
        System.out.println("0. Tambah menu baru");

        System.out.print("\nMasukkan pilihan: ");
        int choice = scanner.nextInt();

        if (choice == 0) {
            //TODO: buat fitur tambah menu
            System.out.println("fitur belum dibuat");
        } else if (choice > 0 && choice <= root.children.size()) {
            // TODO: buat fitur tambah submenu
            System.out.println("fitur belum dibuat");
        } else {
            System.out.println("Pilihan tidak valid");
            addMenu();
        }

    }

    // c. mencari menu tertentu
    static void searchMenu() {
        // TODO: buat fitur cari menu
        System.out.println("fitur belum dibuat");
    }

    // d. mengurutkan menu secara alfabetis
    static void sortMenu() {
        // TODO: buat fitur urutkan menu
        System.out.println("fitur belum dibuat");
    }
}
