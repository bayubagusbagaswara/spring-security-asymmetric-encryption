package com.asymmetric.condensedlist;

import java.util.HashSet;
import java.util.Set;

public class Result {

    /*
     * Menghapus node duplicate.
     * Hanya kemunculan pertama dari setiap nilai
     * yang dipertahankan.
     */
    public static SinglyLinkedListNode condense(
            SinglyLinkedListNode head) {

        // Jika list kosong
        if (head == null) {
            return null;
        }

        /*
         * Menyimpan nilai yang sudah pernah ditemukan.
         */
        Set<Integer> seen = new HashSet<>();

        // Node pertama selalu dipertahankan
        seen.add(head.data);

        // Pointer untuk traversing linked list
        SinglyLinkedListNode current = head;

        /*
         * Kita memeriksa current.next agar lebih mudah
         * menghapus node duplicate.
         */
        while (current.next != null) {

            // Jika node berikutnya adalah duplicate
            if (seen.contains(current.next.data)) {

                /*
                 * Lewati node duplicate.
                 *
                 * Contoh:
                 *
                 * 3 -> 4 -> 3 -> 2
                 *      ^
                 *    current
                 *
                 * Menjadi:
                 *
                 * 3 -> 4 -> 2
                 */
                current.next = current.next.next;

            } else {

                // Simpan nilai yang baru ditemukan
                seen.add(current.next.data);

                // Pindah ke node berikutnya
                current = current.next;
            }
        }

        return head;
    }
}
