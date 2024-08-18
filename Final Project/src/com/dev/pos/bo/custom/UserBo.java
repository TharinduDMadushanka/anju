package com.dev.pos.bo.custom;

import com.dev.pos.bo.SuperBo;
import com.dev.pos.dto.UserDTO;

public interface UserBo extends SuperBo {

    public boolean saveUser(UserDTO userDTO) throws Exception;
    public UserDTO findUser(String email) throws Exception;

}
