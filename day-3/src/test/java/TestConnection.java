import com.day03.dao.StudentDao;
import com.day03.dao.TeacherDao;
import com.day03.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author misterWei
 * @create 2018年09月28号:12点03分
 * @mailbox mynameisweiyan@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-jpa.xml")
public class TestConnection {
    @Autowired
    private StudentDao studentDao;

    @Autowired
    private TeacherDao teacherDao;

    @Test
    @Transactional
    public  void  testDemo(){
        Student one = studentDao.findOne(19l);
        System.out.println(one);
        System.out.println(one.getTeacher());
    }
}
