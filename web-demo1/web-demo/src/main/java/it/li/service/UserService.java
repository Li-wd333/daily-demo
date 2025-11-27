package it.li.service;

import com.baomidou.mybatisplus.extension.service.IService;
import it.li.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends IService<User> {
    /**
     * 分页查询
     * @param pageNo
     * @param pageNum
     * @return
     */
    List<User> pageList(Integer pageNo, Integer pageNum);

    /**
     * 新增
     * @param user
     * @return
     */
    Boolean createUser(User user);
}
