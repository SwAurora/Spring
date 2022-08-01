import com.korea.mapper.TestMapper;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class MybatisTests
{
    @Autowired
    private SqlSessionFactory ssf;
    @Autowired
    private TestMapper tm;

    @Test
    public void test()
    {
        SqlSession dbs = ssf.openSession();
        Connection conn = dbs.getConnection();
        log.info("Conn's obj : " + conn);
    }

    @Test
    public void test2()
    {
        log.info(tm.getClass().getName());
        log.info(tm.getTime());
    }
}
