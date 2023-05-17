package com.sunny.green.service;

import com.sunny.green.dao.AdminDao;
import com.sunny.green.dao.UserDao;
import com.sunny.green.vo.AdminVo;
import com.sunny.green.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserDao ud;
    private final AdminDao ad;

    @Override
    public int joinUser(UserVo userVo) {
        if(ud.joinUser(userVo) !=0){
            AdminVo adminVo = new AdminVo();
            adminVo.setAdmin_id(userVo.getUser_id());
            adminVo.setAdmin_pass(userVo.getUser_pass());
            adminVo.setUser_id(userVo.getUser_id());
            adminVo.setUser_pass(userVo.getUser_pass());
            ad.insertAdmin(adminVo);
        }
        return 1;
    }

    @Override
    public UserVo selectUser(UserVo userVo) {
        return ud.selectUser(userVo);
    }

    @Override
    public int updateUser(UserVo user) {
        return ud.updateUser(user);
    }


}
