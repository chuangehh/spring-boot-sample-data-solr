package sample.data.dataimport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sample.data.entity.Student;
import sample.data.entity.Teacher;
import sample.data.service.StudentService;
import sample.data.service.TeacherService;

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
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @Test
    public void importData() {
        // 1.保存老师信息
        Teacher 梁老师 = new Teacher("梁老师", 1, new Date());
        Teacher 崔老师 = new Teacher("崔老师", 1, new Date());
        Teacher 向老师 = new Teacher("向老师", 0, new Date());
        teacherService.save(Arrays.asList(梁老师, 崔老师, 向老师));

        // 2.保存学生信息
        Student 小明 = new Student("小明", 1, "忠言逆耳利于行，良药苦口利于玻。", new Date(), Arrays.asList(梁老师, 崔老师));
        Student 小张 = new Student("小张", 1, "谦虚是学习的朋友。", new Date(), Arrays.asList(梁老师, 崔老师, 向老师));
        Student 小花 = new Student("小花", 0, "平凡的脚步也可以走完伟大的行程。", new Date(), Arrays.asList(崔老师, 向老师));
        studentService.save(Arrays.asList(小明, 小张, 小花));
    }


}
