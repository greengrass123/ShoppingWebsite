package test;
import com.netease.entity.user;
import com.netease.serviceImpl.userServiceImpl;
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
    public userServiceImpl userService;
    @Test
    public void saveTest(){
        user user1=new user();
        user1.setUserName("yuan2");
        user1.setPassword("1234");
        userService.save(user1);
    }

}
