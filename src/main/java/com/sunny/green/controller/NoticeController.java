package com.sunny.green.controller;

import com.sunny.green.dao.NoticeDao;
import com.sunny.green.service.NoticeService;
import com.sunny.green.vo.NoticeVo;
import com.sunny.green.vo.PageVo;
import com.sunny.green.vo.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class NoticeController {

    private final NoticeDao nd;
    private final NoticeService ns;

    // 공지사항 목록
    @GetMapping("/notice")
    public String getNoticeList(Model model, PageVo search , @RequestParam(required = false) String searchType , @RequestParam(required = false) String searchValue) throws Exception {
        List<NoticeVo> notice;
        if (searchType == null || searchValue == null) {
            notice = nd.selectAllNotice();
            log.info(notice);
        } else {
            notice = nd.searchNotice(search, searchType, searchValue);
            log.info(notice);
        }
        model.addAttribute("notice", notice);
        return "bbs/noticeList";
    }

    //페이징 및 검색
    @PostMapping("/pagination_notice")
    @ResponseBody
    public List<NoticeVo> getNoticeInfo(PageVo search, @RequestParam(required = false) String searchType, @RequestParam(required = false) String searchValue) {
        List<NoticeVo> notice;
        if (searchType == null || searchValue == null) {
            notice = nd.selectAllNotice();

        } else {
            notice = nd.searchNotice(search, searchType, searchValue);
            log.info(notice);
        }
        log.info(">>>>>>>>>>>>>"+notice);
        return notice;
    }
    
    // 공지사항 글작성 폼
    @GetMapping("/noticePost")
    public String noticePost(UserVo user, HttpSession session, Model model) {
        UserVo userVo = (UserVo) session.getAttribute("user");
        model.addAttribute("user", userVo);
        if(userVo == null){
            model.addAttribute("alert","로그인이 필요한 페이지입니다.");
            model.addAttribute("url","/login");
        }
        else{
            return "bbs/noticePost";
        }
        log.info("밸류값" + userVo);
        return "alert";
    }

    // 공지사항 글작성
    @PostMapping("/noticePost")
    public String noticePost(@ModelAttribute NoticeVo noticeVo) {
        int insertResult = ns.insertNotice(noticeVo);
        ns.updateNoticeNum();
        if (insertResult > 0) {           // 성공으로 판단되면 목록으로 돌아가기.
            return "redirect:notice/";
        } else {                          // 실패하면 글작성 페이지에 머무름.
            return "bbs/noticePost";
        }
    }

    // 공지사항 상세조회
    @GetMapping("/noticeDetail")
    public String noticeDetail(Model model, NoticeVo noticeVo, HttpSession session, int notice_num) {
        NoticeVo notice = nd.selectNotice(notice_num);
        model.addAttribute("notice", notice);
        log.info(notice);
        session.getAttribute("user");
        model.addAttribute("notice_num", notice_num);

        return "bbs/noticeDetail";
    }


    // 공지사항 글 수정/삭제 폼
    @GetMapping("/updateNotice1")
    public String updateNotice1(NoticeVo noticeVo, Model model, int notice_num) {
        NoticeVo notice = nd.selectNotice(noticeVo.getNotice_num());
        model.addAttribute("notice", notice);
        return "bbs/noticeUpdate";
    }

    // 공지사항 글 수정
    @PostMapping("/updateNotice2")
    public String updateNotice2(NoticeVo noticeVo) {
        log.info("공지사항값" + noticeVo.getNotice_num() );
        NoticeVo notice = nd.selectNotice(noticeVo.getNotice_num());
        log.info(notice);
        int str = ns.updateNotice(noticeVo);
        log.info("업데이트 :" + str);
        return "redirect:notice";
    }

    // 공지사항 글 삭제
    @GetMapping("/deleteNotice")
    public String deleteNotice(int notice_num) {
        int str = nd.deleteNotice(notice_num);
        int str1 = nd.updateNoticeNum();
        return "redirect:notice";
    }
}
