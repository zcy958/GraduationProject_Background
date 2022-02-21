package com.niit.gamecenter_admin.service.impl;

import com.niit.gamecenter_admin.mapper.ModuleMapper;
import com.niit.gamecenter_admin.service.ModuleService;
import com.niit.gamecenter_pojo.Result;
import com.niit.gamecenter_pojo.admin.module.dto.ModuleDto;
import com.niit.gamecenter_pojo.admin.module.dto.ModuleEditDto;
import com.niit.gamecenter_pojo.admin.module.pojo.Module;
import com.niit.gamecenter_pojo.admin.module.vo.ModuleListVo;
import com.niit.gamecenter_pojo.admin.module.vo.ModuleVo;
import com.niit.gamecenter_pojo.admin.role.dto.RoleEditDto;
import com.niit.gamecenter_pojo.admin.role.pojo.Role;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ModuleServiceImpl implements ModuleService {
    @Autowired
    ModuleMapper moduleMapper;

    @Override
    public List<ModuleVo> queryAllModule() {
        List<Module> list = moduleMapper.selectList(null);
        List<ModuleListVo> moduleListVos = new ArrayList<>();
        List<ModuleVo> moduleVos = new ArrayList<>();
        for(Module module : list){
            moduleListVos.add(module.toModuleListVo(module));
        }
        List<ModuleListVo> moduleListVoList =
                switchNodeListToTree(moduleListVos);
        moduleVos = recursiveList(moduleListVoList);
        return moduleVos;
    }

    @Override
    public Result delModule(String id) {
        int i = moduleMapper.deleteById(id);
        return new Result(i>0,i>0?"删除成功":"删除失败",null);
    }

    @Override
    public Result addModule(ModuleDto moduleDto) {
        Module module = moduleDto.toModule(moduleDto);
        int i = moduleMapper.insert(module);
        return new Result(i>0,i>0?"添加成功":"添加失败",null);
    }

    @Override
    public Result editModule(ModuleEditDto moduleEditDto) {
        Module module = moduleEditDto.toModule(moduleEditDto);
        int i = moduleMapper.updateById(module);
        return new Result(i>0,i>0?"编辑成功":"编辑失败",null);
    }

    public static List<ModuleListVo> switchNodeListToTree(List<ModuleListVo> nodes){
        List<ModuleListVo> root = getRoot(nodes);
        List<ModuleListVo> list = new ArrayList<>();
        for(ModuleListVo dto : root)
            list.add(recursive(dto, nodes));
        return list;
    }

    public static List<ModuleListVo> getRoot(List<ModuleListVo> nodes){
        List<ModuleListVo> root = new ArrayList<>();
        if(nodes != null && nodes.size() > 0){
            for (ModuleListVo treeNode : nodes) {
                if(treeNode.getParentId() == null){
                    root.add(treeNode);
                }
            }
        }
        return root;
    }

    public static ModuleListVo recursive(ModuleListVo rootNode,List<ModuleListVo> nodes){
        for(ModuleListVo treeNode :nodes){
            try {
                if(rootNode.getModuleId().equals(treeNode.getParentId())){
                    rootNode.getChildren().add(treeNode);
                    recursive(treeNode, nodes);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return rootNode;
    }

    public List<ModuleVo> recursiveList(List<ModuleListVo> moduleListDtos){
        List<ModuleVo> list = new ArrayList<ModuleVo>();
        for(ModuleListVo dto : moduleListDtos){
            ModuleVo vo1= new ModuleVo();
            vo1.setId(dto.getModuleId());
            vo1.setLabel(dto.getName());
            if(dto.getChildren()!=null){
                List<ModuleVo> vo2 = new ArrayList<>();
                vo1.setChildren(recursiveList(dto.getChildren()));
            }
            list.add(vo1);
        }
        return list;
    }
}
