package com.zzq.common.custom;


import com.zzq.common.api.ApiCode;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by zhaozongqi on 2019/12/8
 */
@Data
@AllArgsConstructor
public class BusinessException extends Exception {

    private ApiCode apiCode;
}
