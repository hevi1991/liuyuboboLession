public class InsertionSort {

    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            /*
            for (int j = i; j - 1 >= 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    SortingHelper.swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
             */
            // 简化条件
            for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                SortingHelper.swap(arr, j, j - 1);
            }
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E tmpl = arr[i];
            int j;
            // 减少swap的调用（交换索引元素）
            for (j = i; j - 1 >= 0 && tmpl.compareTo(arr[j - 1]) < 0; j--) {
                // 如果比需要确认的位置tmpl要小的时候，已被排序的元素直接赋值
                arr[j] = arr[j - 1];
            }
            // 将值直接插入到位置
            arr[j] = tmpl;
        }
    }

    public static <E extends Comparable<E>> void sortSelfmake(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    SortingHelper.swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] dataSize = {10000, 100000};
        /*for (int n : dataSize) {
            System.out.println("Random Array");
            Integer[] arr = ArrayGenerator.genrateRandomArray(n, n);
            Integer[] arr2 = new Integer[arr.length];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            SortingHelper.sortTest(InsertionSort.class.getName(), null, arr);
            SortingHelper.sortTest(InsertionSort.class.getName(), "sort2", arr2);
        }*/

        for (int n : dataSize) {
            System.out.println("Random Array");
            Integer[] arr = ArrayGenerator.genrateRandomArray(n, n);
            Integer[] arr2 = new Integer[arr.length];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            SortingHelper.sortTest(InsertionSort.class.getName(), null, arr);
            SortingHelper.sortTest(SelectionSort.class.getName(), null, arr2);
        }

        for (int n : dataSize) {
            System.out.println("Ordered Array");
            Integer[] arr = ArrayGenerator.generateOrderedArray(n);
            Integer[] arr2 = new Integer[arr.length];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            SortingHelper.sortTest(InsertionSort.class.getName(), null, arr);
            SortingHelper.sortTest(SelectionSort.class.getName(), null, arr2);
        }
    }
}
