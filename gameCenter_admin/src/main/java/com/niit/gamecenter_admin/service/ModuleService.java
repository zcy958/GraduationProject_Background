package com.niit.gamecenter_admin.service;

import com.niit.gamecenter_pojo.Result;
import com.niit.gamecenter_pojo.admin.module.dto.ModuleDto;
import com.niit.gamecenter_pojo.admin.module.dto.ModuleEditDto;
import com.niit.gamecenter_pojo.admin.module.vo.ModuleVo;

import java.util.List;

public interface ModuleService {
    List<ModuleVo> queryAllModule();

    Result delModule(String id);

    Result addModule(ModuleDto moduleDto);

    Result editModule(ModuleEditDto moduleEditDto);
}
