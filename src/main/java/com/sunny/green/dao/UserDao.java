package com.sunny.green.dao;

import com.sunny.green.vo.PageVo;
import com.sunny.green.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    public int joinUser(UserVo user);

    public UserVo selectUser(UserVo user);

    public UserVo selectUserId(String userId);

    public UserVo selectUserId2(String user_name, String user_email);

    public UserVo selectUserPass(String user_name, String user_id, String user_email);

    public UserVo selectAll1(String userId);

    public int updateUser(UserVo user);

    public int deleteId(String userId);

    public int updatePoint(UserVo vo);

    //보영
    public List<UserVo> selectAll();

    public List<UserVo> selectAll2(PageVo search, String searchType, String keyword);

    public UserVo selectEmail(String user_id);

    public int update_last1(UserVo userVO);
}
