import java.math.BigInteger;

class Solution {
    public boolean divby13(String s) {
        BigInteger num = new BigInteger(s);
        BigInteger thirteen = BigInteger.valueOf(13);
        return num.mod(thirteen).equals(BigInteger.ZERO);
    }
}
