package cn.com.xuxiaowei.http.vo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class GetByIdResponseEnvelopeTests {

    @Test
    void xml() throws JsonProcessingException {

        GetByIdResponseEnvelope.Response response = new GetByIdResponseEnvelope.Response();

        GetByIdResponseEnvelope.GetById getById = new GetByIdResponseEnvelope.GetById();
        getById.setResponse(response);

        GetByIdResponseEnvelope.GetByIdResponseBody getByIdResponseBody =
                new GetByIdResponseEnvelope.GetByIdResponseBody();
        getByIdResponseBody.setGetById(getById);

        GetByIdResponseEnvelope getByIdResponseEnvelope = new GetByIdResponseEnvelope();
        getByIdResponseEnvelope.setBody(getByIdResponseBody);

        XmlMapper xmlMapper = new XmlMapper();
        ObjectWriter objectWriter = xmlMapper.writerWithDefaultPrettyPrinter();
        String xml = objectWriter.writeValueAsString(getByIdResponseEnvelope);

        log.info("\n{}", xml);
    }

}
