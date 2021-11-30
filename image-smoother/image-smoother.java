class Solution {
    public int[][] imageSmoother(int[][] M) {
        int[][] ret = new int[M.length][M[0].length];
        List<Integer> colSums = new ArrayList<Integer>();

        int tmpSum = 0;
        int tmpCnt = 0;
        int tmpTotSum = 0;
        int tmpTotCnt = 0;

        for (int i = 0; i < M.length; i++) {
            // System.out.println("=======================");
            colSums.clear();
            colSums.add(0);
            colSums.add(0);

            if (M.length == 1) {
                tmpTotCnt = 2;
                tmpCnt = 1;
            } else if (i == 0 || i == M.length - 1) {
                tmpTotCnt = 4;
                tmpCnt = 2;
            } else {
                tmpTotCnt = 6;
                tmpCnt = 3;
            }
            tmpSum = getColSum(M, i, 0);
            tmpTotSum = tmpSum;
            colSums.add(tmpSum);
            /*
             * System.out.println("tmpSum(+):0");
             * System.out.println("tmpSum(+):0");
             * System.out.println("tmpSum(+):"+tmpSum);
             */

            for (int j = 0; j < M[0].length; j++) {
                System.out.println(i + "," + j);

                // Remove previos data
                tmpSum = colSums.get(0);
                colSums.remove(0);
                tmpTotSum -= tmpSum;
                // System.out.println("tmpSum(-):"+tmpSum);

                // Insert next data
                tmpSum = getColSum(M, i, j + 1);
                tmpTotSum += tmpSum;
                colSums.add(tmpSum);
                // System.out.println("tmpSum(+):"+tmpSum);

                if (j == M[0].length - 1) {
                    tmpTotCnt -= tmpCnt;
                }

                // tmpSum=tmpTotSum-M[i][j];
                ret[i][j] = (int) Math.floor(tmpTotSum / tmpTotCnt);
                // System.out.println("=>"+tmpTotSum+"/"+tmpTotCnt+"="+ret[i][j]);

                if (j == 0) {
                    tmpTotCnt += tmpCnt;
                }
            }
        }
        return ret;
    }

    protected int getColSum(int[][] M, int i, int j) {
        int ret = 0;
        int l = M.length - 1;
        if (j < M[0].length) {
            ret += (i == 0) ? 0 : M[i - 1][j];
            ret += M[i + 0][j];
            ret += (i == l) ? 0 : M[i + 1][j];
            /*
             * System.out.println((i-1)+","+j+":"+((i==0)?0:M[i-1][j]));
             * System.out.println((i+0)+","+j+":"+ M[i+0][j]);
             * System.out.println((i+1)+","+j+":"+((i==l)?0:M[i+1][j]));
             */
        }
        return ret;
    }
}