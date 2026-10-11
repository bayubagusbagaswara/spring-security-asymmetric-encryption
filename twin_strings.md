# Twin Strings

Maksud soal ini adalah menentukan apakah dua string dapat dianggap sebagai twin.
Dua string disebut twin jika karakter yang berada pada indeks genap hanya boleh ditukar dengan karakter di indeks genap, dan karakter pada indeks ganjil hanya boleh ditukar dengan karakter di indeks ganjil.

Contoh:
```bash
String 1 = abcd
String 2 = cbad
```

Posisi karakter pada `abcd`:
```bash
Index : 0 1 2 3
Char  : a b c d
```

Maka:
- indeks genap = `a, c`
- indeks ganjil = `b, d`

- Untuk `cbad`:
```bash
Index : 0 1 2 3
Char  : c b a d 
```

Walaupun urutannya berbeda, isi kelompok genap tetap sama dan isi kelompok ganjil juga sama. Karena itu hasilnya:
```bash
Yes
```

Sedangkan contoh:
```bash
abcd
adbc
```
Untuk `abcd`:
```bash
Genap  = a, c
Ganjil = b, d
```

Untuk `adbc`:
```bash
Genap  = a, b
Ganjil = d, c
```

Kelompok genapnya berbeda, sehingga kedua string bukan twin.
Hasil:
```bash
No
```

Proses pada program dilakukan dengan membuat empat array:
```java
int[] firstEven = new int[26];
int[] firstOdd = new int[26];
int[] secondEven = new int[26];
int[] secondOdd = new int[26];
```

Array tersebut digunakan untuk menghitung berapa kali setiap huruf a-z muncul.

Ketika index genap:
```bash
if (j % 2 == 0)
```
karakter dimasukkan ke kelompok genap.
Sedangkan index ganjil masuk ke kelompok ganjil.
Misalnya:

```bash
firstEven[firstChar - 'a']++;
```

Jika karakter adalah `'c'`, maka:
```bash
'c' - 'a' = 2
```

sehingga posisi index 2 pada array bertambah satu.
Setelah semua karakter dihitung, program membandingkan:

```bash
Arrays.equals(firstEven, secondEven)
```
dan:

```bash
Arrays.equals(firstOdd, secondOdd)
```

Jika keduanya sama:
```bash
Yes
```

Jika salah satunya berbeda:
```bash
No
```

Contoh input:
```bash
firstString  = ["abcd", "abcd"]
secondString = ["cbad", "adbc"]
```

Hasil:
```bash
Yes
No
```

Jadi inti algoritmanya adalah:
```bash
Pisahkan karakter berdasarkan index genap dan ganjil
        ↓
Hitung frekuensi setiap karakter
        ↓
Bandingkan kedua string
        ↓
Sama → Yes
Berbeda → No
```