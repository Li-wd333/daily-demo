package it.li.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import it.li.domain.entity.User;
import it.li.exception.CreateUserException;
import it.li.mapper.UserMapper;
import it.li.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<User> pageList(Integer pageNo, Integer pageNum) {
        log.info("pageNo: {}, pageNum: {}", pageNo, pageNum);
        //分页
        Page<User> page = new Page<>(pageNo, pageNum);
        //排序
        page.addOrder(OrderItem.asc("id"));
        //查询
        Page<User> userPage = page(page); // 分页查询
        List<User> list = userPage.getRecords(); // 获取结果
        log.info("list: {}", list);
        log.info("total: {}", userPage.getTotal());
        log.info("pages: {}", userPage.getPages());
        log.info("current: {}", userPage.getCurrent());
        return list;
    }

    @Override
    public Boolean createUser(User user) {
        //1. 验证用户名
        if (user.getUsername().length() < 5) {
            throw new CreateUserException("用户名长度不能小于5");
        }
        //2. 验证密码
        if (user.getPassword().length() < 5) {
            throw new CreateUserException("密码长度不能小于5");
        }
        //1.查询数据库中是否存在
        User user1 = getOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        if (user1 != null) {
            throw new CreateUserException("用户已存在");
        }
        return save(user);
    }
}
