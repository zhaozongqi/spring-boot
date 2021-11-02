package com.zzq.user.service;

import com.zzq.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzq.common.pagination.Paging;
import com.zzq.user.vo.UserVo;

/**
 * <p>
  *  服务类
  * </p>
 *
 * @author zzq
 * @since 2021-09-27
 */
public interface UserService extends IService<User> {

    /**
     * 查询分页数据
     * @param user
     */
    Paging<UserVo> findListByPage(User user , long size, long currentPage);


}
