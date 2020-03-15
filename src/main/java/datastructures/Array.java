package datastructures;

/*
        Remaking of ArrayList class.
        add(...) - amortized O(1)
        remove(...) - O(n)
        get(...) - O(1)
        search(...) - O(n)
        contains(...) - O(n)
*/


public class Array<T> {

    private static final int INITIAL_SIZE = 8;

    private T[] array = (T[]) new Object[INITIAL_SIZE];
    private int size = 0;


    public void add(T element){
        if (size == array.length){
            T[] newArray = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            this.array = newArray;
        }
        array[size] = element;
        size++;
    }

    public void remove(T element){
        for (int i = 0; i < size; i++){
            if (array[i].equals(element)){
                for (int j = i; j < size - 1; j++){
                    array[j] = array[j + 1];
                }
                size--;
                break;
            }
        }
    }

    public T get(int index){
        return array[index];
    }

    public int search(T element){
        for (int i = 0; i < size; i++){
            if (array[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T element){
        return search(element) != -1;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++){
            sb.append(array[i]);
            if (i != size - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
