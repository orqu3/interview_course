package lesson_2.task_2;

public class Main {
    public static void main(String[] args) {

        arrayListTest();
    }

    private static void arrayListTest() {
        MyArrayList<Integer> al = new MyArrayList<>();
        for (int i = 0; i < 15; i++) {
            al.add(i);
        }
        System.out.println(al.size());
        System.out.println(al);
        System.out.println(al.get(1));
        System.out.println(al.remove(4));
        System.out.println(al);
        al.add(0,7);
        System.out.println(al);
        al.set(1, 8);
        System.out.println(al);
    }
}
