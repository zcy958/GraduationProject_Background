package com.niit.gamecenter_game.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.niit.gamecenter_pojo.game.pojo.Game;
import com.niit.gamecenter_pojo.game.vo.TypeVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GameMapper extends BaseMapper<Game> {

    int addGameToType(@Param("gameId") String gameId,
                        @Param("typeIds") List<String> typeIds);
    @Delete("delete from sg_game_type where game_id = #{gameId}")
    int delGameToType(String gameId);

    @Select("SELECT a.type_id,a.type_name from sg_type a WHERE (type_id) \n" +
            "in (SELECT type_id from sg_game_type WHERE game_id = #{gameId})")
    List<TypeVo> getGameTypeById(String gameId);
}
