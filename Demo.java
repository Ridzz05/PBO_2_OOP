import java.util.Scanner;
import java.util.ArrayList;

public class Demo {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        String ulang = "Y"; // variabel untuk nampung jawaban apakah ingin mengulang program
        
        while (ulang.equalsIgnoreCase("Y")) {
            // Input banyak mahasiswa
            int banyakMahasiswa = inputBanyakMahasiswa();
            
            // Array untuk menyimpan data mahasiswa
            ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
            
            // Input data untuk setiap mahasiswa
            for (int i = 0; i < banyakMahasiswa; i++) {
                System.out.println("\nMenginput Data Mahasiswa Ke-" + (i + 1));
                Mahasiswa mahasiswa = new Mahasiswa();
                
                // Input data mahasiswa
                inputDataMahasiswa(mahasiswa);
                
                // Tambahkan mahasiswa ke daftar
                daftarMahasiswa.add(mahasiswa);
            }
            
            // Tampilkan data semua mahasiswa
            tampilkanSemuaDataMahasiswa(daftarMahasiswa);
            
            // Tanya apakah ingin mengulang program
            System.out.print("\nApakah Anda ingin mengulang program (Y/T)? ");
            ulang = scanner.next();
            scanner.nextLine();
        }
        
        scanner.close();
    }
    
    // METHOD UNTUK INPUT BANYAK MAHASISWA
    private static int inputBanyakMahasiswa() {
        int banyak = 0;
        boolean valid = false;
        
        while (!valid) {
            try {
                System.out.print("Masukkan banyak mahasiswa yang akan diinput: ");
                banyak = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                if (banyak > 0) {
                    valid = true;
                } else {
                    System.out.println("Banyak mahasiswa harus lebih dari 0!");
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid! Masukkan angka yang benar.");
                scanner.nextLine(); // consume invalid input
            }
        }
        
        return banyak;
    }
    
    // METHOD UNTUK MENAMPILKAN SEMUA DATA MAHASISWA
    private static void tampilkanSemuaDataMahasiswa(ArrayList<Mahasiswa> daftarMahasiswa) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("DAFTAR SEMUA MAHASISWA");
        System.out.println("=".repeat(50));
        
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            System.out.println("\n--- MAHASISWA KE-" + (i + 1) + " ---");
            daftarMahasiswa.get(i).tampilkanData();
            
            if (i < daftarMahasiswa.size() - 1) {
                System.out.println("\n" + "-".repeat(30));
            }
        }
        
        // Tampilkan statistik
        tampilkanStatistik(daftarMahasiswa);
    }
    
    // METHOD UNTUK MENAMPILKAN STATISTIK
    private static void tampilkanStatistik(ArrayList<Mahasiswa> daftarMahasiswa) {
        int totalMahasiswa = daftarMahasiswa.size();
        int mahasiswaAktif = 0;
        int mahasiswaTidakAktif = 0;
        int lakiLaki = 0;
        int perempuan = 0;
        float totalIpk = 0;
        int mahasiswaDenganIpk = 0;
        
        for (Mahasiswa m : daftarMahasiswa) {
            if (m.isAktif()) {
                mahasiswaAktif++;
                totalIpk += m.getIpk();
                mahasiswaDenganIpk++;
            } else {
                mahasiswaTidakAktif++;
            }
            
            if (m.getKodeJenis() == 'L' || m.getKodeJenis() == 'l') {
                lakiLaki++;
            } else if (m.getKodeJenis() == 'P' || m.getKodeJenis() == 'p') {
                perempuan++;
            }
        }
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("STATISTIK MAHASISWA");
        System.out.println("=".repeat(50));
        System.out.println("Total Mahasiswa: " + totalMahasiswa);
        System.out.println("Mahasiswa Aktif: " + mahasiswaAktif);
        System.out.println("Mahasiswa Tidak Aktif: " + mahasiswaTidakAktif);
        System.out.println("Laki-laki: " + lakiLaki);
        System.out.println("Perempuan: " + perempuan);
        
        if (mahasiswaDenganIpk > 0) {
            float rataRataIpk = totalIpk / mahasiswaDenganIpk;
            System.out.printf("Rata-rata IPK Mahasiswa Aktif: %.2f\n", rataRataIpk);
        }
    }
        
        // METHOD UNTUK MENGAMBIL DATA MAHASISWA
        private static void inputDataMahasiswa(Mahasiswa mahasiswa) {
            // INPUT NAMA
            System.out.print("Masukkan Nama = ");
            mahasiswa.setNama(scanner.nextLine());
            
            // Input NPM mahasiswa
            System.out.print("Masukkan NPM " + mahasiswa.getNama() + " = ");
            mahasiswa.setNpm(scanner.next());
            
            // Input IPK mahasiswa dengan validasi
            inputIpk(mahasiswa);
            
            // Input tahun lahir mahasiswa dengan validasi
            inputTahunLahir(mahasiswa);
            
            // Input kode jenis mahasiswa
            System.out.print("Masukkan Kode Jenis (P/L) = ");
            mahasiswa.setKodeJenis(scanner.next().charAt(0));
            
            // Input status mahasiswa
            System.out.print("Masukkan status mahasiswa (Aktif/Tidak) = ");
            mahasiswa.setStatus(scanner.next());
            scanner.nextLine(); // consume newline character
        }
        
        // Method untuk input dan validasi IPK
        private static void inputIpk(Mahasiswa mahasiswa) {
            boolean validIPK = false;
            while (!validIPK) {
                try {
                    System.out.print("Masukkan IPK " + mahasiswa.getNama() + " = ");
                    float ipk = scanner.nextFloat();
                    mahasiswa.setIpk(ipk);
                    
                    if (!mahasiswa.isValidIpk()) {
                        System.out.println("IPK tidak valid - ulang input IPK");
                    } else {
                        validIPK = true;
                    }
                } catch (Exception e) {
                    System.out.println("Input IPK tidak valid!");
                    scanner.next();
                }
            }
        }
        
        // Method untuk input dan validasi tahun lahir
        private static void inputTahunLahir(Mahasiswa mahasiswa) {
            boolean validTahunLahir = false;
            while (!validTahunLahir) {
                try {
                    System.out.print("Masukkan Tahun Lahir " + mahasiswa.getNama() + " = ");
                    int tahunLahir = scanner.nextInt();
                    mahasiswa.setTahunLahir(tahunLahir);
                    validTahunLahir = true;
                } catch (Exception e) {
                    System.out.println("Periksa kembali tahun lahir!");
                    scanner.next();
                }
            }
        }
    }
