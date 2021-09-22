package com.zzq.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzq.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzq.common.pagination.Paging;

/**
 * <p>
  *  服务类
  * </p>
 *
 * @author zzq
 * @since 2021-09-22
 */
public interface UserService extends IService<User> {

    /**
     * 查询分页数据
     * @param user
     */
    IPage<User> findListByPage(User user ,long size, long currentPage);


}
