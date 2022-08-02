package com.korea.controller;

import com.korea.domain.SampleDTO;
import com.korea.domain.SampleDTOList;
import com.korea.domain.TodoDTO;
import com.korea.domain.TodoDTO2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

@Controller
@Slf4j
@RequestMapping("/sample/*")
public class SampleController
{
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test1()
    {
        log.info("URL : /test");
    }

    @GetMapping("/test2")
    public void test2()
    {
        log.info("URL : /test2");
    }

    @GetMapping("/test3")
    public void test3(SampleDTO dto)
    {
        log.info("dto's info : " + dto);
    }

    @GetMapping("/test4")
    public void test4(@RequestParam("name") String name, @RequestParam("age") int age)
    {
        log.info("URL : /test4");
        log.info("name : " + name + " age : " + age);
    }

    @GetMapping("/test5")
    public void test5(@RequestParam("name") String[] list)
    {
        log.info("URL : /test5");
        for(String s : list)
        {
            log.info(s);
        }
    }

    @GetMapping("/test6")
    public void test6(SampleDTOList list)
    {
        log.info("URL : /test6");
        for(SampleDTO dto : list.getList())
        {
            log.info(dto.toString());
        }
    }

    // @InitBinder를 이용해서 커스텀 데이터 타입 변환을 처리 가능
    // new CustomDateEditor(dateFormat, true) true : null 허용 false : null 허용X
    /*@InitBinder
    public void initBinder(WebDataBinder binder)
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(df, false));
    }*/

    @GetMapping("/test7")
    public void test7(TodoDTO dto)
    {
        log.info("URL : /test7");
        log.info(String.valueOf(dto));
    }

    @GetMapping("/test8")
    public void test8(TodoDTO2 dto)
    {
        log.info("URL : /test8");
        log.info(String.valueOf(dto));
    }
}
