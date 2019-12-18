package com.larscheng.www.dao;

import com.larscheng.www.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author larscheng
 * @since 2019-12-06
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    List<User> selectUser(@Param("minlng") double minlng, @Param("maxlng") double maxlng,
                          @Param("minlat") double minlat, @Param("maxlat") double maxlat);
}
