package dev.dj;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.dj.model.QuarkusMessage;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

public class QuarkusMessageSerializer implements Serializer<QuarkusMessage> {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public byte[] serialize(String s, QuarkusMessage quarkusMessage) {
        String quarkusMessageString = "";
        try {
            quarkusMessageString= objectMapper.writeValueAsString(quarkusMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return quarkusMessageString.getBytes();
    }

    @Override
    public byte[] serialize(String topic, Headers headers, QuarkusMessage data) {
        return Serializer.super.serialize(topic, headers, data);
    }
}
