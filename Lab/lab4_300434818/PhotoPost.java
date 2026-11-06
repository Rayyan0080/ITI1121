public class PhotoPost extends Post {
    private String fileName;             // Name of the photo file
    private String caption;              // Caption for the photo

    // Constructor initializes PhotoPost with user details
    public PhotoPost(String userName, String fileName, String caption) {
        super(userName);                 // Call the constructor of the parent (Post)
        this.fileName = fileName;
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + fileName + ", " + caption; // Using super to include Post details
    }
}
