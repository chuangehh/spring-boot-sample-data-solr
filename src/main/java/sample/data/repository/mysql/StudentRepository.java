package sample.data.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.data.entity.Student;

/**
 * 学生DAO 操作
 *
 * @author liangchuanchuan
 */
public interface StudentRepository extends JpaRepository<Student, Long> {



}
