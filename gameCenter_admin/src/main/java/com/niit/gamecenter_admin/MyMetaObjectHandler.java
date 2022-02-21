package com.niit.gamecenter_admin;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");

        this.strictInsertFill(metaObject, "createTime", () -> new Date(), Date.class); // 起始版本 3.3.3(推荐)
        this.strictUpdateFill(metaObject, "updateTime", () -> new Date(), Date.class); // 起始版本 3.3.3(推荐)

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");

        this.strictUpdateFill(metaObject, "updateTime", () -> new Date(), Date.class); // 起始版本 3.3.3(推荐)

    }
}