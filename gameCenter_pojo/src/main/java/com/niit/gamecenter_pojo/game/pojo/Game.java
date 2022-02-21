package com.niit.gamecenter_pojo.game.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("sg_game")
public class Game {
    @TableId("game_id")
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
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    private String updateBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateTime;
}
