public class LinearSearch {

    // 将构造函数设置为私有，让外部无法实例化
    private LinearSearch() {
    }

    public static <T> int search(T[] data, T target) {

        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] dataSize = {1000000, 10000000};

        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generateOrderedArray(n);
            long startTime = System.nanoTime();
            for (int k = 0; k < 100; k++) {
                LinearSearch.search(data, n);
            }
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n=" + n + ", 100 runs: " + time + "s");
        }


        /*
        int res2 = LinearSearch.search(data, 1234);
        System.out.println(res2);

        Student student1 = new Student("09123", "Peter");
        Student student2 = new Student("09124", "Anna");
        Student student3 = new Student("09125", "Tim");

        Student[] students = {student1, student2, student3};
        int studentRes = LinearSearch.search(students, new Student("09125"));
        System.out.println(studentRes);
        */
    }

}
