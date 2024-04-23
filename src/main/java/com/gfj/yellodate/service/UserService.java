package com.gfj.yellodate.service;

import com.gfj.yellodate.pojo.User;
import org.springframework.stereotype.Service;

public interface UserService {
    //根据用户名查询用户
    User findByUserName(String username);
    //注册用户
    void register(String username, String password);
    //更新用户信息
    void update(User user);
    //更新头像
    void updateAvatarUrl(String avatatUrl);
    //更新密码
    void updatePwd(String password);
}
