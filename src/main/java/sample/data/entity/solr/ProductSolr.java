package sample.data.entity.solr;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.Date;

/**
 * 商品 solr
 *
 * @author liangchuanchuans
 */
@SolrDocument(solrCoreName = "product")
public class ProductSolr {

    @Field
    private Long id;

    /**
     * 商品名称
     */
    @Field
    private String name;

    /**
     * 商品分类
     */
    @Field
    private int catalog;

    /**
     * 商品分类名称
     */
    @Field("catalog_name")
    private String catalogName;

    /**
     * 价格
     */
    @Field
    private double price;

    /**
     * 商品数量
     */
    private int number;

    /**
     * 商品描述
     */
    @Field
    private String description;

    /**
     * 商品图片
     */
    @Field
    private String picture;

    /**
     * 发布时间
     */
    private Date createTime;

    public ProductSolr() {
    }

    public ProductSolr(String name, int catalog, String catalogName, double price, int number, String description, String picture, Date createTime) {
        this.name = name;
        this.catalog = catalog;
        this.catalogName = catalogName;
        this.price = price;
        this.number = number;
        this.description = description;
        this.picture = picture;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCatalog() {
        return catalog;
    }

    public void setCatalog(int catalog) {
        this.catalog = catalog;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", catalog=" + catalog +
                ", catalogName='" + catalogName + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", description='" + description + '\'' +
                ", picture='" + picture + '\'' +
                ", createTime=" + createTime +
                '}';
    }

}
