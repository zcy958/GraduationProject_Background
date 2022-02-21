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
public class GameVo {
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
    private String createBy;
    private Date createTime;
    private String updateBy;
    private String updateTime;
}
