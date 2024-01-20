//package dev.dj;
//
//import io.quarkus.test.common.QuarkusTestResource;
//import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
//import io.quarkus.test.junit.QuarkusTest;
//
//import org.eclipse.microprofile.reactive.messaging.QuarkusMessage;
//import org.junit.jupiter.api.Test;
//
//import jakarta.inject.Inject;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@QuarkusTest
//class MyReactiveMessagingApplicationTest {
//
//    @Inject
//    KafkaApplication application;
//
//    @Test
//    void test() {
//        assertEquals("HELLO", application.toUpperCase(QuarkusMessage.of("Hello")).getPayload());
//        assertEquals("BONJOUR", application.toUpperCase(QuarkusMessage.of("bonjour")).getPayload());
//    }
//}
