package dev.dubhe.fantasyskinserver.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dev.dubhe.fantasyskinserver.dao.IUserDao;
import dev.dubhe.fantasyskinserver.mapper.UserMapper;
import dev.dubhe.fantasyskinserver.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl extends ServiceImpl<UserMapper, User> implements IUserDao {
}
