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

}
