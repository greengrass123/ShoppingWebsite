package test;
import com.netease.entity.User;
import com.netease.serviceImpl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2018-2-25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
public class userTest {
    @Autowired
    public UserServiceImpl userService;
    @Test
    public void saveTest(){
        User user1=new User();
        user1.setUserName("yuan2");
        user1.setPassword("1234");
        userService.save(user1);
    }

    @Test
    public void test(){
        String str="user/index";
        int st=str.indexOf("index");
        System.out.println(1);
    }

}
