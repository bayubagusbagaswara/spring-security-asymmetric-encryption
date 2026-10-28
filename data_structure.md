# Data Structure in Java

1. Array
2. List
3. Set
4. Map
5. Queue
6. Deque
7. Stack
8. Linked List
9. Tree
10. Heap / Priority Queue
11. Hash Table

# Array
Array menyimpan data dengan ukuran tetap.
Contoh:
```bash
int[] numbers = {10, 20, 30, 40};
```
Akses berdasarkan index sangat cepat:
```bash
System.out.println(numbers[2]);
```
Hasil
```bash
30
```

Karakteristik:
- ukuran fixed
- akses berdasarkan index cepat
- bisa menyimpan primitive seperti int, double, maupun object

Kompleksitas umum:
```bash
Access by index : O(1)
Search          : O(n)
Insert tengah   : O(n)
Delete tengah   : O(n)
```
Biasanya digunakan kalau ukuran data relatif sudah diketahui dan kita butuh akses cepat berdasarkan index.

# List
List adalah collection yang:
- mempertahankan urutan
- memperbolehkan duplicate
- bisa diakses dengan index

Dua implementasi yang sering ditanya adalah:
```bash
ArrayList
LinkedList
```
## ArrayList
Contoh:
```bash
List<String> names = new ArrayList<>();
names.add("Bayu");
names.add("Andi");
names.add("Bayu");
```
Duplicate boleh.
Isi:
```bash
[Bayu, Andi, Bayu]
```
ArrayList secara internal menggunakan dynamic array.
Karakteristik:
- akses index cepat
- append cepat
- insert/delete di tengah lebih mahal karena elemen perlu digeser

Kompleksitas:
```bash
get(index)       O(1)
add(end)         O(1) amortized
search           O(n)
insert middle    O(n)
delete middle    O(n)
```
Untuk kebanyakan kebutuhan aplikasi Java, ArrayList biasanya menjadi pilihan default untuk List.

# LinkedList
Setiap node menyimpan data dan referensi ke node lain.
Secara konsep:
```bash
[A] <-> [B] <-> [C]
```
Java `LinkedList` merupakan `doubly linked list`.
Contoh:
```bash
List<String> names = new LinkedList<>();
```
Akses random berdasarkan index tidak secepat `ArrayList`.
```bash
get(index) = O(n)
```
Tetapi penambahan/penghapusan pada ujung tertentu dapat dilakukan dengan efisien jika digunakan melalui operasi deque.

Pertanyaan interview yang sering muncul:
```bash
ArrayList vs LinkedList?
```

Jawaban singkat:
```bash
ArrayList menggunakan dynamic array sehingga random access lebih cepat, sedangkan LinkedList menggunakan node yang saling terhubung. 
Dalam penggunaan umum, ArrayList lebih sering dipilih karena performa akses dan locality yang lebih baik. 
LinkedList lebih relevan jika memang membutuhkan operasi queue/deque tertentu.
```

# Set
Set menyimpan nilai unik.

Tidak mengizinkan duplicate.

Contoh:
```bash
Set<Integer> numbers = new HashSet<>();

numbers.add(1);
numbers.add(2);
numbers.add(1);

System.out.println(numbers);
```

Hasil secara isi:
```bash
1, 2
```
Nilai 1 hanya tersimpan sekali.
Implementasi penting:
```bash
HashSet
LinkedHashSet
TreeSet
```

## HashSet
Paling umum.
```bash
Set<String> users = new HashSet<>();
```
Karakteristik:
- tidak menerima duplicate
- tidak menjamin urutan
- pencarian sangat cepat secara rata-rata

Kompleksitas rata-rata:
```bash
add       O(1)
contains  O(1)
remove    O(1)
```
Ini yang tadi kita gunakan untuk soal Condensed List.

## LinkedHashSet
Mirip `HashSet`, tetapi mempertahankan insertion order.

```bash
Set<Integer> set = new LinkedHashSet<>();
```

Jika dimasukkan:
```bash
5, 2, 8
```
maka iterasinya tetap:
```bash
5, 2, 8
```

