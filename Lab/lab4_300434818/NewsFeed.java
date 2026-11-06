public class NewsFeed {
    private Post[] messages;                     // Fixed-size array to store posts
    private int size;                            // Current number of posts
    public static final int MAX_SIZE = 25;       // Maximum allowed posts

    public NewsFeed() {
        messages = new Post[MAX_SIZE];
        size = 0;
    }

    public void add(Post message) {
        if (size < MAX_SIZE) {
            messages[size] = message;            // Add post to the array
            size++;
        } else {
            System.out.println("NewsFeed is full!");
        }
    }

    public Post get(int index) {
        if (index >= 0 && index < size) {
            return messages[index];
        } else {
            return null;
        }
    }

    public int size() {
        return size;
    }

    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (messages[j].compareTo(messages[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Post temp = messages[minIndex];
            messages[minIndex] = messages[i];
            messages[i] = temp;
        }
    }

    public NewsFeed getPhotoPost() {
        NewsFeed photoFeed = new NewsFeed();
        for (int i = 0; i < size; i++) {
            if (messages[i] instanceof PhotoPost) {
                photoFeed.add(messages[i]);
            }
        }
        return photoFeed;
    }

    public NewsFeed plus(NewsFeed other) {
        NewsFeed combinedFeed = new NewsFeed();
        for (int i = 0; i < this.size; i++) {
            combinedFeed.add(this.messages[i]);
        }
        for (int i = 0; i < other.size; i++) {
            combinedFeed.add(other.messages[i]);
        }
        combinedFeed.sort(); // Sort combined feed by date
        return combinedFeed;
    }
}
