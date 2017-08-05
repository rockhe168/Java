package com.rock.service.impl;

import com.rock.dao.UserDao;
import com.rock.java8.model.User;
import com.rock.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/11/26 0026.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }

    public User getUserByPhoneOrEmail(String emailOrPhone, Short state) {
        return userDao.selectUserByPhoneOrEmail(emailOrPhone,state);
    }

    public User getUserById(Long userId) {
        return userDao.selectUserById(userId);
    }
}
