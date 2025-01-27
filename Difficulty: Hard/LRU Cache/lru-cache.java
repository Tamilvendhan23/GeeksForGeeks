//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    private static List<String> inputLine(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int capacity = Integer.parseInt(sc.nextLine());
            LRUCache cache = new LRUCache(capacity);

            int queries = Integer.parseInt(sc.nextLine());
            while (queries-- > 0) {
                List<String> vec = inputLine(sc);
                if (vec.get(0).equals("PUT")) {
                    int key = Integer.parseInt(vec.get(1));
                    int value = Integer.parseInt(vec.get(2));
                    cache.put(key, value);
                } else {
                    int key = Integer.parseInt(vec.get(1));
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way
// import java.util.*;

class LRUCache {
    private final int capacity;  // Maximum capacity of the cache
    private final LinkedHashMap<Integer, Integer> cache;

    // Constructor for initializing the cache capacity
    public LRUCache(int cap) {
        this.capacity = cap;
        // Using LinkedHashMap to maintain the order of insertion/access
        this.cache = new LinkedHashMap<>(cap, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;  // Remove the least recently used item if the size exceeds capacity
            }
        };
    }

    // Function to return the value corresponding to the key
    public int get(int key) {
        return cache.getOrDefault(key, -1);  // Return value if present, otherwise return -1
    }

    // Function for storing key-value pair
    public void put(int key, int value) {
        cache.put(key, value);  // Add the key-value pair or update the existing key
    }
}
