package com.sunny.green.service;

import com.sunny.green.vo.ExchangeVo;
import com.sunny.green.vo.UserVo;

public interface ExchangeService {
    public int insertExchange(ExchangeVo ev);
    public void updatePoint(UserVo user);
}
