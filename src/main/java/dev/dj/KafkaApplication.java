package dev.dj;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.dj.model.QuarkusMessage;
import io.quarkus.runtime.StartupEvent;
import jakarta.inject.Singleton;
import org.eclipse.microprofile.reactive.messaging.*;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import java.util.stream.Stream;

@Singleton
public class KafkaApplication {

    @Inject
    @Channel("message-out")
    private Emitter<Object> emitter;


    void onStart(@Observes StartupEvent ev) {
        Stream.of(new QuarkusMessage("1","GREETING", "hi" )).forEach(obj -> emitter.send(obj));
    }

    public void sendMessage(QuarkusMessage quarkusMessage) {
        emitter.send(quarkusMessage);
    }

    @Incoming("message-in")
    @Outgoing("obj-string")
    public Message<Object> toObjString(Message<Object> message) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        return message.withPayload(om.writeValueAsString(message.getPayload()));
    }


    @Incoming("obj-string")
    public void sink(String word) {
        System.out.println(">> " + word);
    }
}
