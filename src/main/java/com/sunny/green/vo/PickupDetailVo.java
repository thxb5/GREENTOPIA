package com.sunny.green.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PickupDetailVo {

    //info table
    private int pu_no; // 예약번호

    private int pu_address_no; //주소번호

    private String user_id;

    private int house_no;

    private String pu_elevator;

    private String pu_day; // 예약요청날짜

    private String pu_date; // 접수날짜

    private String pu_img;

    private String pu_memo;

    private String pu_status;
    //address table

    private String pu_address_name;

    private String pu_address_tel;

    private int pu_address_zip;

    private String pu_address1;

    private String pu_address2;

    private String pu_address3;

    private String pu_address4;

    // img table

    private String pu_img_origin_name;
    private String pu_img_save_name;
    private String pu_img_path;

   // pickup house

    private String house_name;

    // category_no

    private int category_no;
    private String category_name;
    private int category_point;

    //pu_category
    private int pu_category_count;
    private int give_point;
}
