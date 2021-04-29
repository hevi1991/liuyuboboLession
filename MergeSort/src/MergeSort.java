import java.util.Arrays;

/**
 * 归并排序法
 */
public class MergeSort {

    private MergeSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

//        int mid = (l + r) / 2;
        int mid = l + (r - l) / 2;// 做减法，防止数值超过32位导致越界
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
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
        // 复制一份arr
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
//        int n = 100000;
//        Integer[] arr = ArrayGenerator.genrateRandomArray(n, n);
//        SortingHelper.sortTest("MergeSort", "sort", arr);

        Integer[] arr2 = new Integer[]{7, 1, 4, 2, 8, 3, 6, 5};
        MergeSort.sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
