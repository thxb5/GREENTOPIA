package com.sunny.green.dao;

import com.sunny.green.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PickupDao {

    public int pickupAddressSave(PickupAddressVo pickupAddressVo);

    public int pickupInfoSave(PickupInfoVo pickupInfoVo);

    public int pickupCategorySave(PickupCategoryVo items);

    public int pickupImgSave(PickupImgVo pickupImgVo);


    // pick_up List  --- info table 간단하게 부르기
    public List<PickupDetailVo> rsList();

    // pick_up List 검색 ---- 그중에 검색
    public List<PickupDetailVo> rsList2(PageVo search, String searchType_rs, String searchValue_rs);

    // rs_info 상세정보 --- 예약자 관련 table 전체 불러옴
    public PickupDetailVo rs_info(int pu_no);

    public int pickupImgUpdate(PickupImgVo pickupImgVo);

    public PickupImgVo pickupImgView(Integer pu_no);

    public PickupDetailVo pu_information(int pu_no);

    public List<PickupDetailVo> myPageReservation(String user_id);

    public int update_info(PickupDetailVo pickupDetailVo);

    public List<PickupDetailVo> rs_service1();

    public List<PickupDetailVo> rs_service2(PageVo search, String searchType_rs, String searchValue_rs);

    public List<PickupDetailVo> rs_point1();

    public List<PickupDetailVo> rs_point2(PageVo search, String searchType_rs, String searchValue_rs);

    public PickupDetailVo selectLast(int pu_no);

    public int update_last2(PickupCategoryVo pickupCategoryVo);

    public List<PickupDetailVo> oneList1(String user_id);
}
