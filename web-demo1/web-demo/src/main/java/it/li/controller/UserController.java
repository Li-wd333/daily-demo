package it.li.controller;

import it.li.domain.entity.User;
import it.li.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 分页查询
     * @param pageNo
     * @param pageNum
     * @return
     */
    @PostMapping("/list")
    public List<User> pageList(@RequestParam Integer pageNo, @RequestParam Integer pageNum){
        return userService.pageList(pageNo, pageNum);
    }

    /**
     * 新增
     * @param user
     * @return
     */
    @PostMapping
    public Boolean save(@RequestBody User user){
        return userService.createUser(user);
    }

    /**
     * 修改
     * @param user
     * @return
     */
    @PutMapping
    public Boolean update(@RequestBody User user){
        return userService.updateById(user);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User get(@PathVariable Integer id){
        return userService.getById(id);
    }
}
