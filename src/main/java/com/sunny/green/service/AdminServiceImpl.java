package com.sunny.green.service;

import com.sunny.green.dao.AdminDao;
import com.sunny.green.dao.UserDao;
import com.sunny.green.vo.AdminVo;
import com.sunny.green.vo.ProductVo;
import com.sunny.green.vo.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class AdminServiceImpl implements AdminService{
    private final AdminDao ad;
    private final UserDao ud;

    @Override
    public AdminVo selectAdmin(AdminVo av) {
        return ad.selectAdmin(av);
    }

    @Override
    public int updateUser(UserVo user) {
        return ud.updateUser(user);
    }

    @Override
    public int updatePro(ProductVo productVo) {
        return ad.updatePro(productVo);
    }
}
