package com.wjj.exception;

import com.wjj.enums.ResultEnum;

public class PhoneException extends RuntimeException{
    public PhoneException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
    }

    public PhoneException(String s) {
        super(s);
    }
}
