package com.sunny.green.service;

import com.sunny.green.vo.BbsVo;

public interface BoardService {
    public int insertBoard(BbsVo bbsVo);

    public int updateBoardNum();

    public int updateBoard(BbsVo bbsVo);
}
