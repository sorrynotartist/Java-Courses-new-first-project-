package repository;

import entity.Person;
import entity.Product;
import entity.Sale;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DirectorySaleRepository implements Repository<Sale> {

    static File dir = new File("dir.txt");

    public DirectorySaleRepository(File dir) {
        DirectoryPersonRepository.dir = dir;
        if (!dir.exists()) {
            try {
                dir.mkdir();
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    @Override
    public void save(Sale sale) throws IOException {
        String nameOfFile;
        nameOfFile = Integer.toString(sale.id);
        File fileId = new File(dir.getPath() + "/" + nameOfFile + ".txt");
        try (FileOutputStream stream = new FileOutputStream(fileId)) {
            try (PrintWriter writer = new PrintWriter(stream)) {
                writer.println(sale.id);
                writer.println(sale.amount);
                writer.println(sale.person.id);
                writer.println(sale.person.name);
                writer.println(sale.products);
                for (Map.Entry<Product, Double> productCount : sale.getProducts().entrySet()) {
                    writer.println(productCount.getKey().id());
                    writer.println(productCount.getKey().name());
                    writer.println(productCount.getKey().price());
                    writer.println(productCount.getValue());
                }
            }
        }
    }

    @Override
    public Sale load(int id) throws IOException {
        File file = new File(dir.getPath() + "/" + id + ".txt");

        return loadFromFile(file);
    }

    private static Sale loadFromFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            int id = Integer.parseInt(scanner.nextLine());

            double amount = Double.parseDouble(scanner.nextLine());
            int personId = scanner.nextInt();
            scanner.nextLine();
            String name = scanner.nextLine();

            Person person = new Person(personId, name);

            int productsSize = scanner.nextInt();
            scanner.nextLine();

            Map<Product, Double> products = new HashMap<>();
            for (int i = 0; i < productsSize; i++) {
                int productId = scanner.nextInt();
                scanner.nextLine();
                String productName = scanner.nextLine();
                double price = Double.parseDouble(scanner.nextLine());
                Product product = new Product(productId, productName, price);

                products.put(product, Double.parseDouble(scanner.nextLine()));
            }
            return new Sale(id, amount, person, products);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Sale> load(List<Integer> ids) throws IOException {
        List<Sale> list = new ArrayList<>();
        for (int i = 0; i < ids.size(); i++) {
            list.add(load(ids.get(i)));
        }
        return list;
    }

    List<Sale> loadAllByPersonId (int id) {
        return Arrays.stream(dir.listFiles())
                .map(x -> loadFromFile(x))
                .filter(x -> x.person.id == id)
                .collect(Collectors.toList());
    }
}
