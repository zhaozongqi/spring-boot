package com.zzq.user.controller;

import com.zzq.common.api.ApiResult;
import com.zzq.common.api.ApiCode;
import com.zzq.common.custom.BusinessException;
import io.swagger.models.auth.In;
import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zzq.user.service.UserService;
import com.zzq.user.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p> 前端控制器 </p>
 *
 * @author zzq
 * @since 2021-09-27
 */
@Api(tags = {"用户信息"})
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    /**
     * 分页查询
     *
     * @param user
     * @param size
     * @param currentPage
     * @return
     */
    @ApiOperation(value = "分页查询")
    @PostMapping("userPage")
    public ApiResult findListByPage(@RequestBody User user, Integer size, Integer currentPage) throws BusinessException {
        try {
            return ApiResult.ok(userService.findListByPage(user, size, currentPage));
        } catch (Exception e) {
           throw new BusinessException(ApiCode.FAIL);
        }
    }

    /**
     * 新增
     * @param user
     * @return
     */
    @ApiOperation(value = "新增")
    @PostMapping("add")
    public ApiResult<Integer> add(@RequestBody User user) {
        boolean flag = userService.save(user);
        return ApiResult.ok(flag ? 1 : 0);
    }

    /**
     * 删除
     * @param user
     * @return
     */
    @ApiOperation(value = "删除")
    @PostMapping("删除")
    public ApiResult<Integer> delete(Integer id) throws BusinessException {
        if(id == null){
            throw new BusinessException(ApiCode.PARAM_ERROR);
        }
        boolean flag = userService.removeById(id);
        return ApiResult.ok(flag ? 1 : 0);
    }
}
