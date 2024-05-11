package repository;

import entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DirectoryProductRepository implements Repository<Product> {
    static File dir = new File("dir.txt");

    public DirectoryProductRepository(File dir) {
        DirectoryPersonRepository.dir = dir;
        if (!dir.exists()) {
            try {
                dir.mkdir();
            }
            catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }
    }
    @Override
    public void save(Product product) throws IOException {
        String nameOfFile;
        nameOfFile = Integer.toString(product.id);
        File fileId = new File(dir.getPath() + "/" + nameOfFile + ".txt");
        try (FileOutputStream stream = new FileOutputStream(fileId)) {
            try (PrintWriter writer = new PrintWriter(stream)) {
                writer.println(product.id);
                writer.println(product.name);
                writer.println(product.price);
            }
        }
    }

    @Override
    public Product load(int id) throws IOException {
        File file = new File(dir.getPath() + "/" + id + ".txt");
        try (FileInputStream stream = new FileInputStream(file)) {
            try (Scanner scanner = new Scanner(stream)) {
                return new Product(
                        new Integer(scanner.nextLine()),
                        scanner.nextLine(),
                        new Double(Double.parseDouble(scanner.nextLine()))
                );
            }
        }
    }

    @Override
    public List<Product> load(List<Integer> ids) throws IOException {
        List<Product> list = new ArrayList<>();
        for (Integer id : ids) {
            list.add(load(id));
        }
        return list;
    }
}
