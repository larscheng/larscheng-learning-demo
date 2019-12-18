package com.larscheng.www.serviceImpl;

import com.larscheng.www.domain.User;
import com.larscheng.www.dao.UserMapper;
import com.larscheng.www.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author larscheng
 * @since 2019-12-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
