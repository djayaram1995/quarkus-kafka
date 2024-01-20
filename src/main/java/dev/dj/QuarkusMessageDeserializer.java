package dev.dj;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.dj.model.QuarkusMessage;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.io.IOException;

public class QuarkusMessageDeserializer implements Deserializer<QuarkusMessage> {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public QuarkusMessage deserialize(String s, byte[] bytes) {
        try {
            return objectMapper.readValue(bytes, QuarkusMessage.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public QuarkusMessage deserialize(String topic, Headers headers, byte[] data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }
}
