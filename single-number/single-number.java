class Solution {
    public int singleNumber(int[] nums) {
        List<Integer> list;
        list = new ArrayList<Integer>();
        for (int tmp : nums) {
            if (list.contains(tmp))
                list.remove(list.indexOf(tmp));
            else
                list.add(tmp);
        }
        return list.get(0);
    }
}