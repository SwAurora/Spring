package com.korea.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface TestMapper
{
    @Select("select sysdate() from dual")
    public String getTime();
}
