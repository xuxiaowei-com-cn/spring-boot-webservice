package cn.com.xuxiaowei.service;

import cn.com.xuxiaowei.bo.UserBo;
import cn.com.xuxiaowei.vo.UserVo;

/**
 * 用户 WebService 接口
 *
 * @author 徐晓伟
 */
public interface UserService {

    /**
     * 根据 用户ID 查询用户
     *
     * @param userBo 用户ID
     * @return 返回 用户
     */
    UserVo getById(UserBo userBo);

}
