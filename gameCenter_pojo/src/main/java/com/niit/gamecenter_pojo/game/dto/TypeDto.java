package com.niit.gamecenter_pojo.game.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeDto {
    private String typeName;
    private String typeNameEn;
    private String status;
    private String createBy;
}
