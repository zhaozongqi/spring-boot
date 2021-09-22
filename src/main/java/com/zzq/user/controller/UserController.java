package com.zzq.user.controller;

import com.zzq.common.api.ApiResult;
import com.zzq.common.api.ApiCode;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @since 2021-09-22
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户api", tags = {"用户相关接口"})
public class UserController {

    private Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询分页数据")
    @PostMapping("userPage")
    public ApiResult findListByPage(@RequestBody User user,
                                   @RequestParam Integer size,
                                   @RequestParam Integer currentPage){
        try {
            return ApiResult.ok(userService.findListByPage(user,size,currentPage));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ApiResult.fail(ApiCode.FAIL);
        }
    }

    @ApiOperation(value = "新增数据")
    @PostMapping("add")
    public ApiResult add(@RequestBody User user){
        try {
            return ApiResult.ok(userService.save(user));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ApiResult.fail(ApiCode.FAIL);
        }
    }

    @ApiOperation(value = "删除数据")
    @DeleteMapping("{id}")
    public ApiResult delete(@RequestParam("id") Long id){
        try {
            return ApiResult.ok(userService.removeById(id));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ApiResult.fail(ApiCode.FAIL);
        }
    }

    @ApiOperation(value = "更新数据")
    @PutMapping("update")
    public ApiResult update(@RequestBody User user){
        try {
            return ApiResult.ok(userService.updateById(user));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ApiResult.fail(ApiCode.FAIL);
        }
    }
}
