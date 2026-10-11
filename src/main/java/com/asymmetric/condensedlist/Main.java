package com.asymmetric.condensedlist;

public class Main {


    public static void main(String[] args) {

        /*
         * Membuat linked list:
         * 3 -> 4 -> 3 -> 2 -> 6 -> 1 -> 2 -> 6
         */

        SinglyLinkedListNode head = new SinglyLinkedListNode(3);

        head.next = new SinglyLinkedListNode(4);

        head.next.next = new SinglyLinkedListNode(3);

        head.next.next.next = new SinglyLinkedListNode(2);

        head.next.next.next.next = new SinglyLinkedListNode(6);

        head.next.next.next.next.next = new SinglyLinkedListNode(1);

        head.next.next.next.next.next.next = new SinglyLinkedListNode(2);

        head.next.next.next.next.next.next.next = new SinglyLinkedListNode(6);

        // Jalankan condense
        SinglyLinkedListNode result = Result.condense(head);

        // Tampilkan linked list hasil
        printList(result);
    }

    /*
     * Method helper untuk menampilkan linked list.
     */
    public static void printList(
            SinglyLinkedListNode head) {

        SinglyLinkedListNode current = head;

        while (current != null) {

            System.out.println(current.data);

            current = current.next;
        }
    }
}
