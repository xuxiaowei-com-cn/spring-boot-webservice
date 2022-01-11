package cn.com.xuxiaowei.http11;

import cn.com.xuxiaowei.http11.bo.GetByIdRequestEnvelope;
import cn.com.xuxiaowei.http11.vo.GetByIdResponseEnvelope;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
class HttpTests {

    @Test
    void getById() throws JsonProcessingException {

        // 请求参数
        GetByIdRequestEnvelope.Request request = new GetByIdRequestEnvelope.Request();
        request.setId("xxx");

        // 在 WebService 方法名中设置参数
        GetByIdRequestEnvelope.GetById requestBodyGetById = new GetByIdRequestEnvelope.GetById();
        requestBodyGetById.setRequest(request);

        // 设置 WebService 方法名
        GetByIdRequestEnvelope.GetByIdRequestBody getByIdRequestBody = new GetByIdRequestEnvelope.GetByIdRequestBody();
        getByIdRequestBody.setGetById(requestBodyGetById);

        // 设置信封
        GetByIdRequestEnvelope requestEnvelope = new GetByIdRequestEnvelope();
        requestEnvelope.setBody(getByIdRequestBody);

        XmlMapper xmlMapper = new XmlMapper();
        ObjectWriter objectWriter = xmlMapper.writerWithDefaultPrettyPrinter();
        String envelopeXml = objectWriter.writeValueAsString(requestEnvelope);
        System.out.println("请求参数：\n" + envelopeXml);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.TEXT_XML);
        HttpEntity<String> httpEntity = new HttpEntity<>(envelopeXml, httpHeaders);

        ResponseEntity<GetByIdResponseEnvelope> responseEntity = restTemplate.postForEntity("http://127.0.0.1:8081/ws/userService",
                httpEntity, GetByIdResponseEnvelope.class);

        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        GetByIdResponseEnvelope body = responseEntity.getBody();

        log.info("HTTP 状态 HttpStatus 枚举值：{}", statusCode);
        log.info("HTTP 状态 int 值：{}", statusCodeValue);
        log.info("响应内容：{}", body);
    }

    @Test
    void getByIdResponseString() throws JsonProcessingException {

        // 请求参数
        GetByIdRequestEnvelope.Request request = new GetByIdRequestEnvelope.Request();
        request.setId("xxx");

        // 在 WebService 方法名中设置参数
        GetByIdRequestEnvelope.GetById requestBodyGetById = new GetByIdRequestEnvelope.GetById();
        requestBodyGetById.setRequest(request);

        // 设置 WebService 方法名
        GetByIdRequestEnvelope.GetByIdRequestBody getByIdRequestBody = new GetByIdRequestEnvelope.GetByIdRequestBody();
        getByIdRequestBody.setGetById(requestBodyGetById);

        // 设置信封
        GetByIdRequestEnvelope requestEnvelope = new GetByIdRequestEnvelope();
        requestEnvelope.setBody(getByIdRequestBody);

        XmlMapper xmlMapper = new XmlMapper();
        ObjectWriter objectWriter = xmlMapper.writerWithDefaultPrettyPrinter();
        String envelopeXml = objectWriter.writeValueAsString(requestEnvelope);
        System.out.println("请求参数：\n" + envelopeXml);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.TEXT_XML);
        HttpEntity<String> httpEntity = new HttpEntity<>(envelopeXml, httpHeaders);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://127.0.0.1:8081/ws/userService",
                httpEntity, String.class);

        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        String body = responseEntity.getBody();

        log.info("HTTP 状态 HttpStatus 枚举值：{}", statusCode);
        log.info("HTTP 状态 int 值：{}", statusCodeValue);
        log.info("响应内容：{}", body);
    }

}
