package com.dev.pos.bo.impl;

import com.dev.pos.Enum.DaoType;
import com.dev.pos.bo.custom.UserBo;
import com.dev.pos.dao.DaoFactory;
import com.dev.pos.dao.custom.UserDao;
import com.dev.pos.dao.impl.UserDaoImpl;
import com.dev.pos.dto.UserDTO;
import com.dev.pos.entity.User;

public class UserBoImpl implements UserBo {

    UserDao userDao = (UserDao) DaoFactory.getInstance().getDao(DaoType.USER);

    @Override
    public boolean saveUser(UserDTO userDTO) throws Exception {
        return userDao.save(new User(
                userDTO.getEmail(),
                userDTO.getPassword()
        ));
    }

    @Override
    public UserDTO findUser(String email) throws Exception {
        User user = userDao.find(email);
        if (user != null) {
            return new UserDTO(
                    user.getEmail(),
                    user.getPassword()
            );
        }
        return null;
    }
}
