package cn.com.xuxiaowei.http.bo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class GetByIdRequestEnvelopeTests {

    @Test
    void xml() throws JsonProcessingException {

        GetByIdRequestEnvelope.Request request = new GetByIdRequestEnvelope.Request();
        request.setId("xxw");

        GetByIdRequestEnvelope.GetById getById = new GetByIdRequestEnvelope.GetById();
        getById.setRequest(request);

        GetByIdRequestEnvelope.GetByIdRequestBody getByIdRequestBody = new GetByIdRequestEnvelope.GetByIdRequestBody();
        getByIdRequestBody.setGetById(getById);

        GetByIdRequestEnvelope getByIdRequestEnvelope = new GetByIdRequestEnvelope();
        getByIdRequestEnvelope.setBody(getByIdRequestBody);

        XmlMapper xmlMapper = new XmlMapper();
        ObjectWriter objectWriter = xmlMapper.writerWithDefaultPrettyPrinter();
        String xml = objectWriter.writeValueAsString(getByIdRequestEnvelope);

        log.info("\n{}", xml);
    }

}
