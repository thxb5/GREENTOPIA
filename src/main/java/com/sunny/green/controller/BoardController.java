package com.sunny.green.controller;

import com.sunny.green.dao.BbsDao;
import com.sunny.green.dao.CommentDao;
import com.sunny.green.dao.UserDao;
import com.sunny.green.service.BoardService;
import com.sunny.green.vo.BbsVo;
import com.sunny.green.vo.CommentVo;
import com.sunny.green.vo.PageVo;
import com.sunny.green.vo.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class BoardController {

    private final BbsDao bd;
    private final CommentDao cd;
    private final BoardService bs;

    // 목록
    @GetMapping("/board")
    public String getBbsList(Model model, PageVo search, @RequestParam(required = false) String searchType, @RequestParam(required = false) String searchValue) throws Exception {
        List<BbsVo> bbs;
        if (searchType == null || searchValue == null) {
            bbs = bd.selectBoardAll();
            log.info(bbs);
        } else {
            bbs = bd.searchBoard(search, searchType, searchValue);
            log.info(bbs);
        }
        model.addAttribute("bbs", bbs);
        return "bbs/boardList";
    }
    // 페이징 & 검색
    @PostMapping("/pagination_board")
    @ResponseBody
    public List<BbsVo> getBbsInfo(PageVo search, @RequestParam(required = false) String searchType, @RequestParam(required = false) String searchValue) {
        List<BbsVo> bbs;
        if (searchType == null || searchValue == null) {
            bbs = bd.selectAllBoard();
            log.info(bbs);

        } else {
            bbs = bd.searchBoard(search, searchType, searchValue);
            log.info(bbs);

        }
        return bbs;
    }
    // Q&A 글작성 폼
    @GetMapping("/boardPost")
    public String boardPost(UserVo user, HttpSession session, Model model) {
        UserVo userVo = (UserVo) session.getAttribute("user");
        model.addAttribute("user", userVo);
        if(userVo == null){
            model.addAttribute("alert","로그인이 필요한 페이지입니다.");
            model.addAttribute("url","/login");
        }
        else{
            return "bbs/boardPost";
        }
        log.info("밸류값" + userVo);
        return "alert";
    }

    // Q&A 글작성
    @PostMapping("/boardPost")
    public String boardPost1(@ModelAttribute BbsVo bbsVo) {
        int insertResult = bs.insertBoard(bbsVo);
        bs.updateBoardNum();
        if (insertResult > 0) {           // 성공으로 판단되면 목록으로 돌아가기.
            return "redirect:board/";
        } else {                          // 실패하면 글작성 페이지에 머무름.
            return "bbs/boardPost";
        }
    }

    // Q&A 글 상세조회
    @GetMapping("/boardDetail")
    public String boardDetail(Model model, CommentVo commentVo, BbsVo bbsVo, HttpSession session, int board_num) {
        BbsVo bbs = bd.selectBoard(board_num);
        model.addAttribute("bbs", bbs);
        log.info(bbs);
        session.getAttribute("user");
        model.addAttribute("board_num", board_num);

        // 댓글 조회
        List<CommentVo> com = cd.selectAllComment(board_num);
        log.info("com>>>>>>"+com);
        model.addAttribute("com", com);

        // 댓글 총 개수 조회
        int commentCount = cd.commentTotal(board_num);
        model.addAttribute("commentCount", commentCount);

        return "bbs/boardDetail";
    }

    // Q&A 글 수정/삭제 폼
    @GetMapping("/updateBoard1")
    public String updateBoard1(BbsVo bbsVo, Model model, int board_num, HttpSession session1) {
        BbsVo bbs = bd.selectBoard(bbsVo.getBoard_num());
        model.addAttribute("bbs", bbs);
            return "bbs/boardUpdate";
    }

    // Q&A 글 수정
    @PostMapping("/updateBoard2")
    public String updateBoard2(BbsVo bbsVo, Model model) {
        log.info("보드값" + bbsVo.getBoard_num() );
        BbsVo bbs = bd.selectBoard(bbsVo.getBoard_num());
        log.info(bbs);
        int str = bs.updateBoard(bbsVo);
        log.info("업데이트 :" + str);
        return "redirect:board";
    }

    // Q&A 글 삭제
    @GetMapping("/deleteBoard")
    public String deleteBoard(int board_num) {
        // 해당 게시글에 속한 댓글 삭제
        cd.deleteCommentByBoardNum(board_num);

        // 게시글 삭제
        bd.deleteBoard(board_num);
        bd.updateBoardNum();

        return "redirect:board";
    }









}