package com.spring.rest.seed.api.rest.service.impl;

import com.spring.rest.seed.api.rest.dao.UserDAO;
import com.spring.rest.seed.api.rest.entity.User;
import com.spring.rest.seed.api.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by emrahsoytekin on 22.10.2017.
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void saveUser(User user) {
        userDAO.save (user);
    }
}
