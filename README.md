# Tugas-PBO-Week5
penugasan pbo pertemuan 5 membuat sistem pengambilan mata kuliah

Nama : Reza Afzaal Faizullah Taqy <br>
NRP  : 5025241051 


1. Fungsi Masing-Masing Class

a. Class MataKuliah
Class ini digunakan untuk menyimpan data mengenai mata kuliah. Setiap objek mata kuliah memiliki atribut kode, nama, dan jumlah SKS. Selain itu, class ini juga menyediakan method toString() untuk menampilkan informasi mata kuliah dalam format yang mudah dibaca. Dengan adanya informasi SKS, sistem bisa menghitung total beban studi mahasiswa.

b. Class Dosen
Class ini merepresentasikan dosen pengajar. Setiap dosen memiliki atribut NIP dan nama. Class ini digunakan sebagai penghubung antara mata kuliah dan kelas, sehingga setiap kelas memiliki pengajar yang jelas. Method toString() menampilkan informasi lengkap dosen.

c. Class Kelas
Class ini menghubungkan antara mata kuliah, dosen, dan mahasiswa. Atribut yang dimiliki antara lain kode kelas, mata kuliah yang diajarkan, dosen pengajar, kapasitas, serta daftar mahasiswa yang terdaftar. Method utama dalam class ini adalah tambahPeserta() untuk menambahkan mahasiswa ke kelas selama kapasitas belum penuh, dan hapusPeserta() untuk menghapus mahasiswa dari kelas. Informasi kelas ditampilkan melalui method toString().

d. Class Mahasiswa
Class ini menyimpan informasi mengenai mahasiswa, seperti NRP, nama, asal daerah, IPK, password, daftar kelas yang diambil, serta total SKS yang ditempuh. Mahasiswa memiliki batas maksimal SKS, misalnya 24 SKS per semester. Method penting di dalamnya meliputi ambilKelas() untuk mendaftar ke kelas baru, dropKelas() untuk membatalkan kelas, serta tampilkanProfil() dan tampilkanKelas() untuk menampilkan informasi mahasiswa. Pada versi GUI, method tambahan tampilkanProfilGUI() dan tampilkanKelasGUI() digunakan untuk menampilkan informasi melalui JOptionPane.

e. Class Database
Class ini berfungsi sebagai penyedia data awal (initializer). Method init() digunakan untuk membuat daftar dosen, mata kuliah, kelas, serta mahasiswa. Selain itu, class ini juga menyediakan method login() untuk autentikasi mahasiswa berdasarkan NRP dan password, serta method cariKelas() untuk menemukan kelas berdasarkan kode.

f. Class Main
Class ini menjadi titik masuk program. Fungsinya adalah mengatur alur sistem KRS mulai dari login mahasiswa, menampilkan menu, serta mengatur interaksi dengan pengguna. Pada versi GUI, Main menggunakan JOptionPane untuk input dan output, sehingga tidak bergantung pada terminal. Menu yang tersedia mencakup melihat profil mahasiswa, melihat daftar kelas, mengambil kelas, drop kelas, serta melihat daftar kelas yang sudah diambil.

2. Cara Penggunaan Sistem

Pengguna pertama kali menjalankan program melalui Main. Program akan meminta mahasiswa memasukkan NRP dan password melalui dialog box (JOptionPane). Jika data sesuai dengan daftar mahasiswa di Database, login akan berhasil dan mahasiswa bisa masuk ke menu utama.

Di menu utama, mahasiswa dapat memilih beberapa opsi: melihat profil, melihat daftar kelas yang tersedia, mendaftar ke kelas, drop kelas, atau melihat kelas yang sudah diambil. Setiap kali mahasiswa mendaftar ke kelas, sistem akan mengecek kapasitas kelas dan jumlah SKS yang sudah diambil. Jika memenuhi syarat, kelas akan berhasil ditambahkan. Jika kapasitas penuh atau SKS melebihi batas, sistem akan menolak pendaftaran.

Seluruh interaksi dilakukan melalui popup GUI sehingga lebih user-friendly dibanding input terminal.

3. Penjelasan Alur Program

Program dimulai dari Main, lalu memanggil Database.init() untuk menyiapkan data awal.

<img width="295" height="130" alt="image" src="https://github.com/user-attachments/assets/583b5082-72e7-490a-8c21-894d82b49c29" />

<img width="291" height="129" alt="image" src="https://github.com/user-attachments/assets/383b9aaf-e4e4-4b36-9e35-c20555cc5a6c" />


Mahasiswa login dengan memasukkan NRP dan password.

<img width="293" height="259" alt="image" src="https://github.com/user-attachments/assets/95b43afb-390c-49cb-8134-f42e92fbf2b8" />


Jika login berhasil, program menampilkan menu pilihan.

Mahasiswa dapat memilih:

<img width="259" height="192" alt="image" src="https://github.com/user-attachments/assets/613c8adb-7c83-49e6-ab73-b2cbb230cf51" />


Melihat profil → memanggil tampilkanProfilGUI().

<img width="640" height="199" alt="image" src="https://github.com/user-attachments/assets/e9d0388f-5ff8-4235-97cb-f88be5a6fbc3" />


Melihat daftar kelas → menampilkan semua objek Kelas dari Database.

<img width="307" height="124" alt="image" src="https://github.com/user-attachments/assets/f80953c3-1774-471d-a0c7-168969389a30" />


Mengambil kelas → memanggil ambilKelas(), lalu menambahkan mahasiswa ke daftar peserta.

<img width="302" height="132" alt="image" src="https://github.com/user-attachments/assets/005c70bb-2aa2-4d4a-9a35-97e5a8548f66" />


Drop kelas → memanggil dropKelas() untuk menghapus kelas yang sudah diambil.

<img width="512" height="126" alt="image" src="https://github.com/user-attachments/assets/a9d8a863-e739-4cea-8819-31a2d3c490f7" />


Melihat kelas yang diambil → memanggil tampilkanKelasGUI().



Proses berulang sampai mahasiswa memilih keluar.
