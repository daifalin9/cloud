package cn.itcast.user.service;

import cn.itcast.user.mapper.UserMapper;
import cn.itcast.user.pojo.User;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.AllArgsConstructor;

import netscape.javascript.JSObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;

import java.util.Objects;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserMapper userMapper;

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    public User queryById(Long id) {
        User user = userMapper.selectOne(Wrappers.<User>query().lambda().eq(User::getId, id));
        if (!Objects.isNull(user)){
            log.info("查询出来的结果是:{}", JSONObject.toJSONString(user));
            return user;
        } else {
            return new User();
        }
    }
}