## TreeSet
Menjaga data tetap terurut.
```bash
Set<Integer> numbers = new TreeSet<>();

numbers.add(5);
numbers.add(1);
numbers.add(3);
```

Hasil:
```bash
[1, 3, 5]
```
Kompleksitas:
```bash
add       O(log n)
contains  O(log n)
remove    O(log n)
```

# Map
Map menyimpan data dalam bentuk:
```bash
key -> value
```

Contoh:
```bash
Map<Integer, String> users = new HashMap<>();

users.put(1, "Bayu");
users.put(2, "Andi");
```
Untuk mengambil data:
```bash
users.get(1);
```
hasil:
```bash
Bayu
```
Key harus unik, tetapi value boleh duplicate.

Implementasi penting:
```bash
HashMap
LinkedHashMap
TreeMap
ConcurrentHashMap
```

## HashMap

Yang paling umum.
```bash
Map<String, Integer> scores = new HashMap<>();
```
Contoh:
```bash
scores.put("Bayu", 90);
scores.put("Andi", 80);
```
Kompleksitas rata-rata:
```bash
put      O(1)
get      O(1)
remove   O(1)
```

Pertanyaan interview yang sangat umum:
```bash
Bagaimana HashMap bekerja?
```

Jawaban dasarnya:
```bash
HashMap menggunakan hash dari key untuk menentukan bucket tempat entry disimpan. 
Ketika melakukan get(), Java menghitung hash key, mencari bucket terkait, lalu membandingkan key menggunakan equals().
```

Karena itu hashCode() dan equals() sangat penting.

# Queue
Queue menggunakan konsep:
```bash
FIFO
First In First Out
```
Yang masuk pertama keluar pertama.

Contoh kehidupan nyata:
```bash
Antrian bank
```
Java:
```bash
Queue<String> queue = new LinkedList<>();

queue.offer("A");
queue.offer("B");
queue.offer("C");

System.out.println(queue.poll());
```

Hasil:
```bash
A
```

Operasi penting:
```bash
offer()  -> tambah data
poll()   -> ambil + hapus head
peek()   -> lihat head tanpa hapus
```

Untuk queue biasa, sering juga lebih baik menggunakan:
```bash
Queue<String> queue = new ArrayDeque<>();
```

# Deque
Deque berarti:
```bash
Double Ended Queue
```

Bisa tambah dan hapus dari depan maupun belakang.
Contoh:
```bash
Deque<Integer> deque = new ArrayDeque<>();

deque.addFirst(10);
deque.addLast(20);
```

Hasil:
```bash
10, 20
```

Operasi:
```bash
addFirst()
addLast()

removeFirst()
removeLast()

peekFirst()
peekLast()
```
ArrayDeque sangat berguna untuk implementasi queue maupun stack.

# Stack
Stack menggunakan:
```bash
LIFO
Last In First Out
```
Yang terakhir masuk adalah yang pertama keluar.
Contoh:
```bash
Stack piring
```
Konsep:
```bash
push
push
push
pop
```

Di Java modern, biasanya lebih disarankan menggunakan:
```bash
Deque<Integer> stack = new ArrayDeque<>();
```

Contoh:
```bash
stack.push(10);
stack.push(20);
stack.push(30);

System.out.println(stack.pop());
```
Hasil:
```bash
30
```

Walaupun Java punya class:
```bash
Stack<E>
```
untuk kode baru biasanya `Deque` lebih direkomendasikan.

# Linked List
Linked list terdiri dari node.
Singly linked list:
```bash
[data | next]
```
Contoh:
```bash
3 -> 4 -> 2 -> 6 -> null
```
Setiap node menyimpan:
- data
- reference ke node berikutnya

Contoh class sederhana:
```bash
class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}
```
Kelebihan:
- ukuran fleksibel
- node dapat ditambahkan tanpa memindahkan seluruh elemen seperti array

Kekurangan:
- tidak bisa random access secara O(1)

Untuk mencari node ke-5, kita harus melewati:
```bash
1 -> 2 -> 3 -> 4 -> 5
```
Jadi:
```bash
Access = O(n)
```

