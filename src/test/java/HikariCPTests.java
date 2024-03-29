import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class HikariCPTests
{
    @Autowired
    private DataSource ds;

    @Test
    public void test()
    {
        try
        {
            Connection conn = ds.getConnection();
            log.info(String.valueOf(conn));
        }
        catch(Exception e)
        {
            log.error(e.getMessage());
        }
    }
}
