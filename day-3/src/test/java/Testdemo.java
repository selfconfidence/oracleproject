import com.day03.dao.UserDao;
import com.day03.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author misterWei
 * @create 2018年09月28号:12点03分
 * @mailbox mynameisweiyan@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-jpa.xml")
public class Testdemo {
    @Autowired
  private UserDao userDao;
    @Test
    public void demo1(){
        List<User> userList = userDao.findByUName("张三");
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
