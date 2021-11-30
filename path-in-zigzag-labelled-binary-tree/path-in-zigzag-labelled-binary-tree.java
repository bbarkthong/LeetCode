class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ret;
        ret = new ArrayList<Integer>();
        Node node = new Node();
        int index = 0;

        for (int i = 32; i >= 0; i--) {
            // 노드값이 해당레벨에 없으면 무시
            if (label < Math.pow(2, i))
                continue;

            if (node.index == -1) {
                // 최초1회 노드위치를 구한다.
                index = node.getIndex(label, i);
            } else {
                // 부모 노드의 값을 구한다.
                index /= 2;
                label = node.getValue(index, i);

            }
            node.print();
            ret.add(label);
        }
        Collections.reverse(ret);
        return ret;
    }

    class Node {
        public int value;
        public int level;
        public int index = -1;

        public int getValue(
                int index,
                int level) {

            this.index = index;
            this.level = level;

            if (level % 2 == 1) {
                // 홀수레벨(역방향)
                // 노드값을 기준점(2^n+1) 오른쪽으로 찾는다.
                this.value = (int) Math.pow(2, level + 1) - (index + 1);
            } else {
                // 짝수레벨(정방향)
                // 노드값을 기준점(2^n) 오른쪽으로 찾는다.
                this.value = (int) Math.pow(2, level) + index;
            }
            return this.value;
        }

        public int getIndex(
                int value,
                int level) {

            this.value = value;
            this.level = level;

            if (level % 2 == 0) {
                // 짝수레벨(정방향)
                // 노드위치를 기준점(2^n) 오른쪽으로 찾는다.
                this.index = value - (int) Math.pow(2, level);
            } else {
                // 홀수레벨(역방향)
                // 노드위치를 기준점(2^n+1) 오른쪽으로 찾는다.
                this.index = (int) Math.pow(2, level + 1) - (value + 1);
            }
            return this.index;
        }

        public void print() {
            System.out.println("(" + this.level + "," + this.index + "):" + this.value);
        }
    }
}
