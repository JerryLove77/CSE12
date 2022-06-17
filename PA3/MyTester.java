public class MyTester {
   
    private MyLinkedList<String> threeStringList;
    private String[] strData = {"CSE 12", "Paul Cao", "Christine Alvarado"};

    public static void main(String[] args){
        MyLinkedList<Integer> emptyIntegerList = new MyLinkedList<Integer>();
        MyLinkedList<Integer>  threeStringList = new MyLinkedList<>();
        emptyIntegerList.add(12);
        System.out.println(emptyIntegerList.tail.prev.data);
        System.out.println(emptyIntegerList.head.prev);
        System.out.println(emptyIntegerList.tail.next);
        emptyIntegerList.remove(0);
        System.out.println(emptyIntegerList.tail.prev.data);
        System.out.println(emptyIntegerList.head.prev);
        System.out.println(emptyIntegerList.tail.next);

    }
   
}