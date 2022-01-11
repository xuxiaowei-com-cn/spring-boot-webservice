package cn.com.xuxiaowei.client;

import cn.com.xuxiaowei.client.bo.GetById;
import cn.com.xuxiaowei.client.vo.GetByIdResponse;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * 用户 WebService 接口-客户端-测试类
 * <p>
 * SOAP 1.1
 *
 * @author xuxiaowei
 * @see WebServiceGatewaySupport
 * @see RestTemplate
 * @since 0.0.1
 */
@Slf4j
class UserServiceSoap11ClientTests {

    @Test
    void getById() throws IOException {

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();

        SaajSoapMessageFactory saajSoapMessageFactory = new SaajSoapMessageFactory();
        saajSoapMessageFactory.setSoapVersion(SoapVersion.SOAP_11);
        saajSoapMessageFactory.afterPropertiesSet();

        webServiceTemplate.setMessageFactory(saajSoapMessageFactory);

        GetById.Request request = new GetById.Request();
        request.setId("xxw");

        GetById getById = new GetById();
        getById.setRequest(request);

        XmlMapper xmlMapper = new XmlMapper();
        ObjectWriter objectWriter = xmlMapper.writerWithDefaultPrettyPrinter();
        String getByIdXml = objectWriter.writeValueAsString(getById);
        System.out.println("请求参数：\n" + getByIdXml);

        StreamSource source = new StreamSource(new StringReader(getByIdXml));

        StringWriter stringWriter = new StringWriter();
        StreamResult result = new StreamResult(stringWriter);
        webServiceTemplate.sendSourceAndReceiveToResult("http://127.0.0.1:8081/ws/userService", source, result);

        log.info("响应内容：{}", stringWriter);

        GetByIdResponse getByIdResponse = xmlMapper.readValue(stringWriter.toString(), GetByIdResponse.class);

        log.info("响应实体类：{}", getByIdResponse);

    }

}
