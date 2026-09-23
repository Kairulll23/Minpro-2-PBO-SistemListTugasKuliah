# Minpro-2-PBO-SistemListTugasKuliah <br>  

# Judul : Sistem List Tugas Kuliah  

---

## 1. Deskripsi Singkat Program  
Pada program ini saya membuat sistem sederhana berbasis CLI untuk membantu mahasiswa dalam mengelola dan mencatat daftar tugas perkuliahan secara dinamis. Di dalam program ini pengguna bisa menambahkan tugas baru, menampilkan daftar tugas yang sudah di-input, mengubah data jika ada kesalahan, dan menghapus tugas yang sudah selesai dari daftar. Program ini berfokus pada efisiensi manajemen tugas kuliah berbasis Object-Oriented Programming (OOP). Lalu pada sistem ini dikembangkan lebih baik lagi dengan menerapkan arsitektur MVC (Model-View-Controller), konsep Inheritance untuk membagi tipe tugas (Tugas Individu dan Tugas Kelompok), validasi input yang lebih ketat agar program tidak gampang *crash*, serta penyediaan dummy data awal di dalam ArrayList.

---  

## 2. Penjelasan Class & Atribut  
Pada project ini, strukturnya dibagi ke dalam arsitektur MVC dengan package terpisah:  

**Package model:**
* **Tugas (superclass)** 
  * kodeTugas
  * namaMatkul
  * detailTugas
  * dateline
* **TugasIndividu (subclass)**
  * linkPengumpulan
* **TugasKelompok (subclass)**
  * namaKelompok
  * jumlahAnggota
* **Mahasiswa**
  * nim
  * nama

**Package controller:**
* **TugasController**
  * listTugasKu (ArrayList)

**Package view:**
* **TugasView**
  * scan (Scanner)
  * controller (TugasController)

**Package main:**
* **Main** (Entry point)

---

## 3. Penjelasan Tiap Class 

* **Tugas**
  * Penjelasan class: Berfungsi sebagai superclass (abstract class) yang menyimpan data umum untuk setiap tugas perkuliahan.
  * Menggunakan atribut ber-access modifier private (encapsulation) yaitu kodeTugas, namaMatkul, detailTugas, dan dateline.
  * Menggunakan constructor, getter, setter, serta abstract method `getTipeTugas()` dan `cetakBaris()` yang nantinya di-override oleh subclass.

* **TugasIndividu**
  * Penjelasan class: Class turunan (subclass) pertama dari class Tugas yang khusus menampung data tugas kategori individu.
  * Memiliki atribut tambahan `linkPengumpulan`.
  * Menggunakan `super` pada constructor untuk memanggil atribut superclass, serta menerapkan method overriding pada `getTipeTugas()` dan `cetakBaris()` untuk mencetak format tabel khusus tugas individu.

* **TugasKelompok**
  * Penjelasan class: Class turunan (subclass) kedua dari class Tugas yang khusus menampung data tugas kategori kelompok.
  * Memiliki atribut tambahan `namaKelompok` dan `jumlahAnggota`.
  * Menggunakan `super` pada constructor serta menerapkan method overriding pada `getTipeTugas()` dan `cetakBaris()` untuk mencetak informasi nama kelompok dan jumlah anggota.

* **Mahasiswa**
  * Penjelasan class: Menampung identitas mahasiswa/user (NIM dan Nama) yang menggunakan aplikasi.
  * Digunakan untuk memberikan sapaan personal pada header antarmuka program.

* **TugasController**
  * Penjelasan class: Merupakan pusat pengolahan logika bisnis dan penyimpanan data sementara.
  * Memiliki atribut `listTugasKu` yang menggunakan `ArrayList<Tugas>` untuk menampung data objek tugas secara dinamis.
  * Menangani operasi logika CRUD (Create, Read, Update, Delete) serta pengisian dummy data awal pada constructor.

* **TugasView**
  * Penjelasan class: Bertanggung jawab atas antarmuka pengguna berbasis teks/terminal.
  * Menampilkan menu utama interaktif, menerima input dari pengguna menggunakan `Scanner`, dan menangani validasi input.

* **Main**
  * Penjelasan class: Class entry point utama tempat program pertama kali dijalankan.
  * Menginisialisasi objek `Mahasiswa` dan memanggil method `olahMenu()` dari `TugasView`.

---  

## 4. Penjelasan Penerapan Encapsulation & Inheritance  

