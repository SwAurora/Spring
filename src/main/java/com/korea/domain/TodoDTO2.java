package com.korea.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TodoDTO2
{
    private String title;
    @DateTimeFormat(pattern = "yyyy/MM/dd/HH/mm/ss")
    private Date date;
}
