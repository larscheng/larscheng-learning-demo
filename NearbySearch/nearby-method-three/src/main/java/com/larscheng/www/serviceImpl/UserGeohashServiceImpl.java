package com.larscheng.www.serviceImpl;

import com.larscheng.www.domain.UserGeohash;
import com.larscheng.www.dao.UserGeohashMapper;
import com.larscheng.www.service.UserGeohashService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author larscheng
 * @since 2019-12-10
 */
@Service
public class UserGeohashServiceImpl extends ServiceImpl<UserGeohashMapper, UserGeohash> implements UserGeohashService {

}
