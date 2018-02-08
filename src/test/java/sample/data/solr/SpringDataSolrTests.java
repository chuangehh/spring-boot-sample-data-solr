package sample.data.solr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.test.context.junit4.SpringRunner;
import sample.data.entity.mysql.Product;
import sample.data.entity.solr.ProductSolr;
import sample.data.repository.solr.ProductSolrRepository;
import sample.data.service.ProductService;
import sample.data.util.ConvertUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataSolrTests {

    @Autowired
    private ProductSolrRepository productSolrRepository;
    @Autowired
    private ProductService productService;

    /**
     * 增加与修改
     */
    @Test
    public void upadteIndex() {
        // mysql保存
        Product product1 = new Product("轻松过关1", 2, "图书", 100D, 22, "上下分册，厚书变薄，字体变大全面复习，夯实基础 ", "www.dongao.com", new Date());
        Product product2 = new Product("轻松过关2", 2, "图书", 100D, 22, "紧贴机考，通关题库易混集训，专项攻克 ", "www.dongao.com", new Date());
        List<Product> saveMysqlList = productService.save(Arrays.asList(product1, product2));

        // solr保存
        productSolrRepository.save(ConvertUtil.listToList(saveMysqlList, ProductSolr.class));
    }

    /**
     * 删除索引
     */
    @Test
    public void deleteIndex() {
        // 根据id删除
//        productSolrRepository.delete("1");

        // 根据查询出来的内容删除
        PageRequest pageRequest = new PageRequest(0, 10);
        Page<ProductSolr> page = productSolrRepository.findByNameOrDescription("", "上下分册", pageRequest);

        List<ProductSolr> content = page.getContent();
        productSolrRepository.delete(content);
    }


    /**
     * 查找全部学生并放入solr 中
     */
    @Test
    public void search() {
        // spring data 第一页为 0
        PageRequest pageRequest = new PageRequest(0, 10);
        Page<ProductSolr> page = productSolrRepository.findByNameOrDescription("过关", "上下分册", pageRequest);
        System.out.println("page.getContent().size(): " + page.getContent().size());
        System.out.println(page.getContent());

        HighlightPage<ProductSolr> highlightPage = productSolrRepository.findByNameIn(Arrays.asList("过关", "毛衣"), pageRequest);
        // 设置高亮对象
        for (HighlightEntry<ProductSolr> productSolrHighlightEntry : highlightPage.getHighlighted()) {
            // solr实体对象 eq highlightPage.getContent().get(i)
            ProductSolr entity = productSolrHighlightEntry.getEntity();
            // solr高亮属性
            List<HighlightEntry.Highlight> highlights = productSolrHighlightEntry.getHighlights();
            for (HighlightEntry.Highlight highlight : highlights) {
                String name = highlight.getField().getName();
                if (name.equals("name")) {
                    // 此处为何为复数?  solr是运行为多值的
                    List<String> snipplets = highlight.getSnipplets();
                    entity.setName(snipplets.get(0));
                }
            }
        }

        System.out.println("highlightPage.getContent().size(): " + highlightPage.getContent().size());
        System.out.println(highlightPage.getContent());
    }


}
