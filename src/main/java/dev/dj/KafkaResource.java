package dev.dj;

import dev.dj.model.QuarkusMessage;
import io.smallrye.mutiny.Multi;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;

@Path("/kafka")
public class KafkaResource {

    @Inject
    private KafkaApplication kafkaApplication;

    @Channel("message-in")
    private Multi<QuarkusMessage> messageIn;

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<QuarkusMessage> kafkaOut() {
        return messageIn.log().map(val -> {
            System.out.println(val);
            return val;
        });
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public QuarkusMessage kafkaIn(QuarkusMessage quarkusMessage) {
        kafkaApplication.sendMessage(quarkusMessage);
        return quarkusMessage;
    }
}
