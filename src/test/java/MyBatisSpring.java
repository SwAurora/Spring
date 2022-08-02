import com.korea.domain.BoardDTO;
import com.korea.mapper.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class MyBatisSpring
{
    @Autowired
    private TestMapper testMapper;

    @Test
    public void test()
    {
        String time = testMapper.getTime();
        log.info("time : " + time);
        log.info("TESTMAPPER : " + testMapper);
    }

    @Test
    public void test2()
    {
        String time2 = testMapper.getTime2();
        // log.info("time2 : " + time2);
    }

    @Test
    public void test3()
    {
        List<BoardDTO> list = testMapper.SelectAll();
        // list.forEach(dto -> log.info(String.valueOf(dto)));
    }
}
