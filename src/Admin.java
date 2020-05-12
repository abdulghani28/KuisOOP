public class Admin extends Peserta implements Tes {

    private int nilaiJaringan;
    protected int nilaiAkhir;

    public Admin(String nim, String nama, int nilaiTulis, int nilaiCoding, int nilaiWawancara, int nilaiJaringan) {
        super(nim, nama, nilaiTulis, nilaiCoding, nilaiWawancara);
        this.nilaiJaringan = nilaiJaringan;
    }

    @Override
    public void hitungNilaiAkhir() {
        this.nilaiAkhir = (super.nilaiTulis + super.nilaiCoding + super.nilaiWawancara + this.nilaiJaringan)/4;
    }
}
