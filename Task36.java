import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    // We use a Queue to store the timestamps of the requests
    private Queue<Integer> requests;

    public RecentCounter() {
        // Initialize the queue
        this.requests = new LinkedList<>();
    }
    
    public int ping(int t) {
        // 1. Add the current request timestamp to the queue
        requests.add(t);
        
        // 2. Remove timestamps that are older than t - 3000
        // Since t is strictly increasing, we only need to check the front
        while (!requests.isEmpty() && requests.peek() < t - 3000) {
            requests.poll();
        }
        
        // 3. The size of the queue represents the number of valid requests
        return requests.size();
    }
}
