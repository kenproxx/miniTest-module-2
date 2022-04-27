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
        directory.add(new User(string2,string1,string5,string3,string4));
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
            directory.userList.set(int1, new User(string2,string1,string5,string3,string4));
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
        File file = new File("D:\\Java\\MiniTest_Module2\\MiniTest\\src\\data\\directory.csv");

//        FileWriter fileWriter = new FileWriter(file);
        List<String> arr = new ArrayList<>();
        FileReader fileReader = new FileReader("D:\\Java\\MiniTest_Module2\\MiniTest\\src\\data\\directory.csv");
        Scanner scanner1 = new Scanner(fileReader);
        while (scanner1.hasNext()) {
            String a = String.valueOf(scanner1.nextLine().split(","));
            System.out.println(a);
        }


//        for (; scanner1.hasNext(); ) {
//            string1 = scanner1.nextLine();
////            string2 = String.valueOf(fileReader.read());
//            System.out.println(string1);
//        }
//        while (arr.size() != -1) {
//            directory.add(new User(arr.get(2), arr.get(1),  arr.get(0), arr.get(3), arr.get(4) ));
//            arr.remove(0);
//            arr.remove(1);
//            arr.remove(2);
//            arr.remove(3);
//            arr.remove(4);
//        }
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
                    "," + user.getEmail() ;
            fileWriter.write(person);

        }
        fileWriter.close();
        System.out.println("Da ghi thanh cong");
        menuMain();
    }
}
