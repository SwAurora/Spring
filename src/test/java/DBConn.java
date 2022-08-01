import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

@Log4j
public class DBConn
{
    @Test
    public void test()
    {
        String url = "jdbc:mysql://localhost:3306/spring";
        String id = "root";
        String pw = "1234";

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, id, pw);
            log.info(conn);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
