package sample.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sample.data.entity.Student;
import sample.data.repository.mysql.StudentRepository;

/**
 * 学生 service
 *
 * @author liangchuanchuan
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional(rollbackFor = Exception.class)
    public void save(Iterable<Student> students) {
        studentRepository.save(students);
    }

}
