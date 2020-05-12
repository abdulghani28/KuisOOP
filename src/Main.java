import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int x, jumlahPeserta;
        String back;

        do {
            System.out.println("MENU FORM PENDAFTARAN");
            System.out.println("1. Asisten Laboratorium");
            System.out.println("2. Admin Laboratorium");
            System.out.print("Pilih jenis form : ");
            try {
                x = input.nextInt();
                switch (x) {
                    case 1: {

                        String nama, nim;
                        int nilaiTulis, nilaiCoding, nilaiWawancara, nilaiMicroteaching;
                        System.out.println();
                        System.out.println("FORM PENDAFTARAN ASISTEN LABORATORIUM");
                        System.out.print("Berapa banyak data yang akan diinputkan ? : ");
                        jumlahPeserta = input.nextInt();

                        pilBenar(x, jumlahPeserta);

                        for (int i = 0; i < jumlahPeserta; i++) {
                            System.out.println();
                            System.out.println("Peserta " + (i + 1));
                            System.out.print("Input NIM                       : ");
                            input.nextLine();
                            nim = input.nextLine();
                            System.out.print("Input Nama                      : ");
                            nama = input.nextLine();
                            System.out.print("Input Nilai Tes Tulis           : ");
                            nilaiTulis = input.nextInt();
                            System.out.print("Input Nilai Tes Coding          : ");
                            nilaiCoding = input.nextInt();
                            System.out.print("Input Nilai Tes Wawancara       : ");
                            nilaiWawancara = input.nextInt();
                            System.out.print("Input Nilai Tes Microteaching   : ");
                            nilaiMicroteaching = input.nextInt();

                            noNegatif(nilaiTulis, nilaiCoding, nilaiWawancara, nilaiMicroteaching);

                            Aslab peserta = new Aslab(nim, nama, nilaiTulis, nilaiCoding, nilaiWawancara, nilaiMicroteaching);
                            peserta.hitungNilaiAkhir();
                            System.out.println(" ================== Hasil ================== ");
                            System.out.println(" Nilai Akhir      : " + peserta.nilaiAkhir);
                            if (peserta.nilaiAkhir > 85) {
                                System.out.println(" KETERANGAN       : LOLOS");
                                System.out.println(" Selamat, kepada peserta dengan Nim " + peserta.nim +
                                        " telah diterima sebagai Aslab");
                            } else {
                                System.out.println(" KETERANGAN       : GAGAL");
                                System.out.println(" Mohon maaf, kepada peserta dengan Nim " + peserta.nim +
                                        " telah ditolak sebagai Aslab");
                            }
                            System.out.println();
                        }
                        break;
                    }

                    case 2: {

                        String nama, nim;
                        int nilaiTulis, nilaiCoding, nilaiWawancara, nilaiJaringan;
                        System.out.println();
                        System.out.println("FORM PENDAFTARAN ADMIN LABORATORIUM");
                        System.out.print("Berapa banyak data yang akan diinputkan ? : ");
                        jumlahPeserta = input.nextInt();

                        pilBenar(x, jumlahPeserta);

                        for (int i = 0; i < jumlahPeserta; i++) {
                            System.out.println();
                            System.out.println("Peserta " + (i + 1));
                            System.out.print("Input NIM                       : ");
                            input.nextLine();
                            nim = input.nextLine();
                            System.out.print("Input Nama                      : ");
                            nama = input.nextLine();
                            System.out.print("Input Nilai Tes Tulis           : ");
                            nilaiTulis = input.nextInt();
                            System.out.print("Input Nilai Tes Coding          : ");
                            nilaiCoding = input.nextInt();
                            System.out.print("Input Nilai Tes Wawancara       : ");
                            nilaiWawancara = input.nextInt();
                            System.out.print("Input Nilai Tes Jaringan   : ");
                            nilaiJaringan = input.nextInt();

                            noNegatif(nilaiTulis, nilaiCoding, nilaiWawancara, nilaiJaringan);

                            Admin peserta = new Admin(nim, nama, nilaiTulis, nilaiCoding, nilaiWawancara, nilaiJaringan);
                            peserta.hitungNilaiAkhir();
                            System.out.println(" ================== Hasil ================== ");
                            System.out.println(" Nilai Akhir      : " + peserta.nilaiAkhir);
                            if (peserta.nilaiAkhir > 85) {
                                System.out.println(" KETERANGAN       : LOLOS");
                                System.out.println(" Selamat, kepada peserta dengan Nim " + peserta.nim +
                                        " telah diterima sebagai Admin");
                            } else {
                                System.out.println(" KETERANGAN       : GAGAL");
                                System.out.println(" Mohon maaf, kepada peserta dengan Nim " + peserta.nim +
                                        " telah ditolak sebagai Admin");

                            }
                            System.out.println();
                        }
                        break;
                    }
                    default:
                        System.out.println("Maaf Menu yang Anda Pilih tidak tersedia");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus angka");
            } catch (ArithmeticException err) {
                System.out.println(err.getMessage());
            }
            System.out.print("Kembali ke Menu? Y/T ");
            back = input.next();
            back = back.toLowerCase();
        } while (back.charAt(0) == 'y');
    }

    private static void noNegatif(int nilaiTulis, int nilaiCoding,
                                  int nilaiWawancara, int nilaiKeahlian)
            throws ArithmeticException {
        if (nilaiTulis < 0 || nilaiCoding < 0 || nilaiWawancara < 0 || nilaiKeahlian < 0)
            throw new ArithmeticException("Nilai Tidak Boleh Negatif");
        else if (nilaiTulis > 100 || nilaiCoding > 100 || nilaiWawancara > 100 || nilaiKeahlian > 100)
            throw new ArithmeticException("Nilai Tidak Lebih Dari 100");
    }

    private static void pilBenar(int pil, int jum) throws ArithmeticException {
        if (pil < 0 || jum < 0)
            throw new ArithmeticException("Input Tidak Boleh Negatif");
        else if (jum == 0)
            throw new ArithmeticException("Jumlah Tidak Boleh NOL");
    }

}
