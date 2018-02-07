package sample.data.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.data.entity.Teacher;

/**
 * 老师DAO 操作
 *
 * @author liangchuanchuan
 */
public interface TeacherRepository extends JpaRepository<Teacher, Long> {


}