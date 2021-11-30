class Solution {
    public boolean hasAlternatingBits(int n) {
        boolean ret = false;
        // Mask : 0101010...0101
        int tmp = 1431655765;

        if (n > tmp)
            return ret;

        while (n < tmp) {
            tmp >>= 1;
        }
        return (n == tmp);
    }
}
