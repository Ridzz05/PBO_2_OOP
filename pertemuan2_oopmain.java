import java.util.Scanner;

public class pertemuan2_oopmain {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        String ulang = "Y";
        
        while (ulang.equalsIgnoreCase("Y")) {
            Mahasiswa mahasiswa = new Mahasiswa();
            
            // INPUT DATA MAHASISWA
            inputDataMahasiswa(mahasiswa);
            
            // TAMPILKAN DATA MAHASISWA
            mahasiswa.tampilkanData();
            
            // TANYA APAKAH INGIN MENGULANG PROGRAM
            System.out.print("\nApakah Anda ingin mengulang program (Y/T)? ");
            ulang = scanner.next();
            scanner.nextLine();
        }
        
        scanner.close();
    }
    
    // METHOD UNTUK MENGAMBIL DATA MAHASISWA
    private static void inputDataMahasiswa(Mahasiswa mahasiswa) {
        // INPUT NAMA
        System.out.print("Masukkan Nama = ");
        mahasiswa.setNama(scanner.nextLine());
        
        // Input NPM
        System.out.print("Masukkan NPM " + mahasiswa.getNama() + " = ");
        mahasiswa.setNpm(scanner.next());
        
        // Input IPK dengan validasi
        inputIpk(mahasiswa);
        
        // Input tahun lahir dengan validasi
        inputTahunLahir(mahasiswa);
        
        // Input kode jenis
        System.out.print("Masukkan Kode Jenis (P/L) = ");
        mahasiswa.setKodeJenis(scanner.next().charAt(0));
        
        // Input status
        System.out.print("Masukkan status mahasiswa (Aktif/Tidak Aktif) = ");
        mahasiswa.setStatus(scanner.next());
    }
    
    // Method to input and validate IPK
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
    
    // Method to input and validate birth year
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
