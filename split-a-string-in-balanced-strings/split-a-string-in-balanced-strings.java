class Solution {
    public int balancedStringSplit(String s) {
        int ret = 0;
        int cntR = 0, cntL = 0;
        String tmp = s;

        char[] chrs = s.toCharArray();
        for (char chr : chrs) {
            switch (chr) {
                case 'R':
                    cntR++;
                    break;
                case 'L':
                    cntL++;
                    break;
            }
            if ((cntL + cntR != 0) &&
                    (cntL == cntR)) {
                // Debug Output
                System.out.println(tmp.substring(0, cntL + cntR));
                tmp = tmp.substring(cntL + cntR);

                // Intialize vars.
                cntL = 0;
                cntR = 0;
                ret++;
            }
        }
        return ret;
    }
}
