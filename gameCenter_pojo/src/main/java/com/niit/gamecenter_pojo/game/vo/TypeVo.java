package com.niit.gamecenter_pojo.game.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeVo {
    private String typeId;
    private String typeName;
    private String typeNameEn;
    private String status;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private String updateTime;
}
