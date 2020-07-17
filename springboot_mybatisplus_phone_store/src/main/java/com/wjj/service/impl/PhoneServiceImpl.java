package com.wjj.service.impl;

import com.wjj.Util.PhoneUtil;
import com.wjj.entity.PhoneCategory;
import com.wjj.entity.PhoneInfo;
import com.wjj.entity.PhoneSpecs;
import com.wjj.enums.ResultEnum;
import com.wjj.exception.PhoneException;
import com.wjj.mapper.PhoneCategoryMapper;
import com.wjj.mapper.PhoneInfoMapper;
import com.wjj.mapper.PhoneSpecMapper;
import com.wjj.service.PhoneService;
import com.wjj.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
@Slf4j
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneCategoryMapper phoneCategoryMapper;

    @Autowired
    private PhoneInfoMapper phoneInfoMapper;

    @Autowired
    private PhoneSpecMapper phoneSpecMapper;
    @Override
    public DataVo findDateVo() {
        DataVo dataVo = new DataVo();
        // 从数据库中拿到 手机类型 进行封装
        List<PhoneCategory> phoneCategories = phoneCategoryMapper.selectList(null);

        // 常规操作
//        List<PhoneCategoryVo> phoneCategoryVoList = new ArrayList<>();
//        for (PhoneCategory p: phoneCategories
//             ) {
//            PhoneCategoryVo phoneCategoryVo = new PhoneCategoryVo();
//            phoneCategoryVo.setCategoryName(p.getCategoryName());
//            phoneCategoryVo.setCategoryType(p.getCategoryType());
//            phoneCategoryVoList.add(phoneCategoryVo);
//        }
        // stream 流操作集合 封装 手机 类型
        List<PhoneCategoryVo> collect = phoneCategories.stream()
                .map((e) -> {
                    return new PhoneCategoryVo(e.getCategoryName(), e.getCategoryType());
                })
                .collect(Collectors.toList());

        dataVo.setCategoryVoList(collect);

        // stream 流操作集合 封装 手机 信息
        // 从数据库中拿到 手机信息 进行封装

        Map<String, Object> select = new HashMap<>();
        // 只能从 phoneCategories 表取出第一行数据中的 CategoryType 即 CategoryType=1
        select.put("category_type",phoneCategories.get(0).getCategoryType());
        List<PhoneInfo> phoneInfos = phoneInfoMapper.selectByMap(select);

//        List<PhoneInfoVo> phoneInfoVoList = new ArrayList<>();
//        for (PhoneInfo p: phoneInfos
//             ) {
//            PhoneInfoVo phoneInfoVo = new PhoneInfoVo();
//            // 会将 属性名相同的 数据进行 copy
//            BeanUtils.copyProperties(p,phoneInfoVo);
//            phoneInfoVo.setTag(PhoneUtil.createTag(p.getPhoneTag()));
//            phoneInfoVoList.add(phoneInfoVo);
//        }
//        dataVo.setPhoneInfoVoList(phoneInfoVoList);


        // stream 流操作
        List<PhoneInfoVo> phoneInfoVoList = phoneInfos.stream()
                .map((phoneInfo)->new PhoneInfoVo(
                        phoneInfo.getPhoneId(),
                        phoneInfo.getPhoneName(),
                        phoneInfo.getPhonePrice(),
                        phoneInfo.getPhoneDescription(),
                        phoneInfo.getPhoneIcon(),
                        PhoneUtil.createTag(phoneInfo.getPhoneTag())
                )).collect(Collectors.toList());
        dataVo.setPhoneInfoVoList(phoneInfoVoList);
        return dataVo;
    }

    @Override
    public List<PhoneInfoVo> findPhoneInfoVoByCategoryType(Integer categoryType) {

        Map<String, Object> map = new HashMap<>();
        map.put("category_type",categoryType);
        List<PhoneInfo> phoneInfoList = phoneInfoMapper.selectByMap(map);

        List<PhoneInfoVo> phoneInfoVoList = phoneInfoList.stream()
                .map((phoneInfo)->new PhoneInfoVo(
                        phoneInfo.getPhoneId(),
                        phoneInfo.getPhoneName(),
                        phoneInfo.getPhonePrice(),
                        phoneInfo.getPhoneDescription(),
                        phoneInfo.getPhoneIcon(),
                        PhoneUtil.createTag(phoneInfo.getPhoneTag())
                )).collect(Collectors.toList());
        return phoneInfoVoList;
    }

    @Override
    public SpecsPackageVo findSpecsByPhoneId(Integer phoneId) {
        PhoneInfo phoneInfo = phoneInfoMapper.selectById(phoneId);

        Map<String, Object> map = new HashMap<>();
        map.put("phone_id",phoneId);
        List<PhoneSpecs> phoneSpecsList = phoneSpecMapper.selectByMap(map);

        // tree
        List<PhoneSpecsVo> phoneSpecsVoList = new ArrayList<>();
        List<PhoneSpecsCasVo> phoneSpecsCasVoList = new ArrayList<>();

        // 在循环外定义对象，节省空间
        PhoneSpecsVo phoneSpecsVo;
        PhoneSpecsCasVo phoneSpecsCasVo;
        for (PhoneSpecs phoneSpecs: phoneSpecsList
             ) {
            phoneSpecsVo = new PhoneSpecsVo();
            phoneSpecsCasVo = new PhoneSpecsCasVo();
            BeanUtils.copyProperties(phoneSpecs,phoneSpecsVo);
            BeanUtils.copyProperties(phoneSpecs,phoneSpecsCasVo);
            phoneSpecsVoList.add(phoneSpecsVo);
            phoneSpecsCasVoList.add(phoneSpecsCasVo);
        }
        TreeVo treeVo = new TreeVo();
        treeVo.setV(phoneSpecsVoList);
        List<TreeVo> treeVos = new ArrayList<>();
        treeVos.add(treeVo);

        SkuVo skuVo = new SkuVo();
        Integer price = phoneInfo.getPhonePrice().intValue();
        skuVo.setPrice(price+".00");
        skuVo.setStock_num(phoneInfo.getPhoneStock());
        skuVo.setTree(treeVos);
        skuVo.setList(phoneSpecsCasVoList);

        SpecsPackageVo specsPackageVo = new SpecsPackageVo();
        Map<String, String> goods = new HashMap<>();
        goods.put("picture",phoneInfo.getPhoneIcon());
        specsPackageVo.setGoods(goods);
        specsPackageVo.setSku(skuVo);
        return specsPackageVo;
    }

    @Override
    public void subStock(Integer specsId, Integer quantity) {
        PhoneSpecs phoneSpecs = phoneSpecMapper.selectById(specsId);
        PhoneInfo phoneInfo = phoneInfoMapper.selectById(phoneSpecs.getPhoneId());
        Integer result = phoneSpecs.getSpecsStock() - quantity;
        if (result < 0){
            log.error("库存不足");
            throw new PhoneException(ResultEnum.PHONE_STOCK_ERROR);
        }

        phoneSpecs.setSpecsStock(result);
        phoneSpecMapper.updateById(phoneSpecs);

        result = phoneInfo.getPhoneStock() - quantity;
        if (result < 0){
            log.error("库存不足");
            throw new PhoneException(ResultEnum.PHONE_STOCK_ERROR);
        }

        phoneInfo.setPhoneStock(result);
        phoneInfoMapper.updateById(phoneInfo);

    }
}
