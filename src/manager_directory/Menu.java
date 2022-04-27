package manager_directory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    String noResult = "Khong tim thay yeu cau";
    Directory directory = new Directory();
    String str = "";
    String string1;
    String string2;
    String string3;
    String string4;
    String string5;
    String string7;
    String[] string6;
    final String PATH = "D:\\Java\\MiniTest_Module2\\MiniTest\\src\\data\\directory.csv";
    int int1;
    int int2;
    int int3;
    int int4;
    int choice;
    Scanner scanner = new Scanner(System.in);

    public Menu() throws IOException {
    }

    public void menuMain() throws IOException {
        str = """
                                
                ----------------------------------|
                                                  |
                ---CHUONG TRINH QUAN LY DANH BA---|
                -Chon chuc nang theo so-----------|
                1. Xem danh sach                  |
                2. Them moi                       |
                3. Cap nhat                       |
                4. Xoa                            |
                5. Tim kiem                       |
                6. Doc tu file                    |
                7. Ghi vao file                   |
                8. Thoat                          |
                                                  |
                ----------------------------------|
                """;
        System.out.println(str);
        choice = scanner.nextInt();

        switch (choice) {
            case 1 -> menuDisplay();
            case 2 -> menuAdd();
            case 3 -> menuUpdate();
            case 4 -> menuDelete();
            case 5 -> menuSearch();
            case 6 -> menuRead();
            case 7 -> menuWrite();
            case 8 -> System.exit(1);
        }

    }


    public void menuDisplay() throws IOException {
        for (User user : directory.userList) {
            System.out.println(user);
        }
        menuMain();
    }

    public void menuAdd() throws IOException {

        System.out.println("Nhap vao SDT");
        scanner.nextLine();
        string5 = scanner.nextLine();
        System.out.println("Nhap vao ten");
        string1 = scanner.nextLine();
        System.out.println("Nhap vao gioi tinh");
        string2 = scanner.nextLine();
        System.out.println("Nhap vao dia chi");
        string3 = scanner.nextLine();
        System.out.println("Nhap vao Email");
        string4 = scanner.nextLine();
        directory.add(new User(string2, string1, string5, string3, string4));
        System.out.println("Da tao moi thanh cong");
        menuMain();
    }

    public void menuUpdate() throws IOException {
        System.out.println("Nhap vao ID can sua");
        int1 = scanner.nextInt();
        if (directory.search(int1) != -1) {
            System.out.println("Nhap thong tin can sua");
            System.out.println("Nhap vao SDT");
            string5 = scanner.nextLine();
            scanner.nextLine();
            System.out.println("Nhap vao ten");
            string1 = scanner.nextLine();
            System.out.println("Nhap vao gioi tinh");
            string2 = scanner.nextLine();
            System.out.println("Nhap vao dia chi");
            string3 = scanner.nextLine();
            System.out.println("Nhap vao Email");
            string4 = scanner.nextLine();
            directory.userList.set(int1, new User(string2, string1, string5, string3, string4));
        }

        menuMain();

    }

    public void menuDelete() throws IOException {
        System.out.println("Nhap vao ID can xoa");
        int1 = scanner.nextInt();
        directory.delete(int1);
        menuMain();
    }

    public void menuSearch() throws IOException {
        System.out.println("Nhap vao ID can tim");
        int1 = scanner.nextInt();
        directory.search(int1);
        menuMain();
    }

    public void menuRead() throws IOException {
        File file1 = new File(PATH);
        List<String> arr = new ArrayList<>();
        Scanner scanner1 = new Scanner(file1);
        while (scanner1.hasNext()) {
            string6 = scanner1.nextLine().split(",");
            for (String split :
                    string6) {
                arr.add(split);
            }

        }

        for (; arr.size() > 0;  ) {
            string1 = arr.get(0);
            string2 = arr.get(1);
            string3 = arr.get(2);
            string4 = arr.get(3);
            string5 = arr.get(4);
            directory.add(new User(string3, string2, string1, string4, string5));
            arr.remove(0);
            arr.remove(0);
            arr.remove(0);
            arr.remove(0);
            arr.remove(0);
        }

            System.out.println("Da doc thanh cong");
            menuMain();
        }

        public void menuWrite() throws IOException {
            File file = new File("D:\\Java\\MiniTest_Module2\\MiniTest\\src\\data\\directory.csv");

            FileWriter fileWriter = new FileWriter(file, true);
            for (User user :
                    directory.userList) {
                String person = "\n" + user.getNumberPhone() + "," + user.getName() + ","
                        + user.getGender() + "," + user.getAddress() +
                        "," + user.getEmail();
                fileWriter.write(person);

            }
            fileWriter.close();
            System.out.println("Da ghi thanh cong");
            menuMain();
        }
    }

