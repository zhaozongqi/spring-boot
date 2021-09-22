package com.zzq.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.zzq.user.entity.User;
import com.zzq.user.mapper.UserMapper;
import com.zzq.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzq.common.pagination.Paging;

/**
 * <p>
  *  服务实现类
  * </p>
 *
 * @author zzq
 * @since 2021-09-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public IPage<User> findListByPage(User user, long size, long currentPage){
      Page<User> page = new Page<>();
      page.setCurrent(currentPage);
      page.setSize(size);

      List<OrderItem> orders = new ArrayList<>();
      OrderItem orderItem = new OrderItem();
      orderItem.setAsc(true);
      orderItem.setColumn("id");
      orders.add(orderItem);
      page.setOrders(orders);
      LambdaQueryWrapper<User> wrapper = new QueryWrapper<User>().lambda();
      IPage<User> iPage = userMapper.selectPage(page,wrapper);
      return iPage;

    }
}
