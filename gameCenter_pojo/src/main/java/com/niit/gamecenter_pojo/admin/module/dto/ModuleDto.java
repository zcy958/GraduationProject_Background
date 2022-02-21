package com.niit.gamecenter_pojo.admin.module.dto;

import com.niit.gamecenter_pojo.admin.module.pojo.Module;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModuleDto {
    private String parentId;
    private String parentName;
    private String name;
    private String createBy;


    public Module toModule(ModuleDto moduleDto){
        Module module = new Module();
        BeanUtils.copyProperties(this,module);
        return module;
    }
}
