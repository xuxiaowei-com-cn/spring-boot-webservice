package cn.com.xuxiaowei.cxf.client.utils;

import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * CXF 客户端 工具类
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
public class CxfClientUtils {

    /**
     * 创建 CXF 客户端
     *
     * @param address      地址
     * @param serviceClass （WebService响应结果）服务接口
     * @param <T>          泛型
     * @return 返回 （WebService响应结果）服务接口
     */
    public static <T> T create(String address, Class<T> serviceClass) {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();

        jaxWsProxyFactoryBean.getInInterceptors().add(new LoggingInInterceptor());
        jaxWsProxyFactoryBean.getOutInterceptors().add(new LoggingOutInterceptor());

        jaxWsProxyFactoryBean.setAddress(address);
        jaxWsProxyFactoryBean.setServiceClass(serviceClass);
        @SuppressWarnings("all")
        T service = (T) jaxWsProxyFactoryBean.create();
        return service;
    }

}
