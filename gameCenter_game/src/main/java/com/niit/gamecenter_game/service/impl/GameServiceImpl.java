package com.niit.gamecenter_game.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niit.gamecenter_game.mapper.GameMapper;
import com.niit.gamecenter_game.service.GameService;
import com.niit.gamecenter_pojo.Result;
import com.niit.gamecenter_pojo.admin.role.pojo.Role;
import com.niit.gamecenter_pojo.game.dto.GameDto;
import com.niit.gamecenter_pojo.game.dto.GameEditDto;
import com.niit.gamecenter_pojo.game.pojo.Game;
import com.niit.gamecenter_pojo.game.vo.GameVo;
import com.niit.gamecenter_pojo.game.vo.TypeVo;
import com.niit.gamecenter_pojo.page.dto.PageDto;
import com.niit.gamecenter_pojo.page.vo.PageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    GameMapper gameMapper;

    @Override
    public PageVo<GameVo> queryRoleByPage(PageDto pageDto) {
        if(pageDto.getCurrentPage() == 0)pageDto.setCurrentPage(1);
        if(pageDto.getPageSize() == 0)pageDto.setPageSize(10);
        IPage<Game> page = new Page(pageDto.getCurrentPage(),
                pageDto.getPageSize());
        QueryWrapper<Game> queryWrapper= new QueryWrapper<>();
        if(pageDto.getQueryString()!=null){
            queryWrapper.like("game_name",pageDto.getQueryString());
        }
        if(pageDto.getStatus()!=null){
            queryWrapper.like("status",pageDto.getStatus());
        }
        IPage<Game> roleIPage = gameMapper.selectPage(page, queryWrapper);
        List<GameVo> collect = getGameVos(roleIPage.getRecords());
        return new PageVo<GameVo>(collect, (int) roleIPage.getTotal());
    }

    @Override
    public Result delGameById(String id) {
        QueryWrapper<Game> queryWrapper= new QueryWrapper<>();
        queryWrapper.like("game_id",id);
        int j = gameMapper.delGameToType(id);
        int i = gameMapper.deleteById(id);
        return new Result(i>0&&j>0,i>0&&j>0?"删除成功":"删除失败",null);
    }

    @Override
    public Result addGame(GameDto gameDto,List<String> typeIds) {
        Game game = new Game();
        BeanUtils.copyProperties(gameDto,game);
        int i = gameMapper.insert(game);
        if(typeIds.size()>0){
            int j = gameMapper.addGameToType(game.getGameId(),typeIds);
            return new Result(i>0&&j>0,i>0&&j>0?"添加成功":"添加失败",null);
        }
        return new Result(i>0,i>0?"添加成功":"添加失败",null);
    }

    @Override
    public Result editGame(GameEditDto gameEditDto,List<String> typeIds) {
        Game game = new Game();
        BeanUtils.copyProperties(gameEditDto,game);
        if(typeIds.size()>0){
            gameMapper.delGameToType(game.getGameId());
            int i = gameMapper.updateById(game);
            int j = gameMapper.addGameToType(game.getGameId(),
                    typeIds);
            return new Result(i>0&&j>0,i>0&&j>0?"更新成功":"更新失败",null);
        }
        else{
            int i = gameMapper.updateById(game);
            return new Result(i>0,i>0?"更新成功":"更新失败",null);
        }
    }

    @Override
    public List<TypeVo> getGameTypeById(String gameId) {
        return gameMapper.getGameTypeById(gameId);
    }

    private List<GameVo> getGameVos(List<Game> gameIpage) {
        List<GameVo> collect=null;
        if(gameIpage!=null){
            collect = gameIpage.stream().map(game -> {
                GameVo gameVo = new GameVo();
                BeanUtils.copyProperties(game, gameVo);
                return gameVo;
            }).collect(Collectors.toList());
        }
        return collect;
    }



}
