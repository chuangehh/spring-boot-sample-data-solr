package sample.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sample.data.entity.Teacher;
import sample.data.repository.mysql.TeacherRepository;

import java.util.List;

/**
 * 老师 service
 *
 * @author liangchuanchuan
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Transactional(rollbackFor = Exception.class)
    public void save(List<Teacher> teachers) {
        teacherRepository.save(teachers);
    }

}
