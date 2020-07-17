package com.wjj.Util;

import com.wjj.vo.ResultVo;

public class ResultVoUtil {
    public static ResultVo success(Object data){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(data);
        return resultVo;
    }
    public static ResultVo fault(String msg){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(1);
        resultVo.setMsg(msg);
        resultVo.setData(null);
        return  resultVo;
    }
}
