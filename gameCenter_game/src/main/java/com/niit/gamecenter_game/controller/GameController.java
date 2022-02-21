package com.niit.gamecenter_game.controller;

import com.niit.gamecenter_game.service.GameService;
import com.niit.gamecenter_pojo.Result;
import com.niit.gamecenter_pojo.admin.role.vo.RoleVo;
import com.niit.gamecenter_pojo.game.dto.GameDto;
import com.niit.gamecenter_pojo.game.dto.GameEditDto;
import com.niit.gamecenter_pojo.game.pojo.Game;
import com.niit.gamecenter_pojo.game.vo.GameVo;
import com.niit.gamecenter_pojo.game.vo.TypeVo;
import com.niit.gamecenter_pojo.page.dto.PageDto;
import com.niit.gamecenter_pojo.page.vo.PageVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    GameService gameService;

    @PostMapping("/list")
    @ApiOperation("分页查询游戏")
    public PageVo<GameVo> queryGameByPage(@RequestBody PageDto pageDto){
        return gameService.queryRoleByPage(pageDto);
    }
    @DeleteMapping("/{id}")
    @ApiOperation("删除游戏")
    public Result delGameById(@PathVariable String id){
        return gameService.delGameById(id);
    }
    @PostMapping("/add")
    @ApiOperation("添加游戏")
    public Result addGame(@RequestBody GameDto gameDto){
        return gameService.addGame(gameDto,gameDto.getTypeIds());
    }
    @PutMapping("/edit")
    @ApiOperation("编辑游戏")
    public Result editGame(@RequestBody GameEditDto gameEditDto){
        return gameService.editGame(gameEditDto,gameEditDto.getTypeIds());
    }
    @GetMapping("/gameType/{gameId}")
    @ApiOperation("根据游戏ID获取游戏类型")
    public List<TypeVo> getGameTypeById(@PathVariable("gameId") String gameId){
        return gameService.getGameTypeById(gameId);
    }

}
