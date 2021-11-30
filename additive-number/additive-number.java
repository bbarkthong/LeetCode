import java.util.Stack;

class Solution {
    protected Stack<Long> seq = new Stack<Long>();

    public boolean isAdditiveNumber(String num) {
        boolean ret = false;
        // num = "121474836472147483648";
        long iTmp1, iTmp2;
        int maxLen = num.length();
        String sTmp = ""; 

        // 첫번째 인자를 구한다.
        for (int i = 1; i <= maxLen / 2; i++) {
            sTmp = num.substring(0, i);
            if (!checkDigit(sTmp))
                continue;
            iTmp1 = Long.parseLong(sTmp);
            seq.push(iTmp1);

            // 두번째 인자를 구한다.
            for (int j = i + 1; j < maxLen; j++) {
                sTmp = num.substring(i, j);
                if (!checkDigit(sTmp))
                    continue;
                iTmp2 = Long.parseLong(sTmp);
                seq.push(iTmp2);

                // 첫번째 인자와 두번째 인자의 합을 체크한다.
                ret = checkAdd(iTmp1, iTmp2, num.substring(j, maxLen));
                if (ret)
                    break;
                seq.pop();
            }
            if (ret)
                break;
            seq.pop();
        }
        return ret;
    }

    /*
     * 합을 체크한다.(재귀)
     */
    protected boolean checkAdd(long iNum1, long iNum2, String num) {
        boolean ret = false;

        long iTmp;
        int maxLen = num.length();
        String sTmp = "";

        // System.out.println(num);
        if (maxLen == 0) {
            printStack();
            return true;
            // return false;
        }
        for (int i = 1; i <= maxLen; i++) {
            sTmp = num.substring(0, i);
            if (!checkDigit(sTmp))
                continue;
            iTmp = Long.parseLong(sTmp);
            // System.out.println(iNum1 + "+" + iNum2 + "=" + iTmp);
            if (iTmp == iNum1 + iNum2) {
                // System.out.println(iNum1 + "+" + iNum2 + "=" + num);
                seq.push(iTmp);
                ret = checkAdd(iNum2, iTmp, num.substring(i, maxLen));
                seq.pop();
            }

        }
        return ret;
    }

    /*
     * 숫자를 체크한다.
     */
    protected boolean checkDigit(String num) {
        // 01을 1로 파싱하여 예외처리
        if (num.substring(0, 1).equals("0") && num.length() > 1) {
            return false;
        }
        // Int형 Overflow 예외처리
        if (String.valueOf(Long.MAX_VALUE).length() < num.length()) {
            return false;
        }
        return true;
    }

    /*
     * 스택을 화면에 출력한다.
     */
    protected void printStack() {
        Stack<Integer> tmp = (Stack<Integer>) seq.clone();
        String log = "";
        while (!tmp.isEmpty()) {
            log = "," + tmp.pop() + log;
        }
        if (log.length() >= 1) {
            System.out.println(log.substring(1));
        }
    }
}