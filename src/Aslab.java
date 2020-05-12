public class Aslab extends Peserta implements Tes {
    private double nilaiJaringan;
    protected double nilaiAkhir;

    public Aslab(String nim, String nama, int nilaiTulis, int nilaiCoding, int nilaiWawancara, int nilaiJaringan) {
        super(nim, nama, nilaiTulis, nilaiCoding, nilaiWawancara);
        this.nilaiJaringan = nilaiJaringan;
    }

    public void hitungNilaiAkhir() {
        this.nilaiAkhir = (super.nilaiTulis + super.nilaiCoding + super.nilaiWawancara + this.nilaiJaringan)/4;
    }
}
