package entity;

import java.sql.Date;

public class MstKaryawan {
	private String nik;
	private String namaKaryawan;
	private String jenisKelamin;
	private String noAbsen;
	private String kodePerusahaan;
	Date tanggalMasuk;
	private String noRekening;
	public String getNik() {
		return nik;
	}
	public void setNik(String nik) {
		this.nik = nik;
	}
	public String getNamaKaryawan() {
		return namaKaryawan;
	}
	public void setNamaKaryawan(String namaKaryawan) {
		this.namaKaryawan = namaKaryawan;
	}
	public String getJenisKelamin() {
		return jenisKelamin;
	}
	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
	public String getNoAbsen() {
		return noAbsen;
	}
	public void setNoAbsen(String noAbsen) {
		this.noAbsen = noAbsen;
	}
	public String getKodePerusahaan() {
		return kodePerusahaan;
	}
	public void setKodePerusahaan(String kodePerusahaan) {
		this.kodePerusahaan = kodePerusahaan;
	}
	public Date getTanggalMasuk() {
		return tanggalMasuk;
	}
	public void setTanggalMasuk(Date tanggalMasuk) {
		this.tanggalMasuk = tanggalMasuk;
	}
	public String getNoRekening() {
		return noRekening;
	}
	public void setNoRekening(String noRekening) {
		this.noRekening = noRekening;
	}
	
	
}
