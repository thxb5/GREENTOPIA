package com.sunny.green.service;

import com.sunny.green.vo.NoticeVo;

public interface NoticeService {
    public int insertNotice(NoticeVo noticeVo);

    public int updateNoticeNum();

    public int updateNotice(NoticeVo noticeVo);
}
