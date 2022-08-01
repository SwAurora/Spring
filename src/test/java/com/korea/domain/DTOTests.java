package com.korea.domain;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class DTOTests
{
    @Autowired
    private TestDTO testdto;

    @Test
    public void test()
    {
        // TestDTO dto = new TestDTO("홍길동", "44", "대구");
        TestDTO dto = TestDTO.builder()
                .age("55")
                .name("홍길동")
                .addr("주소")
                .build();
        System.out.println(dto);
    }

    @Test
    public void test2()
    {
        log.info("TESTDTO : " + testdto);
    }
}
