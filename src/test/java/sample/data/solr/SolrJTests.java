package sample.data.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;
import sample.data.entity.solr.ProductSolr;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * SolrJ 测试
 *
 * @author liangchuanchuan
 */
public class SolrJTests {

    private String serverUrl = "http://127.0.0.1:8983/solr/product";

    /**
     * 增加与修改
     * 增加与修改其实是一回事，只要id不存在，则增加，如果id存在，则是修改
     *
     * @throws IOException
     * @throws SolrServerException
     */
    @Test
    public void upadteIndex() throws SolrServerException, IOException {
        // 创建solr链接
        HttpSolrClient client = new HttpSolrClient(serverUrl);

        ProductSolr product1 = new ProductSolr("高领毛衣", 1, "衣服", 100D, 22, "春秋冬季节卫衣是首选，卫衣就是值得炫耀的春秋单品，此款卫衣显得宽大，是休闲类服饰中很受欢迎的服饰哦个性字母数字图案，圆领及新颖的款式设计更显时尚大方喜欢的MM千万不要错过哦~ ", "www.dongao.com", new Date());
        product1.setId(1001L);
        ProductSolr product2 = new ProductSolr("轻松过关2", 2, "图书", 100D, 22, "紧贴机考，通关题库易混集训，专项攻克 ", "www.dongao.com", new Date());
        product2.setId(1002L);
        ProductSolr product3 = new ProductSolr("轻松过关3", 2, "图书", 80D, 22, "小身材大智慧，高度浓缩精华 ", "www.dongao.com", new Date());
        product3.setId(1003L);

//        client.addBean(product1);
//        client.addBean(product2);
        client.addBeans(Arrays.asList(product1, product2));

        client.commit();
        client.close();
    }

    /**
     * 删除索引
     *
     * @throws Exception
     */
    @Test
    public void deleteIndex() throws Exception {
        HttpSolrClient client = new HttpSolrClient(serverUrl);

        //1.删除一个
//        client.deleteById("1001");

        //2.删除多个
//        client.deleteById(Arrays.asList("1001","1002"));

        //3.根据查询条件删除数据,这里的条件只能有一个，不能以逗号相隔
//        client.deleteByQuery("id:1001");

        //4.删除全部，删除不可恢复
        client.deleteByQuery("*:*");

        //一定要记得提交，否则不起作用
        client.commit();
        client.close();
    }

    /**
     * 查询
     *
     * @throws Exception
     */
    @Test
    public void search() throws Exception {
        HttpSolrClient client = new HttpSolrClient(serverUrl);

        //创建查询对象
        SolrQuery query = new SolrQuery();
        //q 查询字符串，如果查询所有*:*
        query.setQuery("name:小毛衣");

        //start row 分页信息，与mysql的limit的两个参数一致效果
        query.setStart(0);
        query.setRows(10);

        //fl 查询哪些结果出来，不写的话，就查询全部，所以我这里就不写了
//        query.set("fl", "");

        //======高亮设置===
        //开启高亮
        query.setHighlight(true);
        //高亮域
        query.addHighlightField("name");
        //前缀
        query.setHighlightSimplePre("<span style='color:red'>");
        //后缀
        query.setHighlightSimplePost("</span>");

        //执行搜索
        QueryResponse queryResponse = client.query(query);
        //搜索结果
        SolrDocumentList results = queryResponse.getResults();

        //查询出来的数量
        System.out.println("总查询出:" + results.getNumFound() + "条记录");

        //遍历搜索记录
        //获取高亮信息
        Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
        for (SolrDocument solrDocument : results) {
            System.out.println("商品id:" + solrDocument.get("id"));
            System.out.println("商品名称 :" + solrDocument.get("name"));
            System.out.println("商品分类:" + solrDocument.get("catalog"));
            System.out.println("商品分类名称:" + solrDocument.get("catalog_name"));
            System.out.println("商品价格:" + solrDocument.get("price"));
            System.out.println("商品描述:" + solrDocument.get("description"));
            System.out.println("商品图片:" + solrDocument.get("picture"));

            //输出高亮
            Map<String, List<String>> map = highlighting.get(solrDocument.get("id"));
            List<String> list = map.get("name");
            if (list != null && list.size() > 0) {
                System.out.println("高亮字段：" + list.get(0));
            }
        }
        client.close();
    }

}
