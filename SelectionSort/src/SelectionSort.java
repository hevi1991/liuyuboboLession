import java.util.Arrays;

public class SelectionSort {
    private SelectionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {

            // 选择 arr[i...n) 中得最小值索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // 交换
            swap(arr, i, minIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 从后向前
    public static <E extends Comparable<E>> void sort2(E[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {

            int maxIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            // 交换
            swap(arr, i, maxIndex);
        }
    }


    public static void main(String[] args) {
        /*Integer[] arr = {1, 4, 2, 3, 6, 5};
        SelectionSort.sort(arr);
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();*/

        // Compareable 接口实现效果
        /*Student2[] students = {
                new Student2("213", "Peter", 89),
                new Student2("214", "Anne", 88),
                new Student2("215", "Sue", 93)
        };
        sort(students);
        for (Student2 student : students) {
            System.out.println(student);
        }*/

        /*int n = 10000;
        Integer[] arr = ArrayGenerator.genrateRandomArray(n, n);

        long startTime = System.nanoTime();
        sort(arr);
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException("SelectionSort failed.");
        }
        System.out.println(time + "s");*/

        // 使用封装后的测试方法，测试 O(n^2) 时间复杂度的运行时间
        /*int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.genrateRandomArray(n, n);
            SortingHelper.sortTest(SelectionSort.class.getName(), arr);
        }*/

        // 作业
        Integer[] integers = ArrayGenerator.genrateRandomArray(10, 10);
        sort2(integers);
        System.out.println(Arrays.toString(integers));
    }
}
