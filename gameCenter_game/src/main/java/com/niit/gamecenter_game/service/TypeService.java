package com.niit.gamecenter_game.service;

import com.niit.gamecenter_pojo.Result;
import com.niit.gamecenter_pojo.game.dto.TypeDto;
import com.niit.gamecenter_pojo.game.dto.TypeEditDto;
import com.niit.gamecenter_pojo.game.pojo.Type;
import com.niit.gamecenter_pojo.game.vo.TypeVo;
import com.niit.gamecenter_pojo.page.dto.PageDto;
import com.niit.gamecenter_pojo.page.vo.PageVo;

import java.util.List;

public interface TypeService {
    PageVo<TypeVo> queryTypeByPage(PageDto pageDto);

    Result delTypeById(String id);

    Result addType(TypeDto typeDto);

    Result editType(TypeEditDto typeEditDto);

    List<Type> queryAllType();
}
