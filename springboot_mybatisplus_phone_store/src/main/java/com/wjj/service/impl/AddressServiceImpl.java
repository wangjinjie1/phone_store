package com.wjj.service.impl;

import com.wjj.entity.BuyerAddress;
import com.wjj.form.AddressForm;
import com.wjj.mapper.BuyerAddressMapper;
import com.wjj.service.AddressService;
import com.wjj.vo.AddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private BuyerAddressMapper buyerAddressMapper;

    @Override
    public List<AddressVo> findAll() {
        List<BuyerAddress> buyerAddressList = buyerAddressMapper.selectList(null);

        List<AddressVo> addressVoList = buyerAddressList
                .stream().map((e)->{return new AddressVo(
                        e.getAddressId(),
                        e.getAreaCode(),
                        e.getBuyerName(),
                        e.getBuyerPhone(),
                        e.getBuyerAddress()
                );})
                .collect(Collectors.toList());

        return addressVoList;
    }

    @Override
    public void saveOrUpdate(AddressForm addressForm) {
        BuyerAddress buyerAddress;
        if (addressForm.getId()==null){
            buyerAddress = new BuyerAddress();
        }else {
            buyerAddress = buyerAddressMapper.selectById(addressForm.getId());
        }
        buyerAddress.setBuyerName(addressForm.getName());
        buyerAddress.setAreaCode(addressForm.getAreaCode());
        buyerAddress.setBuyerPhone(addressForm.getTel());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(addressForm.getProvince())
                .append(addressForm.getCity())
                .append(addressForm.getCounty())
                .append(addressForm.getAddressDetail());
        buyerAddress.setBuyerAddress(stringBuffer.toString());

        if (buyerAddress.getAddressId()==null){
            buyerAddressMapper.insert(buyerAddress);
        }else {
            buyerAddressMapper.updateById(buyerAddress);
        }

    }
}
