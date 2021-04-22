/**
 * 理解递归
 */
public class Sum {
    private static int sum(int[] arr) {
        return sum(arr, 0);
    }

    /**
     * 计算arr[l...n)这个区间的数字和
     *
     * @param arr 数组
     * @param l   左边界
     * @return arr[l...n)这个区间的数字和
     */
    private static int sum(int[] arr, int l) {
        if (l == arr.length) { // 最基本问题
            return 0;
        }
        return arr[l] + sum(arr, l + 1); // 把原问题转化成更小的问题
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(nums));
    }
}
