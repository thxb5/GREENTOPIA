package com.sunny.green.service;

import com.sunny.green.dao.BbsDao;
import com.sunny.green.vo.BbsVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BbsDao bd;
    @Override
    public int insertBoard(BbsVo bbsVo) {
        return bd.insertBoard(bbsVo);
    }

    @Override
    public int updateBoardNum() {
        return bd.updateBoardNum();
    }

    @Override
    public int updateBoard(BbsVo bbsVo) {
        return bd.updateBoard(bbsVo);
    }
}
