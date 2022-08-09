package com.korea.controller;

import com.korea.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/test9")
    public void test9(SampleDTO dto, Model model)
    {
        log.info("URL : /test9");
        log.info("dto : " + dto);

        model.addAttribute("dto", dto);
    }

    @GetMapping("/test10")
    public String test10()
    {
        log.info("URL : /test10");

        return "/test10";
    }

    @GetMapping("/forward")
    public String Forward(SampleDTO dto, Model model)
    {
        log.info("URL : /forward");

        model.addAttribute("dto", dto);

        return "forward:result";
    }

    @GetMapping("/redirect")
    public String Redirect(SampleDTO dto, RedirectAttributes rttr)
    {
        log.info("URL : /redirect");

        rttr.addFlashAttribute("dto", dto);

        return "redirect:result";
    }

    @GetMapping("/result")
    public void Result(Model model)
    {
        log.info("URL : /result");
        BoardDTO dto = BoardDTO.builder()
                .no(1010)
                .content("내용")
                .writer("작성자")
                .build();

        model.addAttribute("board", dto);
    }

    @GetMapping("/objectTest")
    public @ResponseBody SampleDTO ObjectTest()
    {
        SampleDTO dto = new SampleDTO();
        dto.setName("홍길동");
        dto.setAge(55);

        return dto;
    }

    @GetMapping("/objectTest2")
    public ResponseEntity<SampleDTO> ObjectTest2()
    {
        SampleDTO dto = new SampleDTO();
        dto.setName("홍길동");
        dto.setAge(55);

        HttpHeaders header = new HttpHeaders();
        header.add("content-Type", "application/json; charset=UTF-8");

        return new ResponseEntity<>(dto, header, HttpStatus.OK);
    }
}
