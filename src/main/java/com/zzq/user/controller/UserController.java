package com.zzq.user.controller;

import com.zzq.common.api.ApiResult;
import com.zzq.common.api.ApiCode;
import org.springframework.web.bind.annotation.*;
import com.zzq.user.service.UserService;
import com.zzq.user.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
  *  前端控制器
  * </p>
 *
 * @author zzq
 * @since 2021-09-27
 */
@Api(tags = {"用户信息"})
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger log = LoggerFactory.getLogger(getClass());
    @Resource
    private UserService userService;

    @ApiOperation(value = "查询分页数据")
    @PostMapping("userPage")
    public ApiResult findListByPage(@RequestBody User user, Integer size, Integer currentPage){
        try {
            return ApiResult.ok(userService.findListByPage(user,size,currentPage));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ApiResult.fail(ApiCode.FAIL);
        }
    }
}
