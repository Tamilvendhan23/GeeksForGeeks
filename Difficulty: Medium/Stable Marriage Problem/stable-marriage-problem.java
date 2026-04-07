class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        int n = men.length;
        int[] manPartner = new int[n]; // woman for each man, init -1 later
        int[] womanPartner = new int[n]; // man for each woman, init -1
        boolean[] manFree = new boolean[n];
        int[] nextProposal = new int[n];
        
        // init
        for (int i = 0; i < n; i++) {
            womanPartner[i] = -1;
            manFree[i] = true;
            nextProposal[i] = 0;
        }
        
        while (true) {
            int freeMan = -1;
            for (int i = 0; i < n; i++) {
                if (manFree[i]) {
                    freeMan = i;
                    break;
                }
            }
            if (freeMan == -1) break; // all engaged
            
            int wIndex = men[freeMan][nextProposal[freeMan]++];
            int w = wIndex;
            
            if (womanPartner[w] == -1) {
                // accept
                womanPartner[w] = freeMan;
                manPartner[freeMan] = w;
                manFree[freeMan] = false;
            } else {
                int currentM = womanPartner[w];
                if (womanBetter(women, w, freeMan, currentM)) {
                    // switch
                    womanPartner[w] = freeMan;
                    manPartner[freeMan] = w;
                    manFree[freeMan] = false;
                    manFree[currentM] = true;
                }
                // else reject, man stays free, will propose next
            }
        }
        
        return manPartner;
    }
    
    private boolean womanBetter(int[][] womenPref, int w, int m1, int m2) {
        // returns true if m1 is preferred over m2 by woman w
        for (int man : womenPref[w]) {
            if (man == m1) return true;
            if (man == m2) return false;
        }
        return false;
    }
}