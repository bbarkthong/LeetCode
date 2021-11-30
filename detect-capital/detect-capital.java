class Solution {
    public boolean detectCapitalUse(String word) {
        boolean ret = true;
        boolean tmp;
        int maxLen = word.length();
        char[] chs = word.toCharArray();

        if (maxLen > 1) {
            // 첫번째가 소문자, 두번째가 대문자인 경우 예외로 한다.
            if (!isUpper(chs[0]) && isUpper(chs[1]))
                return false;

            // 두번째 이후에는 모두 대/소문자가 공통이어야 한다.
            tmp = isUpper(chs[1]);
            for (int i = 1; i < maxLen; i++) {
                if (tmp != isUpper(chs[i])) {
                    return false;
                }
            }
        }
        return ret;
    }

    protected boolean isUpper(char ch) {
        if (ch < 'A')
            return false;
        if (ch > 'Z')
            return false;
        return true;
    }
}