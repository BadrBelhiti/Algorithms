package datastructures;



public class DataStructureTester {

    public static void testArray(){
        Array<String> array = new Array<String>();

        array.add("1");
        array.add("Test");
        System.out.println(array);
        array.remove("Test");
        System.out.println(array);
        System.out.println(array.search("Test"));
    }

    public static void testLinkedList(){
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.addLast("Test");
        linkedList.addLast("Test2");
        linkedList.addLast("Test3");
        linkedList.addLast("Test2");
        System.out.println(linkedList);

        while (!linkedList.isEmpty()){
            System.out.println(linkedList.removeFirst());
        }

    }

}
