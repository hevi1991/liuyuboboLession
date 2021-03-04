public class LinearSearch {

    // 将构造函数设置为私有，让外部无法实例化
    private LinearSearch() {
    }

    public static int search(int[] data, int target) {

        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] data = {1, 23, 4, 44, 5, 6, 123};
        int res = LinearSearch.search(data, 44);
        System.out.println(res);

        int res2 = LinearSearch.search(data, 1234);
        System.out.println(res2);
    }

}
