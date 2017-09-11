# gps-tracker-tester-client

## Menambahkan GPS Tracker

* Buat Akun di Aplikasi Semut, Download : https://play.google.com/store/apps/details?id=id.pptik.semutangkot

* `HTTP POST` ke `<url>/api/users/login`, headers `Content-Type` dg value `application/x-www-form-urlencoded` dengan parameter body :

  `Email` = Email ketika daftar di aplikasi semut

  `Password` = Password ketika daftar di aplikasi semut

Expected response :

```json
{
    "success": true,
    "message": "Berhasil melakukan Login",
    "SessionID": "00d31a337eb515c02ba602c906990931",
    "Profile": {
        "ID": 3002,
        "Name": "Hendra",
        "username": "hynra02",
        "Email": "hynra02@hynra.com",
        "CountryCode": 62
    }
}
```

* Simpan value properties dari `SessionID` untuk digunakan sebagai salah satu pendaftaran GPS Tracker

* `HTTP POST` ke `<url>/api/tracker/register`, headers `Content-Type` dg value `application/x-www-form-urlencoded` dengan parameter body :
  
  `Mac` : Mac address GPS Tracker
  
  `Keterangan` : Keterangan dari GPS Tracker
  
  `SessionID` : Access Token/session id dari proses login
  
  `Type` : Sementara tersedia dua type tracker berdasarkan peruntukannya, diisi dengan `Bus` atau `Angkot`
  
  `AppID` : Flag testing, Diisi dengan angka `0` supaya bisa di track dengan aplikasi Tester
  
* Jika daftar berhasil, test dengan aplikasi Tester. File `.apk` bisa didownload di tab `release` pada repo ini. Jika GPS Tracker yang baru didaftarkan tidak muncul di aplikasi, berarti GPS belum mengirimkan data ke server. Jika GPS muncul dalam aplikasi, berarti GPS Tracker sudah bisa digunakan.

* `HTTP POST` bisa menggunakan aplikasi `POSTMAN`

* Sourcecode untuk backend-nya, bisa dilihat di : https://github.com/pptik/gps-tracker-tester-api
