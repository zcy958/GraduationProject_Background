package com.niit.gamecenter_game.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niit.gamecenter_game.mapper.TypeMapper;
import com.niit.gamecenter_game.service.TypeService;
import com.niit.gamecenter_pojo.Result;
import com.niit.gamecenter_pojo.game.dto.TypeDto;
import com.niit.gamecenter_pojo.game.dto.TypeEditDto;
import com.niit.gamecenter_pojo.game.pojo.Type;
import com.niit.gamecenter_pojo.game.vo.TypeVo;
import com.niit.gamecenter_pojo.page.dto.PageDto;
import com.niit.gamecenter_pojo.page.vo.PageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeMapper typeMapper;

    @Override
    public PageVo<TypeVo> queryTypeByPage(PageDto pageDto) {
        if(pageDto.getCurrentPage() == 0)pageDto.setCurrentPage(1);
        if(pageDto.getPageSize() == 0)pageDto.setPageSize(10);
        IPage<Type> page = new Page(pageDto.getCurrentPage(),
                pageDto.getPageSize());
        QueryWrapper<Type> queryWrapper= new QueryWrapper<>();
        if(pageDto.getQueryString()!=null){
            queryWrapper.like("type_name",pageDto.getQueryString());
        }
        if(pageDto.getStatus()!=null){
            queryWrapper.like("status",pageDto.getStatus());
        }
        IPage<Type> typeIPage = typeMapper.selectPage(page, queryWrapper);
        List<TypeVo> collect = getTypeVos(typeIPage.getRecords());
        return new PageVo<TypeVo>(collect, (int) typeIPage.getTotal());
    }

    @Override
    public Result delTypeById(String id) {
        int i = typeMapper.deleteById(id    );
        return new Result(i>0,i>0?"删除成功":"删除失败",null);
    }

    @Override
    public Result addType(TypeDto typeDto) {
        Type type = new Type();
        BeanUtils.copyProperties(typeDto,type);
        int i = typeMapper.insert(type);
        return new Result(i>0,i>0?"添加成功":"添加失败",null);
    }

    @Override
    public Result editType(TypeEditDto typeEditDto) {
        Type type = new Type();
        BeanUtils.copyProperties(typeEditDto,type);
        int i = typeMapper.updateById(type);
        return new Result(i>0,i>0?"更新成功":"更新失败",null);
    }

    @Override
    public List<Type> queryAllType() {
        return typeMapper.selectList(null);
    }

    private List<TypeVo> getTypeVos(List<Type> gameIpage) {
        List<TypeVo> collect=null;
        if(gameIpage!=null){
            collect = gameIpage.stream().map(type-> {
                TypeVo typeVo = new TypeVo();
                if(type.getStatus().equals("1"))type.setStatus("启用");
                else
                if(type.getStatus().equals("0"))type.setStatus("禁用");
                BeanUtils.copyProperties(type, typeVo);
                return typeVo;
            }).collect(Collectors.toList());
        }
        return collect;
    }
}
