package datastructures;

/*
        A linked list is a data structure where each node
        directly points to the next node in the linked list.
        This class implements a singly linked list
        (i.e. each node only points to the next node). In contrast,
        a doubly linked list has nodes that point to the next and
        last node, allowing two-way traversal.

        addLast(...) - O(n)
        addFirst(...) - O(1)
        removeFirst(...) - O(1)
        removeLast(...) - O(n)
        search(...) - O(n)

        Note: The above time complexities are assuming that only the head (first) node is
        stored for reference. If a reference of the tail (last) node is also stored, then
        addLast(...) and removeLast(...) would also be of order O(1).
*/



public class LinkedList<T> {

    private ListNode<T> head;

    public void addLast(T val){
        ListNode<T> node = new ListNode<T>(val);
        if (head == null){
            this.head = node;
            return;
        }

        ListNode<T> curr = head;
        while (curr.next != null){
            curr = curr.next;
        }
        curr.next = node;
    }

    public T removeFirst(){
        if (head == null){
            return null;
        }
        ListNode<T> next = head.next;
        T val = head.val;
        this.head = next;
        return val;
    }

    public boolean contains(T val){
        ListNode<T> curr = head;

        while (curr != null){
            if (curr.val == val){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        ListNode<T> curr = head;
        while (curr != null){
            sb.append(curr.val);
            if (curr.next != null){
                sb.append(", ");
            }
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }


}
