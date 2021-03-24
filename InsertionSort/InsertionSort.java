import java.util.Arrays;

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

    /*
    从后往前排

    对于这个作业，我们在 InsertionSort 中设立一个新的方法，叫 sort2。

    sort2 的基本逻辑是，从后向前扫描，对于每一个 arr[i]，寻找 arr[i…n) 区间中需要插入的位置。

    在具体找这个位置的时候， 我们依然是暂存 arr[i] 到 t 这个变量，之后，只要 t 比当前的 arr[j + 1] 还要大，说明 t 应该插入的位置还靠后，我们只需要让 arr[j + 1] 平行移动到 arr[j] 的位置，然后 j ++，继续看下一个 j。

    请大家再体会一下，在 sort 中，我们从前向后，每次对于某一个 arr[i]，在前面找到其插入的位置；

    在 sort2 中，我们从后向前，每次对于某一个 arr[i]，在后面找到其插入的位置；
     */
    public static <E extends Comparable<E>> void sort3(E[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {

            // 将 arr[i] 插入到合适的位置
            E t = arr[i];
            int j;
            for (j = i; j + 1 < arr.length && t.compareTo(arr[j + 1]) > 0; j++) {
                arr[j] = arr[j + 1];
                System.out.printf("inner: i=%d, j=%d, arr=%s\n", i, j, Arrays.toString(arr));
            }
            arr[j] = t;
            System.out.printf("i=%d, j=%d, arr=%s\n", i, j, Arrays.toString(arr));
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

        /*
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            System.out.println("Random Array");
            Integer[] arr = ArrayGenerator.genrateRandomArray(n, n);
            Integer[] arr2 = new Integer[arr.length];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            SortingHelper.sortTest(InsertionSort.class.getName(), null, arr);
            SortingHelper.sortTest(InsertionSort.class.getName(), "sort2", arr2);
        }

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
        }*/

        Integer[] sort3Arr = {4, 2, 3, 1};
//        SortingHelper.sortTest(InsertionSort.class.getName(), "sort3", sort3Arr);
        System.out.println("Start " + Arrays.toString(sort3Arr));
        sort3(sort3Arr);
        System.out.println("End " + Arrays.toString(sort3Arr));
    }
}
