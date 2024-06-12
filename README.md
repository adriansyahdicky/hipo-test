# Balanced Brackets

## Deskripsi
Program ini memeriksa apakah sebuah string yang berisi karakter-karakter bracket `{`, `}`, `(`, `)`, `[`, `]` seimbang atau tidak. Sebuah string dikatakan seimbang jika setiap bracket pembuka memiliki bracket penutup yang sesuai dalam urutan yang benar.

## Contoh
Input: `{[()]}`  
Output: YES

Input: `{[(])}`  
Output: NO

Input: `{(([])[])[]}`  
Output: YES

## Kompleksitas
- **Waktu**: `O(n)`, dimana `n` adalah panjang string. Program melakukan satu pass melalui string, dan setiap operasi pada stack (push/pop) adalah `O(1)`.
- **Ruang**: `O(n)` dalam kasus terburuk, ketika semua karakter dalam string adalah bracket pembuka yang semuanya dimasukkan ke dalam stack.

## Penjelasan
1. Program menggunakan stack untuk melacak bracket pembuka.
2. Setiap kali menemukan bracket pembuka, karakter tersebut didorong ke dalam stack.
3. Setiap kali menemukan bracket penutup, program memeriksa apakah stack kosong. Jika kosong, berarti bracket penutup tidak memiliki pasangan.
4. Program mengeluarkan elemen dari stack dan memeriksa apakah elemen tersebut cocok dengan bracket penutup saat ini.
5. Setelah iterasi selesai, program memeriksa apakah stack kosong. Jika kosong, semua bracket seimbang; jika tidak, bracket tidak seimbang.

## Cara Menggunakan
Jalankan program dengan memberikan string yang berisi bracket sebagai input, dan program akan mengembalikan "YES" jika bracket seimbang atau "NO" jika tidak.

