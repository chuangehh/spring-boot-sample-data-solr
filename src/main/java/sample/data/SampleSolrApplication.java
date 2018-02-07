package sample.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sample.data.entity.Product;
import sample.data.repository.solr.ProductRepository;

/**
 * SpringBoot
 *
 * @author liangchuanchuan
 */
@SpringBootApplication
public class SampleSolrApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository repository;

    @Override
    public void run(String... args) throws Exception {
        this.repository.deleteAll();

        // insert some products
        this.repository.save(new Product("1", "Nintendo Entertainment System"));
        this.repository.save(new Product("2", "Sega Megadrive"));
        this.repository.save(new Product("3", "Sony Playstation"));

        // fetch all
        System.out.println("Products found by findAll():");
        System.out.println("----------------------------");
        for (Product product : this.repository.findAll()) {
            System.out.println(product);
        }
        System.out.println();

        // fetch a single product
        System.out.println("Products found with findByNameStartingWith('So'):");
        System.out.println("--------------------------------");
        for (Product product : this.repository.findByNameStartingWith("So")) {
            System.out.println(product);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleSolrApplication.class, args);
    }

}
