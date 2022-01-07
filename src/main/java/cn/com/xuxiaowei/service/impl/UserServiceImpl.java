package cn.com.xuxiaowei.service.impl;

import cn.com.xuxiaowei.bo.UserBo;
import cn.com.xuxiaowei.service.UserService;
import cn.com.xuxiaowei.vo.UserVo;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * 用户 WebService 接口
 *
 * @author 徐晓伟
 */
@Service
@WebService(targetNamespace = "http://service.xuxiaowei.com.cn")
public class UserServiceImpl implements UserService {

    /**
     * 根据 用户ID 查询用户
     *
     * @param userBo 用户ID
     * @return 返回 用户
     */
    @Override
    @WebMethod
    @WebResult(name = "response")
    public UserVo getById(@WebParam(name = "request") UserBo userBo) {
        UserVo userVo = new UserVo();

        String id = userBo.getId();

        userVo.setId(id);
        userVo.setUsername("用户-" + id);
        userVo.setPassword("用户-" + id + "-密码");
        return userVo;
    }

}
