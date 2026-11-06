public class TextPost extends Post {
    private String message;              // The text message content

    // Constructor initializes TextPost with message
    public TextPost(String userName, String message) {
        super(userName);                 // Call parent constructor
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + message; // Using super to include Post details
    }

    @Override
    public boolean isPopular() {
        return getLikes() > 50; // A TextPost is popular if it has more than 50 likes
    }
}
