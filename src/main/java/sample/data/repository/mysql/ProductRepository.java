package sample.data.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.data.entity.mysql.Product;

/**
 * 商品 DAO层
 *
 * @author liangchuanchuan
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
