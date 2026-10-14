package com.asymmetric.condensedlist;

import java.util.HashSet;
import java.util.Set;

public class Result {

    /*
     * Menghapus node duplicate.
     * Hanya kemunculan pertama dari setiap nilai
     * yang dipertahankan.
     */
    // Head adalah node pertama dari linked list
    public static SinglyLinkedListNode condense(SinglyLinkedListNode head) {
        // Cek apakah linked list kosong
        if (head == null) {
            // jika kosong, maka langsung return null
            return null;
        }

        // HashSet digunakan untuk menyimpan nilai yang sudah pernah ditemukan
        Set<Integer> seenSet = new HashSet<>();

        // Node pertama selalu dipertahankan, buat acuan
        // Nilai (data) dari node pertama langsung dimasukkan ke HashSet.
        seenSet.add(head.data);

        // Current digunakan sebagai pointer untuk berjalan di linked list
        SinglyLinkedListNode current = head;

        // Loop selama masih ada node setelah current
        while (current.next != null) {
            // Cek apakah nilai node berikutnya sudah pernah muncul. Cek apakah di Set sudah ada yang pernah muncul
            if (seenSet.contains(current.next.data)) {
                // Jika duplicate, maka lewat node tersebut, lanjut ke node berikutnya, dengan cara current.next langsung menunjuk ke node setelah duplicate
                current.next = current.next.next;
            } else {
                // Jika nilai belum pernah muncul (tidak ada data di Set), maka simpan nilai node berikutnya ke Set
                seenSet.add(current.next.data);

                // Lanjut pindah ke node berikutnya
                current = current.next;
            }
        }

        // Return head dari linked list yang sudah dihapus duplikatnya
        return head;
    }
}
