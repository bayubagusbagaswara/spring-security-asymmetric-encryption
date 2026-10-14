package com.asymmetric.condensedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        /*
         * Membuat linked list:
         * 3 -> 4 -> 3 -> 2 -> 6 -> 1 -> 2 -> 6
         */

        // Membuat node pertama (HEAD) dengan nilai 3
        SinglyLinkedListNode head = new SinglyLinkedListNode(3);

        // Menambahkan node 4 (setelah HEAD)
        head.next = new SinglyLinkedListNode(4);

        // Menambahkan node 3 lagi (sebelumnya di node HEAD berisi nilai 3)
        head.next.next = new SinglyLinkedListNode(3);

        // Menambahkan node 2
        head.next.next.next = new SinglyLinkedListNode(2);

        // Menambahkan node 6
        head.next.next.next.next = new SinglyLinkedListNode(6);

        // Menambahkan node 1
        head.next.next.next.next.next = new SinglyLinkedListNode(1);

        // Menambahkan node 2 lagi (sebelumnya sudah ada node yang berisi nilai 2)
        head.next.next.next.next.next.next = new SinglyLinkedListNode(2);

        // Menambahkan node 6 lagi (sebelumnya sudah ada node yang berisi nilai 6)
        head.next.next.next.next.next.next.next = new SinglyLinkedListNode(6);

        // Memanggil method condense untuk menghapus duplicate
        SinglyLinkedListNode result = Result.condense(head);

        // Tampilkan linked list hasil
        printList(result);
    }

    /*
     * Method helper untuk menampilkan linked list.
     */
    public static void printList(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        while (current != null) {
            log.info("Current- {}",current.data);
            current = current.next;
        }
    }

}
