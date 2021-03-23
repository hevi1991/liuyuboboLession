import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SortingHelper {

    private SortingHelper() {
    }

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String className, String methodName, E[] arr) {
        long startTime = System.nanoTime();
        try {
            // 反射调用sort方法
            Class<?> clz = Class.forName(className);
            methodName = methodName == null ? "sort" : methodName;
            Method sort = clz.getMethod(methodName, Comparable[].class);
            sort.invoke(null, (Object) arr);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException("SelectionSort failed.");
        }
        System.out.println(String.format("%s %s , n = %d : %f s", className, methodName, arr.length, time));
    }

    /**
     * 交换数组元素
     *
     * @param arr 数组
     * @param i   下标1
     * @param j   下标2
     * @param <E> 泛型
     */
    public static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
