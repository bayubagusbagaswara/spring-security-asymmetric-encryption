package com.asymmetric.condensedlist;

/*
 * Struktur node untuk singly linked list.
 * Class untuk merepresentasikan satu node linked list
 */
public class SinglyLinkedListNode {

    int data; // Menyimpan nilai dari node

    SinglyLinkedListNode next; // Menunjuk ke node selanjutnya

    // Constructor untuk membuat node baru
    public SinglyLinkedListNode(int data) {
        this.data = data; // Mengisi nilai node
        this.next = null; // Awalnya node belum memiliki node berikutnya
    }

}
