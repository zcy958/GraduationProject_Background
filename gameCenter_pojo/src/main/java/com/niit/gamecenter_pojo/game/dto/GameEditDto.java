package com.niit.gamecenter_pojo.game.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameEditDto {
    private String gameId;
    private String gameName;
    private String gameNameEn;
    private String gamePlatform;
    private String gameLanguage;
    private String introduce;
    private String productionName;
    private String issuingName;
    private String releaseDate;
    private int hot;
    private String status;
    private String updateBy;
    private List<String> typeIds = new ArrayList<>();
}
