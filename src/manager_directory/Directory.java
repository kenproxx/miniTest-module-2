package manager_directory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Directory implements Manager<User>{
    List<User> userList = new ArrayList<>();
    int id = 0;

    String noResult = "Khong tim thay yeu cau";

    int num;
    public Directory() throws IOException {
    }


    @Override
    public void display() {
        for (User user :
                userList) {
            System.out.println(user);
        }

    }

    @Override
    public void add(User user)  {

        user.setId(id++);
        userList.add(user);
    }

    @Override
    public void update(int id, User user) {
        if (search(id) != -1) {
            userList.set(id, user);
        } else {
            System.out.println(noResult);
        }
    }

    @Override
    public void delete(int id) {
        if (search(id) != -1) {
            userList.remove(id);
            System.out.println("Da xoa thanh cong");
        } else {
            System.out.println(noResult);
        }
    }

    @Override
    public int search(int id) {
        for (User user : userList
             ) {
            if (user.getId() == id) {
                System.out.println("user ban can tim la:" + "\n"  + user);
                return id;
            }
        }
        System.out.println(noResult);
        return -1;
    }

    @Override
    public void readCSV() {

    }

    @Override
    public void writeCSV() {

    }
}
