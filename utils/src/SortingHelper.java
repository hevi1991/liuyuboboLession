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

    public static <E extends Comparable<E>> void sortTest(String className, E[] arr) {
        long startTime = System.nanoTime();
        try {
            // 反射调用sort方法
            Class<?> clz = Class.forName(className);
            Method sort = clz.getMethod("sort", Comparable[].class);
            sort.invoke(null, (Object) arr);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException("SelectionSort failed.");
        }
        System.out.println(String.format("%s , n = %d : %f s", className, arr.length, time));
    }
}
