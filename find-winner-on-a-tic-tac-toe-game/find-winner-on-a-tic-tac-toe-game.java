class Solution {
    protected String[] answer = { "Pending", "A", "B", "Draw" };

    public String tictactoe(int[][] moves) {
        int ret = 0;
        int i, x, y;
        int[] board = new int[9];

        for (i = 0; i < moves.length; i++) {
            // 수를 둔다.
            x = moves[i][0];
            y = moves[i][1];
            board[x * 3 + y] = i % 2 + 1; // 플레이어 A는 1번, B는 2번
            printBoard(board);

            // 4번째 수부터 승패를 확인한다.
            if (i >= 4) {
                ret = checkBoard(board, i);
                if (ret != 0)
                    return answer[ret];
            }
        }
        // 승패가 갈리지 않고, 모든 수를 다 두면 무승부
        if (ret == 0 && i == board.length) {
            ret = 3;
        }
        return answer[ret];
    }

    protected int checkBoard(int[] b, int p) {
        int m = (p % 2 + 1); // 플레이어 A는 1번, B는 2번
        if (b[4] == m) {
            for (int i = 0; i < 4; i++) {
                if ((b[i] == b[8 - i]) && (b[i] == m))
                    return m;
            }
        }
        if (b[0] == m) {
            // OOO
            // O..
            // O..
            if ((b[0] == b[1]) && (b[1] == b[2]))
                return m;
            if ((b[0] == b[3]) && (b[3] == b[6]))
                return m;
        }
        if (b[8] == m) {
            // ..O
            // ..O
            // OOO
            if ((b[8] == b[7]) && (b[7] == b[6]))
                return m;
            if ((b[8] == b[5]) && (b[5] == b[2]))
                return m;
        }
        return 0;
    }

    protected void printBoard(int[] b) {
        char ch;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (b[i * 3 + j]) {
                    case 1:
                        ch = 'O';
                        break;
                    case 2:
                        ch = 'X';
                        break;
                    default:
                        ch = '.';
                }
                System.out.print(ch);
            }
            System.out.println();
        }
        System.out.println("--------");
    }
}