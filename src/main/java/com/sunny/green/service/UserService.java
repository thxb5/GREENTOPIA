package com.sunny.green.service;

import com.sunny.green.dao.UserDao;
import com.sunny.green.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface UserService {

    public int joinUser(UserVo userVo);

    public UserVo selectUser(UserVo userVo);

    public int updateUser(UserVo user);
}
