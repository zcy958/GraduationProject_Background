package com.niit.gamecenter_pojo.admin.module.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.niit.gamecenter_pojo.admin.module.dto.ModuleDto;
import com.niit.gamecenter_pojo.admin.module.dto.ModuleEditDto;
import com.niit.gamecenter_pojo.admin.module.vo.ModuleListVo;
import com.niit.gamecenter_pojo.admin.module.vo.ModuleVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("ss_module")
public class Module {
    @TableId("module_id")
    private String moduleId;
    private String parentId;
    private String parentName;
    private String name;
    private String remark;
    private String createBy;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    private String updateBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateTime;

    public ModuleListVo toModuleListVo(Module module){
        ModuleListVo moduleListVo = new ModuleListVo();
        BeanUtils.copyProperties(this,moduleListVo);
        return moduleListVo;
    }

}
