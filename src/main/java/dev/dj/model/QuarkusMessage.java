package dev.dj.model;

public class QuarkusMessage {
    private String messageId;
    private String messageType;
    private String message;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public QuarkusMessage() {
    }

    public QuarkusMessage(String messageId, String messageType, String message) {
        this.messageId = messageId;
        this.messageType = messageType;
        this.message = message;
    }

    @Override
    public String toString() {
        return "QuarkusMessage{" +
                "messageId='" + messageId + '\'' +
                ", messageType='" + messageType + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
