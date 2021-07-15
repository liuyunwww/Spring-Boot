package com.jtxy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jtxy.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ysj
 * @date 2021/6/28 16:35
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据手机号查询用户
     * @param mobile
     * @return
     */
    User selectByUserMobile(@Param("mobile") String mobile);
}
