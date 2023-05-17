package com.sunny.green.service;

import com.sunny.green.dao.NoticeDao;
import com.sunny.green.vo.NoticeVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class NoticeServiceImpl implements NoticeService{
    private final NoticeDao nd;
    @Override
    public int insertNotice(NoticeVo noticeVo) {
        return nd.insertNotice(noticeVo);
    }

    @Override
    public int updateNoticeNum() {
        return nd.updateNoticeNum();
    }

    @Override
    public int updateNotice(NoticeVo noticeVo) {
        return nd.updateNotice(noticeVo);
    }
}
