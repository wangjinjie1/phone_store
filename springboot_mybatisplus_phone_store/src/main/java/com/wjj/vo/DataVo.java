package com.wjj.vo;

import lombok.Data;

import java.util.List;

@Data
public class DataVo {
  private List<PhoneCategoryVo> categoryVoList;
  private List<PhoneInfoVo> phoneInfoVoList;
}