* **Encapsulation**
  * Semua atribut pada setiap class di dalam package `model` menggunakan access modifier `private` agar tidak dapat diakses secara langsung dari luar class.
  * Pengaksesan dan pembaruan nilai variabel dilakukan menggunakan method `getter` dan `setter`.
  * Terdapat validasi pada penanganan input di kelas View untuk memastikan data teks tidak kosong (`isEmpty()`) dan input pilihan menu/angka sesuai tipe datanya.

* **Inheritance**
  * Class `Tugas` bertindak sebagai Superclass yang menyimpan atribut umum tugas kuliah.
  * Class `TugasIndividu` dan `TugasKelompok` bertindak sebagai Subclass yang mewarisi (`extends`) class `Tugas`.
  * Pemanggilan constructor induk dilakukan menggunakan keyword `super(...)` pada subclass untuk meneruskan data dasar ke superclass.

---

## 5. Penjelasan Alur Program dan Dokumentasi Output  
Saat program dijalankan, sistem otomatis memasukkan dummy data awal di dalam constructor `TugasController`, sehingga daftar tugas langsung tampil saat menu Read pertama kali dipilih.  

Pada saat program dijalankan, nantinya akan menampilkan menu utama di terminal dengan 5 pilihan: <br>  
<p align="center">
  <img width="327" height="163" alt="image" src="https://github.com/user-attachments/assets/c3d4c11b-7c82-4c6a-a9c1-9171f3e59867" /> 
</p>

1. **Tambah Data Tugas (Create):**
Pengguna dapat memilih tipe tugas (Individu/Kelompok) terlebih dahulu, kemudian menginputkan kode tugas, mata kuliah, catatan, deadline, serta atribut khusus tipe tugas. Sistem dilengkapi fungsi validasi `bacaAngka()` agar jika pengguna salah menginputkan huruf pada pilihan menu atau jumlah anggota, sistem tidak crash melainkan menampilkan peringatan "[!] Input harus berupa angka!" dan meminta input ulang. <br>
<p align="center">
  <img width="332" height="314" alt="image" src="https://github.com/user-attachments/assets/1401f753-ce24-4bb1-be5f-a92dfd5e80ef" />
</p>

2. **Tampilkan Data Tugas (Read):**
Menampilkan daftar semua tugas yang tersimpan di dalam ArrayList lengkap dengan tipe tugas dan keterangan tambahannya. Di sini langsung tampil data tugas awal hasil dari dummy data. <br>
<p align="center">
  <img width="909" height="269" alt="image" src="https://github.com/user-attachments/assets/c245628b-1259-4dc7-bccc-a6041684fa9c" />
</p>

3. **Ubah Data Tugas (Update):**
Pengguna memasukkan kode tugas yang ingin diubah. Sistem akan mencari kode tersebut, lalu meminta input data baru sesuai dengan tipe tugasnya (Individu atau Kelompok). <br>
<p align="center">
  <img width="874" height="532" alt="image" src="https://github.com/user-attachments/assets/6fd38883-6a00-4676-a3fe-3e36c4008024" />
</p>

4. **Hapus Data Tugas (Delete):**
Digunakan untuk menghapus data tugas dari daftar berdasarkan kode tugas yang dimasukkan. Nanti ada pemberitahuan "[+] Tugas berhasil dihapus." <br>
<p align="center">
  <img width="917" height="456" alt="image" src="https://github.com/user-attachments/assets/88131fc7-8c8c-41e5-a892-6201868bf5b3" />
</p>

5. **Keluar:**
Menutup perulangan program dan menampilkan pesan penutup "Terima kasih, program selesai." <br>
<p align="center">
  <img width="540" height="255" alt="image" src="https://github.com/user-attachments/assets/2113e84e-64f4-4cf5-8a76-5be3850c0239" />
</p>

---  

## 6. Penerapan Nilai Tambah  
* **Struktur Arsitektur MVC:** Kode program dipisah secara terstruktur ke dalam package `model`, `controller`, `view`, dan `main` untuk memisahkan antara struktur data, logika bisnis, dan tampilan antarmuka.
* **Polymorphism (Method Overriding):** Diterapkan pada method `cetakBaris()` dan `getTipeTugas()` di subclass `TugasIndividu` dan `TugasKelompok` untuk menyesuaikan tampilan format tabel sesuai atribut spesifik dari masing-masing kategori tugas.
* **Validasi Input Kebal Error:** Method `bacaAngka()` dan `bacaTeks()` pada `TugasView` memastikan pengguna tidak memasukkan teks kosong atau tipe data string pada inputan berjenis angka, sehingga mencegah *InputMismatchException*.
* **Dummy Data Awal:** ArrayList otomatis terisi dengan 2 data sampel (Tugas Individu dan Tugas Kelompok) saat `TugasController` diinstansiasi.
