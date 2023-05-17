package com.sunny.green.service;

import com.sunny.green.dao.ExchangeDao;
import com.sunny.green.dao.UserDao;
import com.sunny.green.vo.ExchangeVo;
import com.sunny.green.vo.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Log4j2
public class ExchangeServiceImpl implements ExchangeService{
    private final ExchangeDao ed;
    private final UserDao ud;

    @Override
    public int insertExchange(ExchangeVo ev) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // 예약번호로 사용할 문자열

        int length = 8; // 예약번호의 길이
        Random random = new Random();
        StringBuilder reservationId = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            reservationId.append(chars.charAt(index));
        }

        log.info("코드 번호 :" + reservationId);
        ev.setEx_uuid_num(String.valueOf(reservationId));

        int result = ed.insertExchange(ev);
        log.info("저장됨?" + result);

        return result;
    }

    @Override
    public void updatePoint(UserVo user) {
        ud.updatePoint(user);
    }
}
