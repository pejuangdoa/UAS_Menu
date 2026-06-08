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
        System.out.println("\n=== Struktur Menu ===");
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
        System.out.println("Pilih Menu yang akan ditambahkan submenu:");
        allMenu(false);
        System.out.println("0. Tambahkan menu baru");

        System.out.print("\nMasukkan Pilihan: ");
        int choice = scanner.nextInt();

        if (choice == 0) {
            System.out.print("\nMasukkan nama menu: ");
            String menuName = scanner.next();
            root.addChild(new MenuNode(menuName));
        } else if (choice > 0 && choice <= root.children.size()) {
            System.out.print("\nMasukkan nama submenu: ");
            String submenuName = scanner.next();
            root.children.get(choice - 1).addChild(new MenuNode(submenuName));
        } else {
            System.out.println("pilihan tidak valid");
            addMenu();
        }

    }

    // c. mencari menu tertentu
    static void searchMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nMasukkan nama menu yang ingin dicari: ");
        String target = scanner.next();

        boolean ditemukan = false;
        System.out.println("\n--- Hasil Pencarian ---");

        for (int i = 0; i < root.children.size(); i++) {
            MenuNode parent = root.children.get(i);

            if (parent.name.equalsIgnoreCase(target)) {
                System.out.println("Ditemukan: \"" + parent.name + "\" merupakan Menu Utama ke-" + (i + 1));
                ditemukan = true;
            }

            for (int j = 0; j < parent.children.size(); j++) {
                MenuNode submenu = parent.children.get(j);
                if (submenu.name.equalsIgnoreCase(target)) {
                    System.out.println("Ditemukan: \"" + submenu.name + "\" merupakan Submenu dari \"" + parent.name
                            + "\" (" + (i + 1) + (char) ('A' + j) + ")");
                    ditemukan = true;
                }
            }
        }

        if (!ditemukan) {
            System.out.println("Menu \"" + target + "\" tidak ditemukan dalam sistem.");
        }
    }

    // d. mengurutkan menu secara alfabetis
    static void sortMenu() {
        root.children.sort((a, b) -> a.name.compareTo(b.name));
        for (MenuNode child : root.children) {
            child.children.sort((a, b) -> a.name.compareTo(b.name));
        }
    }
}