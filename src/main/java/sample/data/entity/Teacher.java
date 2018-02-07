package sample.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 老师
 *
 * @author liangchuanchuan
 */
@Entity
public class Teacher {


    @Id
    @GeneratedValue
    private Long id;

    /**
     * 姓名
     */
    @Column
    private String name;

    /**
     * 性别
     */
    @Column
    private int sex;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    public Teacher() {
    }

    public Teacher(String name, int sex, Date createDate) {
        this.name = name;
        this.sex = sex;
        this.createDate = createDate;
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

    public int isSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
