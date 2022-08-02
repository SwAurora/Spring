package com.korea.mapper;

import com.korea.domain.BoardDTO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TestMapper
{
    @Select("select sysdate() from dual")
    String getTime();

    String getTime2();

    @Select("select * from tbl_board")
    List<BoardDTO> SelectAll();
}
