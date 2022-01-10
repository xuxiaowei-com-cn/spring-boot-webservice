package cn.com.xuxiaowei.client.bo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "soap:getById")
public class GetById {

    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:soap")
    private String soap = "http://service.xuxiaowei.com.cn";

    private Request request;

    @Data
    public static class Request {

        private String id;

    }

}
