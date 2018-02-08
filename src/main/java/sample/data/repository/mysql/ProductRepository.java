package sample.data.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.data.entity.mysql.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
