package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.MstKaryawan;
import Dao.MstKaryawanDao;

@Repository("MstKaryawanDao")
public class MstKaryawanDaoImpl implements MstKaryawanDao {

	@Autowired
	private DataSource dataSource;

	@Override
	public void save(MstKaryawan mstKaryawan) {
		String query = "INSERT INTO Table_Karyawan"
				+ "(NIK,Nama_Karyawan ,Jenis_Kelamin ,No_Absen ,Kode_Perusahaan ,Tanggal_Masuk ,No_Rekening )"
				+ "VALUES (?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);

			ps.setString(1, mstKaryawan.getNik());
			ps.setString(2, mstKaryawan.getNamaKaryawan());
			ps.setString(3, mstKaryawan.getJenisKelamin());
			ps.setString(4, mstKaryawan.getNoAbsen());
			ps.setString(5, mstKaryawan.getKodePerusahaan());
			ps.setDate(6, mstKaryawan.getTanggalMasuk());
			ps.setString(7, mstKaryawan.getNoRekening());

			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("Sukses");
			} else {
				System.out.println("Failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void update(MstKaryawan mstKaryawan) {
		String query = "UPDATE Table_Karyawan SET Nama_Karyawan = ? ,Jenis_Kelamin = ? ,No_Absen = ? ,Kode_Perusahaan = ? ,Tanggal_Masuk = ? ,No_Rekening = ? "
				+ " WHERE NIK = ?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, mstKaryawan.getNamaKaryawan());
			ps.setString(2, mstKaryawan.getJenisKelamin());
			ps.setString(3, mstKaryawan.getNoAbsen());
			ps.setString(4, mstKaryawan.getKodePerusahaan());
			ps.setDate(5, mstKaryawan.getTanggalMasuk());
			ps.setString(6, mstKaryawan.getNoRekening());
			ps.setString(7, mstKaryawan.getNik());
			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("Sukses");
			} else {
				System.out.println("Failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void delete(String nik) {
		String query = "DELETE FROM Table_Karyawan WHERE NIK = ?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, nik);
			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("Karyawan Delete with Id = " + nik);

			} else {
				System.out.println("No Karyawan Delete with Id = "
						+ nik);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<MstKaryawan> findAll() {
		String query = "SELECT * FROM Table_Karyawan";
		List<MstKaryawan> listKaryawan = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				MstKaryawan mstKaryawan = new MstKaryawan();
				mstKaryawan.setNik(rs.getString("NIK"));
				mstKaryawan.setNamaKaryawan(rs.getString("Nama_Karyawan"));
				mstKaryawan.setJenisKelamin(rs.getString("Jenis_Kelamin"));
				mstKaryawan.setNoAbsen(rs.getString("No_Absen"));
				mstKaryawan.setKodePerusahaan(rs.getString("Kode_Perusahaan"));
				mstKaryawan.setTanggalMasuk(rs.getDate("Tanggal_Masuk"));
				mstKaryawan.setNoRekening(rs.getString("No_Rekening"));

				listKaryawan.add(mstKaryawan);
				
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listKaryawan;
	}

	@Override
	public MstKaryawan findone(String nik) {
		String query = "SELECT * FROM dbo.Table_Karyawan where NIK = '" + nik+"'";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MstKaryawan mstKaryawan = new MstKaryawan();
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
		mstKaryawan.setNik(rs.getString("NIK"));
		mstKaryawan.setNamaKaryawan(rs.getString("Nama_Karyawan"));
		mstKaryawan.setJenisKelamin(rs.getString("Jenis_Kelamin"));
		mstKaryawan.setNoAbsen(rs.getString("No_Absen"));
		mstKaryawan.setKodePerusahaan(rs.getString("Kode_Perusahaan"));
		mstKaryawan.setTanggalMasuk(rs.getDate("Tanggal_Masuk"));
		mstKaryawan.setNoRekening(rs.getString("No_Rekening"));
		
					
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mstKaryawan;
	}

	@Override
	public List<MstKaryawan> Search(String search) {
		String query = "select * from Table_Karyawan WHERE NAMA_KARYAWAN LIKE '%"
				+ search + "%'";
		List<MstKaryawan> listKaryawan = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				MstKaryawan mstKaryawan = new MstKaryawan();

				// mstKaryawan.setnamaKaryawan(rs.getString(""));
				// mstKaryawan.setnik(rs.getString(""));
				// mstKaryawan.setnoRek(rs.getString(""));
				//
				//
				//
				// kodeProject = (rs.getString("kode_customer"));
				// mstProject = mstProjectDao.findOne(namaProject);
				// mstKaryawan.setnamaProject(mstProject);
				//
				//
				//
				// trHeader.setKodeKaryawan(mstKaryawan);
				// listKaryawan;.add(mstKaryawan);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return listKaryawan;
	}

}
