package cn.com.xuxiaowei.configuration;

import cn.com.xuxiaowei.service.UserService;
import com.sun.xml.internal.ws.api.BindingID;
import com.sun.xml.internal.ws.transport.http.server.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * WebService 配置
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Configuration
public class WebServiceConfiguration {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public Endpoint userWebServiceEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(BindingID.SOAP11_HTTP, userService);
        // 仅监听 127.0.0.1
        // endpoint.publish("http://127.0.0.1:8081/ws/userService");
        // 监听所有地址
        endpoint.publish("http://0.0.0.0:8081/ws/userService");
        return endpoint;
    }

}
