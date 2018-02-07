package sample.data.entity;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 学生
 *
 * @author liangchuanchuan
 */
@Entity
@SolrDocument(solrCoreName = "student")
public class Student {

    @Id
    @GeneratedValue
    @Field
    private Long id;

    /**
     * 姓名
     */
    @Column
    @Field
    private String name;

    /**
     * 性别
     */
    @Column
    private int sex;

    /**
     * 描述
     */
    @Column
    @Field
    private String description;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    @Field
    private Date createDate;

    /**
     * 该学生的老师
     */
    @ManyToMany
    @JoinTable(name = "student_teacher_link",
            joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "teacher_id", referencedColumnName = "id")}
    )
    private List<Teacher> teachers;

    /***************************************************Solr 扩展********************************************************/

    /**
     * 老师名称
     */
    @Field
    private String[] teacherNames;

    /***************************************************Solr 扩展********************************************************/

    public Student() {
    }

    public Student(String name, int sex, String description, Date createDate, List<Teacher> teachers) {
        this.name = name;
        this.sex = sex;
        this.description = description;
        this.createDate = createDate;
        this.teachers = teachers;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public String[] getTeacherNames() {
        return teacherNames;
    }

    public void setTeacherNames(String[] teacherNames) {
        this.teacherNames = teacherNames;
    }
}
