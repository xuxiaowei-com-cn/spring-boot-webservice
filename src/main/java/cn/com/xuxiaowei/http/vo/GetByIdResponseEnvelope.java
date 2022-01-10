package cn.com.xuxiaowei.http.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "S:Envelope")
public class GetByIdResponseEnvelope {

    /**
     * 接收不到数据，但也无需关心
     */
    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:S")
    private String soap;

    /**
     * 必须使用：Body
     */
    @JacksonXmlProperty(localName = "Body")
    private GetByIdResponseBody body;

    @Data
    public static class GetByIdResponseBody {

        @JacksonXmlProperty(localName = "getByIdResponse")
        private GetById getById;

    }


    @Data
    public static class GetById {

        /**
         * 接收不到数据，但也无需关心
         */
        @JacksonXmlProperty(isAttribute = true, localName = "xmlns:ns2")
        private String ns2;

        private Response response;

    }

    @Data
    public static class Response {

        private String id;

        private String password;

        private String username;

    }

}
