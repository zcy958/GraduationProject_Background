package com.niit.gamecenter_game.controller;

import com.niit.gamecenter_game.service.GameService;
import com.niit.gamecenter_game.service.TypeService;
import com.niit.gamecenter_pojo.Result;
import com.niit.gamecenter_pojo.game.dto.TypeDto;
import com.niit.gamecenter_pojo.game.dto.TypeEditDto;
import com.niit.gamecenter_pojo.game.pojo.Type;
import com.niit.gamecenter_pojo.game.vo.GameVo;
import com.niit.gamecenter_pojo.game.vo.TypeVo;
import com.niit.gamecenter_pojo.page.dto.PageDto;
import com.niit.gamecenter_pojo.page.vo.PageVo;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.reflect.Typed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game/type")
public class TypeController {
    @Autowired
    TypeService typeService;

    @PostMapping("/list")
    @ApiOperation("分页查询类型")
    public PageVo<TypeVo> queryTypeByPage(@RequestBody PageDto pageDto){
        return typeService.queryTypeByPage(pageDto);
    }
    @DeleteMapping("/{id}")
    @ApiOperation("删除类型")
    public Result delTypeById(@PathVariable String id){
        return typeService.delTypeById(id);
    }
    @PostMapping("/add")
    @ApiOperation("添加类型")
    public Result addType(@RequestBody TypeDto typeDto){
        return typeService.addType(typeDto);
    }
    @PutMapping("/edit")
    @ApiOperation("更新类型")
    public Result editType(@RequestBody TypeEditDto typeEditDto){
        return typeService.editType(typeEditDto);
    }
    @GetMapping("/all")
    @ApiOperation("获取所有类型")
    public List<Type> queryAllType(){
        return  typeService.queryAllType();
    }
}
