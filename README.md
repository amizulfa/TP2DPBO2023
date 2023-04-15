# TP2DPBO2023

# JANJI
> Saya Amida Zulfa Laila dengan NIM 2101147 mengerjakan Tugas Praktikum 2 dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

## Desain Program

- UML
<img width="550" alt="tp2 uml" src="https://user-images.githubusercontent.com/100895165/232225838-9bf2ef4b-5e23-4fe2-919e-2f2c1e71030e.png">

- Desain Database
<img width="550" alt="image" src="https://user-images.githubusercontent.com/100895165/232227742-e16ae82d-627e-49b9-9ba3-bf60ed9fb047.png">

## Alur Program
  Saat Program dijalankan, maka yang pertama ditampilkan adalah halaman login
 ### Login 
  - Jika sudah memiliki akun
    - Mengisi field username dan password
    - Menekan tombol `login`
    - Jika data yang dimasukan valid dengan yang ada di database, maka akan masuk ke halaman Utama yaitu `Beranda`
    - Jika data yang dimasukan tidak valid dengan yang ada di database, maka akan muncul pesan `Username atau Password yang dimasukan salah`
  - Jika belum memiliki akun
    - Maka tekan tombol `register`
    - dan akan masuk ke halaman `register`
### Register
  - Mengisi field nama, username, dan password
  - Menekan tombol `register`
  - Setelah terdaftar, maka dapat melanjutkan ke proses login dengan menekan tombol `login`

### Beranda
  Saat halaman `Beranda` ditampilkan, maka list Produk yang akan diperlihatkan terlebih dahulu.
  - Menekan tombol `Produk` untuk melihat list Card Produk dan dapat melakukan `Delete` serta `Update`. Dan dapat melakukan Add Data Produk jika menekan tombol `Add Produk` di bagian atas.
  - Jika menambah data `Produk`, yang perlu diisi adalah :
    - field `Nama produk`, `Harga`.
    - memilih kategori dalam bentuk Combobox.
    - menekan tombol `Browse` untuk memilih gambar, lalu akan menampilkan nama gambar beserta gambarnya.
    - Setelah itu menekan tombol `Submit`
  - Jika menambah data `Kategori`, yang perlu diisi adalah :
    - field `Nama Kategori`
    - Menekan tombol `Browse` untuk memilih gambar, lalu akan menampilkan nama gambar beserta gambarnya.
    - Setelah itu menekan tombol `Submit`
  - Menekan tombol `Kategori` untuk melihat list Card Kategori dan dapat melakukakn `Delete` serta `Update`. Dan dapat melakukan Add Data Kategori jika menekan tombol `Add Kategori` di bagian atas.
  - Menekan tombol `Edit` yang ada pada card, lalu mengisi data yang akan diupdate seperti saat akan melakukan `Add Data`.
    - Setelah itu tekan tombol `Update` untuk menyimpan data yang telah di Update.
  - Menekan tombol `Hapus` yang ada pada Card, untuk menghapus data yan dipilih.
    - Terdapat pesan konfirmasi, apakah yakin akan menghapus data ini. Jika `Ya`, maka data akan dihapus.
  - Untuk logout atau keluar dari program, makak dapat menekan tombol `Logout`. Dan akan menampilkan halaman `login` kembali.
  
  


## CARD
- Card Produk

  <img width="304" alt="card produk" src="https://user-images.githubusercontent.com/100895165/232196124-54cc8fb6-5dd9-488b-abcf-c66b6f59b680.png">
  
- Card Kategori
  
  <img width="296" alt="card kategori" src="https://user-images.githubusercontent.com/100895165/232196130-9bb79935-73f6-43b3-a9ac-3d5bfe8f2cfc.png">


## DOKUMENTASI
- Form Login

  <img width="261" alt="form login" src="https://user-images.githubusercontent.com/100895165/232195764-4ef7f664-5819-44a7-9fdd-f0be35f20f55.png">
  
- Form Register

  <img width="289" alt="form register" src="https://user-images.githubusercontent.com/100895165/232195775-83b24c0b-350f-4c1c-8787-9585ad7ca19d.png">

- Form Tambah Data Produk
  
  <img width="332" alt="form add produk" src="https://user-images.githubusercontent.com/100895165/232195782-d32bd6a7-05e4-4d84-91ef-f8dc65c95c20.png">

- Form Tambah Data Kategori
  
  <img width="300" alt="form add kategori" src="https://user-images.githubusercontent.com/100895165/232195797-4bd82cd4-c752-4080-8512-ed92f4f5245c.png">

- Form Update Data Produk
  
  <img width="332" alt="form update produk" src="https://user-images.githubusercontent.com/100895165/232195805-d8de0fb7-2158-4c6b-956b-64a237337cc3.png">

- Form Update Data Kategori
  
  <img width="301" alt="form update kategori" src="https://user-images.githubusercontent.com/100895165/232195824-2933b2e5-42ec-4cb0-957c-ebe22edc0bc9.png">

- Beranda Kategori
  
  <img width="427" alt="kategori navigasi" src="https://user-images.githubusercontent.com/100895165/232195851-f1765486-facf-4989-8a44-11a6a6fd3385.png">

- Beranda Produk
  
  <img width="428" alt="produk navigasi" src="https://user-images.githubusercontent.com/100895165/232195872-f43f45eb-f3ae-449e-9bb3-1c1f2ff0c8d2.png">

  

- VIDIO
<p align="center">
  <img src="https://github.com/amizulfa/TP2DPBO2023/blob/main/tp2-min.gif" alt="gif format testing"/>
</p>
