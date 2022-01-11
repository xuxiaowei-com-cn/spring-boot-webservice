package cn.com.xuxiaowei.cxf.client.service;

import cn.com.xuxiaowei.cxf.client.bo.UserBo;
import cn.com.xuxiaowei.cxf.client.vo.UserVo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * 用户 WebService 接口-客户端
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@WebService(targetNamespace = "http://service.xuxiaowei.com.cn")
public interface UserServiceClient {

    /**
     * 根据 用户ID 查询用户
     *
     * @param userBo 用户ID
     * @return 返回 用户
     */
    @WebMethod
    @WebResult(name = "response")
    UserVo getById(@WebParam(name = "request") UserBo userBo);

}
