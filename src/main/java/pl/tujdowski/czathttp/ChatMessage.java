package pl.tujdowski.czathttp;

public class ChatMessage {
    private String username;
    private String value;

    public ChatMessage() {
    }

    public ChatMessage(String username, String value) {
        this.username = username;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                ", userName='" + username + '\'' +
                "value='" + value + '\'' +
                '}';
    }
}
