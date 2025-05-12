//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of rooms
            int m = sc.nextInt(); // Number of meetings
            int[][] meetings = new int[m][2];
            for (int i = 0; i < m; i++) {
                meetings[i][0] = sc.nextInt(); // Start time
                meetings[i][1] = sc.nextInt(); // End time
            }
            Solution ob = new Solution();
            System.out.println(ob.mostBooked(n, meetings));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends

// User function Template for Java
// import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int[] meetingCount = new int[n];
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }

        // occupiedRooms: (endTime, roomNumber)
        PriorityQueue<long[]> occupiedRooms = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return Long.compare(a[1], b[1]);
            return Long.compare(a[0], b[0]);
        });

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            // Free up rooms whose meetings have ended
            while (!occupiedRooms.isEmpty() && occupiedRooms.peek()[0] <= start) {
                availableRooms.offer((int) occupiedRooms.poll()[1]);
            }

            if (!availableRooms.isEmpty()) {
                int room = availableRooms.poll();
                meetingCount[room]++;
                occupiedRooms.offer(new long[]{end, room});
            } else {
                // Delay the meeting
                long[] next = occupiedRooms.poll();
                long newStart = next[0];
                long newEnd = newStart + (end - start);
                int room = (int) next[1];
                meetingCount[room]++;
                occupiedRooms.offer(new long[]{newEnd, room});
            }
        }

        // Find the room with the most meetings
        int maxMeetings = 0;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (meetingCount[i] > maxMeetings) {
                maxMeetings = meetingCount[i];
                answer = i;
            }
        }

        return answer;
    }
}



//{ Driver Code Starts.
// } Driver Code Ends