    import java.time.LocalDate;

    public class Mahasiswa {
        // ATRIBUT
        private String nama;
        private String npm;
        private float ipk;
        private int tahunLahir;
        private char kodeJenis;
        private String status;
        
        // KONSTRAKTOR
        public Mahasiswa() {
            this.nama = "";
            this.npm = "";
            this.ipk = 0.0f;
            this.tahunLahir = 0;
            this.kodeJenis = ' ';
            this.status = "";
        }
        
        // KONSTRUKTOR DENGAN PARAMETER
        public Mahasiswa(String nama, String npm, float ipk, int tahunLahir, char kodeJenis, String status) {
            this.nama = nama;
            this.npm = npm;
            this.ipk = ipk;
            this.tahunLahir = tahunLahir;
            this.kodeJenis = kodeJenis;
            this.status = status;
        }
        // GETTER
        public String getNama() {
            return nama;
        }
        
        public String getNpm() {
            return npm;
        }
        
        public float getIpk() {
            return ipk;
        }
        
        public int getTahunLahir() {
            return tahunLahir;
        }
        
        public char getKodeJenis() {
            return kodeJenis;
        }
        
        public String getStatus() {
            return status;
        }
        
        // SETTER
        public void setNama(String nama) {
            this.nama = nama;
        }
        
        public void setNpm(String npm) {
            this.npm = npm;
        }
        
        public void setIpk(float ipk) {
            this.ipk = ipk;
        }
        
        public void setTahunLahir(int tahunLahir) {
            this.tahunLahir = tahunLahir;
        }
        
        public void setKodeJenis(char kodeJenis) {
            this.kodeJenis = kodeJenis;
        }
        
        public void setStatus(String status) {
            this.status = status;
        }
        
        // METHOD UNTUK MENGAMBIL JENIS KELAMIN
        public String getJenisKelamin() {
            if (kodeJenis == 'P' || kodeJenis == 'p') {
                return "Perempuan";
            } else if (kodeJenis == 'L' || kodeJenis == 'l') {
                return "Laki - Laki";
            } else {
                return "Tidak diinformasikan";
            }
        }
        
        // METHOD UNTUK MENGAMBIL UMUR
        public int getUmur() {
            return LocalDate.now().getYear() - tahunLahir;
        }
        
        // METHOD UNTUK MENGAMBIL TAHUN MASUK
        public int getTahunMasuk() {
            return Integer.parseInt("20" + npm.substring(0, 2));
        }
        
        // METHOD UNTUK MENGAMBIL TAHUN LULUS
        public int getTahunLulus() {
            return Integer.parseInt("20" + npm.substring(2, 4));
        }
        
        // METHOD UNTUK MENGAMBIL KODE PRODI
        public String getKodeProdi() {
            return npm.substring(4, 6);
        }
        
        // METHOD UNTUK MENGAMBIL NAMA PRODI
        public String getProdi() {
            String kodeProdi = getKodeProdi();
            if (kodeProdi.equals("24")) {
                return "Sistem Informasi";
            } else if (kodeProdi.equals("25")) {
                return "Informatika";
            } else if (kodeProdi.equals("27")) {
                return "Teknik Elektro";
            } else {
                return "Program Studi Tidak Diketahui";
            }
        }
        
        // METHOD UNTUK MENGAMBIL NOMOR URUT
        public int getNomorUrut() {
            return Integer.parseInt(npm.substring(6));
        }
        
        // METHOD UNTUK MENGAMBIL PREDIKAT KELULUSAN
        public String getPredikatKelulusan() {
            if (ipk < 2.50) {
                return "Belum Lulus";
            } else if (ipk >= 2.50 && ipk <= 2.75) {
                return "Lulus";
            } else if (ipk >= 2.76 && ipk <= 3.00) {
                return "Memuaskan";
            } else if (ipk >= 3.01 && ipk <= 3.50) {
                return "Sangat Memuaskan";
            } else if (ipk >= 3.51 && ipk <= 4.00) {
                return "Dengan Pujian";
            } else {
                return "Tidak valid";
            }
        }
        
        // METHOD UNTUK MENGAMBIL VALIDASI IPK
        public boolean isValidIpk() {
            return ipk >= 0.0 && ipk <= 4.0;
        }
        
        // METHOD UNTUK MENGAMBIL STATUS AKTIF
        public boolean isAktif() {
            return status.equalsIgnoreCase("Aktif");
        }
        
        // METHOD UNTUK MENGAMBIL DATA MAHASISWA
        public void tampilkanData() {
            if (isAktif()) {
                System.out.println("\nDATA MAHASISWA");
                System.out.println("Nama = " + nama);
                System.out.println("NPM = " + npm);
                System.out.println("IPK = " + ipk);
                System.out.println("Tahun Lahir = " + tahunLahir);
                System.out.println("Kode Jenis = " + kodeJenis);
                System.out.println("Jenis Kelamin = " + getJenisKelamin());
                System.out.println("Umur = " + getUmur());
                System.out.println("Tahun Masuk = " + getTahunMasuk());
                System.out.println("Tahun Lulus = " + getTahunLulus());
                System.out.println("Kode Prodi = " + getKodeProdi());
                System.out.println("Program Studi = " + getProdi());
                System.out.println("Nomor Urut = " + getNomorUrut());
                System.out.println("Status Mahasiswa = " + status);
                System.out.println("Predikat Kelulusan = " + getPredikatKelulusan());
            } else {
                System.out.println("Mahasiswa Tidak Aktif, Data Tidak Bisa Ditampilkan");
            }
        }
    }
