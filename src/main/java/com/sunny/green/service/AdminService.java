package com.sunny.green.service;

import com.sunny.green.vo.AdminVo;
import com.sunny.green.vo.ProductVo;
import com.sunny.green.vo.UserVo;

public interface AdminService {

    public AdminVo selectAdmin(AdminVo av);

    public int updateUser(UserVo user);

    public int updatePro(ProductVo productVo);
}
