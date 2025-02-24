package pl.sda.ro76.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Message {

    @NotNull(message = "from field is mandatory")
    private String from;

    @NotNull(message = "to field is mandatory")
    private String to;

    @NotNull
    @Size(min = 5, message="Size of message must have at least 5 chars")
    private String message;

    public Message() {}

    public Message(String from, String to, String message) {
        this.from = from;
        this.to = to;
        this.message = message;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
