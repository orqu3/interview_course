package lesson_2.task_1;

public class Main {
    public static void main(String[] args) {

        linkedListTest();
    }

    private static void linkedListTest() {
        MyLinkedList<Integer> ll = new MyLinkedList<>();
        for (int i = 0; i < 5; i++) {
            ll.insertFirst(i);
        }
        System.out.println(ll.size());
        System.out.println(ll);
        System.out.println(ll.removeFirst());
        System.out.println(ll.removeLast());
        System.out.println(ll);
        ll.insertFirst(7);
        ll.insertLast(45);
        System.out.println(ll);
        ll.remove(3);
        System.out.println(ll);
    }
}
