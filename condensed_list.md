# Condensed List

Maksud soal ini adalah menghapus nilai yang muncul lebih dari satu kali pada sebuah singly linked list.
Yang dipertahankan hanya kemunculan pertama.
Misalnya input:
```bash
3 -> 4 -> 3 -> 2 -> 6 -> 1 -> 2 -> 6
```

Kita baca dari kiri ke kanan.
Nilai `3` pertama kali ditemukan:
```bash
3
```

maka dipertahankan.

Kemudian `4`:
```bash
3 -> 4
```

`4` juga pertama kali muncul, sehingga dipertahankan.
Kemudian ditemukan `3` lagi:
```bash
3 -> 4 -> 3
```

Karena `3` sudah pernah ditemukan sebelumnya, node ini harus dihapus.
Linked list menjadi:
```bash
3 -> 4 -> 2 -> 6 -> 1 -> 2 -> 6
```

Kemudian:
- `2` pertama → simpan
- `6` pertama → simpan
- `1` pertama → simpan
- `2` kedua → hapus
- `6` kedua → hapus
Hasil akhir:
```bash
3 -> 4 -> 2 -> 6 -> 1 
```

Pada program digunakan:
```bash
Set<Integer> seen = new HashSet<>();
```

`HashSet` digunakan untuk menyimpan nilai yang sudah pernah ditemukan.
Node pertama langsung dimasukkan:
```bash
seen.add(head.data);
```

Misalnya:
```bash
head = 3
```

maka:
```bash
seen = {3}
```

Kemudian:
```bash
SinglyLinkedListNode current = head;
```

`current` digunakan untuk berjalan melalui linked list.

Loop-nya:
```bash
while (current.next != null)
```

Program selalu memeriksa node berikutnya.
Misalnya:
```bash
3 -> 4 -> 3 -> 2
     ↑
   current
```

Jika `current` berada pada `4`, maka yang diperiksa adalah node berikutnya, yaitu `3`.
Program mengecek:
```bash
seen.contains(current.next.data)
```

Karena `3` sudah ada di `seen`, maka node tersebut dihapus:
```bash
current.next = current.next.next;
```

Sebelumnya:
```bash
3 -> 4 -> 3 -> 2
```
Sesudahnya:
```bash
3 -> 4 -> 2
```

Jika nilai belum pernah ditemukan, maka nilai tersebut ditambahkan:
```bash
seen.add(current.next.data);
```

dan pointer maju:
```bash
current = current.next;
```

Hal pentingnya adalah ketika duplicate ditemukan, current tidak langsung maju. Karena setelah menghapus sebuah node, program perlu memeriksa node berikutnya lagi.
Alur sederhananya:
```bash
Mulai dari head
      ↓
Simpan nilai pertama
      ↓
Periksa current.next
      ↓
Sudah pernah muncul?
     / \
   Ya   Tidak
   ↓      ↓
Hapus   Simpan ke Set
node    dan maju
   \      /
    Ulangi
      ↓
Return head
```

Untuk input:
```bash
3 -> 4 -> 3 -> 2 -> 6 -> 1 -> 2 -> 6
```
isi `seen` berkembang seperti:
```bash
{3}
{3, 4}
{3, 4, 2}
{3, 4, 2, 6}
{3, 4, 2, 6, 1}
```

Sedangkan `3`, `2`, dan `6` yang muncul kembali dihapus.
Hasil akhirnya:
```bash
3 -> 4 -> 2 -> 6 -> 1
```

Jika mengikuti format output HackerRank:
```bash
3
4
2
6
1
```

