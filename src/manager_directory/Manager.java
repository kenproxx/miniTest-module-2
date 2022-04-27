package manager_directory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface Manager<E> {
    void display() throws IOException;

    void add(E e) throws IOException;

    void update(int id, E e) throws IOException;

    void delete(int id) throws IOException;

    int search(int  id) throws IOException;

    void readCSV();

    void writeCSV();
}
