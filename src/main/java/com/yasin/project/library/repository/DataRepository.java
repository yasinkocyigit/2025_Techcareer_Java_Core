package com.yasin.project.library.repository;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataRepository<T> {
    private final String fileName;
    public DataRepository(String fileName) {
        this.fileName = fileName;
    }

    public void saveAll(List<T> dataList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(dataList);
        } catch (IOException e) {
            System.err.println("Dosya yazma hatası: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> loadAll() {
        File file = new File(fileName);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Dosya okuma hatası: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
