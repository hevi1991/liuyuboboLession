import java.util.Arrays;

/**
 * 归并排序法
 */
public class MergeSort {

    private MergeSort() {
    }


    /**
     * 优化归并过程
     *
     * @param arr 数组
     * @param <E> 元素类型
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {

        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;// 做减法，防止数值超过32位导致越界
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        // 左侧数组尾元素 小于 右侧数组头元素可以不需要调整合并
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }


    /**
     * 优化归并过程
     *
     * @param arr 数组
     * @param <E> 元素类型
     */
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort2(E[] arr, int l, int r) {

        // 小规模的数据量使用插入排序法性能更好
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = l + (r - l) / 2;// 做减法，防止数值超过32位导致越界
        sort2(arr, l, mid);
        sort2(arr, mid + 1, r);

        // 左侧数组尾元素 小于 右侧数组头元素可以不需要调整合并
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }


    /**
     * 合并两个有序的区间arr[l,mid]和 arr[mid+1,r]
     *
     * @param arr 原数组
     * @param l   左节点
     * @param mid 中间节点
     * @param r   右节点
     * @param <E> 类型
     */
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        // 复制一份arr[l, r)
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);

        int i = l, j = mid + 1;

        // 每轮循环为arr[k]赋值
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 5000000;
        Integer[] arr = ArrayGenerator.genrateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("MergeSort", "sort", arr);
        SortingHelper.sortTest("MergeSort", "sort2", arr2);

    }
}
