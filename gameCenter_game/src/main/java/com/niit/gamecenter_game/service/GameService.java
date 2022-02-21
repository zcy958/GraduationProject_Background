package com.niit.gamecenter_game.service;

import com.niit.gamecenter_pojo.Result;
import com.niit.gamecenter_pojo.game.dto.GameDto;
import com.niit.gamecenter_pojo.game.dto.GameEditDto;
import com.niit.gamecenter_pojo.game.vo.GameVo;
import com.niit.gamecenter_pojo.game.vo.TypeVo;
import com.niit.gamecenter_pojo.page.dto.PageDto;
import com.niit.gamecenter_pojo.page.vo.PageVo;

import java.util.List;

public interface GameService {


    PageVo<GameVo> queryRoleByPage(PageDto pageDto);

    Result delGameById(String id);

    Result addGame(GameDto gameDto, List<String> typeIds);

    Result editGame(GameEditDto gameEditDto,List<String> typeIds);

    List<TypeVo> getGameTypeById(String gameId);
}
