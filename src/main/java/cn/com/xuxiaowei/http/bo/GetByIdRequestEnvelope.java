package cn.com.xuxiaowei.http.bo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "soapenv:Envelope")
public class GetByIdRequestEnvelope {

    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:soapenv")
    private String soapenv = "http://www.w3.org/2003/05/soap-envelope";

    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:ser")
    private String ser = "http://service.xuxiaowei.com.cn";

    @JacksonXmlProperty(localName = "soapenv:Header")
    private String header;

    @JacksonXmlProperty(localName = "soapenv:Body")
    private GetByIdRequestBody body;

    @Data
    public static class GetByIdRequestBody {

        @JacksonXmlProperty(localName = "ser:getById")
        private GetById getById;

    }

    @Data
    public static class GetById {

        private Request request;

    }

    @Data
    public static class Request {

        private String id;

    }

}
