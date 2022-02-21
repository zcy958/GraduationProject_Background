package com.niit.file.task;

import com.niit.gamecenter_common.contants.RedisKeyConstants;
import com.niit.gamecenter_common.fastdfs.FastDFSClientUtil;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;

@Component
@Slf4j
public class ClearPicTask {

    @Autowired
    private FastDFSClientUtil fastDFSClientUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    @XxlJob("clearPic")
    public void clearPic() {
        Set<String> pics = redisTemplate.opsForSet()
                .difference(RedisKeyConstants.ALL_PIC, RedisKeyConstants.USE_PIC);
        System.out.println("定时任务开始执行，需要清理的图片有："+pics);
        for (String pic : pics) {
            fastDFSClientUtil.delFile(pic);
        }
    }
}
