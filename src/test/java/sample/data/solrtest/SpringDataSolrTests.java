package sample.data.solrtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sample.data.service.StudentService;
import sample.data.service.TeacherService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataSolrTests {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @Test
    public void findStudent(){

    }


}
