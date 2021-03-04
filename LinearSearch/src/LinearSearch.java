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

        Integer[] data = {1, 23, 4, 44, 5, 6, 123};
        int res = LinearSearch.search(data, 44);
        System.out.println(res);

        int res2 = LinearSearch.search(data, 1234);
        System.out.println(res2);

        Student student1 = new Student("09123", "Peter");
        Student student2 = new Student("09124", "Anna");
        Student student3 = new Student("09125", "Tim");

        Student[] students = {student1, student2, student3};
        int studentRes = LinearSearch.search(students, new Student("09125"));
        System.out.println(studentRes);
    }

}
