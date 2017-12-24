package com.rock.service;

import com.rock.model.User;

import java.util.List;

/**
 * Created by Administrator on 2016/11/26 0026.
 */
public interface UserService {

    List<User> getAllUser();

    User getUserByPhoneOrEmail(String emailOrPhone, Short state);

    User getUserById(Long userId);
}
