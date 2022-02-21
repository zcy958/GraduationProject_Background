package com.niit.gamecenter_admin.controller;


import com.niit.gamecenter_admin.service.ModuleService;
import com.niit.gamecenter_pojo.Result;
import com.niit.gamecenter_pojo.admin.module.dto.ModuleDto;
import com.niit.gamecenter_pojo.admin.module.dto.ModuleEditDto;
import com.niit.gamecenter_pojo.admin.module.vo.ModuleVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/module")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @PostMapping("/all")
    @ApiOperation("查询所有权限组")
    private List<ModuleVo> queryAllModule(){
        return moduleService.queryAllModule();
    }

    @DeleteMapping("/del/{id}")
    @ApiOperation("删除权限组")
    private Result delModule(@PathVariable("id") String id){
        return moduleService.delModule(id);
    }

    @PostMapping("/add")
    @ApiOperation("添加权限组")
    private Result addModule(@RequestBody ModuleDto moduleDto){
        return moduleService.addModule(moduleDto);
    }

    @PutMapping("/edit")
    @ApiOperation("编辑权限组")
    private Result editModule(@RequestBody ModuleEditDto moduleEditDto){
        return moduleService.editModule(moduleEditDto);
    }
}
