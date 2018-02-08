package sample.data.dataimport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sample.data.entity.mysql.Product;
import sample.data.service.ProductService;

import java.util.Arrays;
import java.util.Date;

/**
 * mysql 数据导入
 *
 * @author liangchuanchuan
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MySqlDataImport {

    @Autowired
    private ProductService productService;

    @Test
    public void importData() {
        Product product1 = new Product("高领毛衣", 1, "衣服", 100D, 22, "春秋冬季节卫衣是首选，卫衣就是值得炫耀的春秋单品，此款卫衣显得宽大，是休闲类服饰中很受欢迎的服饰哦个性字母数字图案，圆领及新颖的款式设计更显时尚大方喜欢的MM千万不要错过哦~ ", "www.dongao.com", new Date());
        Product product2 = new Product("复古毛衣", 1, "衣服", 100D, 22, "修身款式 带帽设计 中长款型 自然大方的纯色 下摆抽绳  袖口可挽起  斜插隐形口袋  保暖舒适  ", "www.dongao.com", new Date());

        Product product3 = new Product("轻松过关1", 2, "图书", 100D, 22, "上下分册，厚书变薄，字体变大全面复习，夯实基础 ", "www.dongao.com", new Date());
        Product product4 = new Product("轻松过关2", 2, "图书", 100D, 22, "紧贴机考，通关题库易混集训，专项攻克 ", "www.dongao.com", new Date());
        Product product5 = new Product("轻松过关3", 2, "图书", 100D, 22, "小身材大智慧，高度浓缩精华 ", "www.dongao.com", new Date());
        Product product6 = new Product("轻松过关4", 2, "图书", 100D, 22, "六套经典试卷，考前必刷 ", "www.dongao.com", new Date());
        Product product7 = new Product("轻松过关5", 2, "图书", 100D, 22, "彩色地图版思维导图 ", "www.dongao.com", new Date());

        productService.save(Arrays.asList(product1, product2, product3, product4, product5, product6, product7));
    }


}
