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
public class MstKaryawanDaoImpl implements MstKaryawanDao{

	@Autowired
	private DataSource dataSource;
	
	@Override
	public void save(MstKaryawan mstKaryawan) {
		
		
	}

	@Override
	public void update(MstKaryawan mstKaryawan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String nik) {
		// TODO Auto-generated method stub
		
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
				mstKaryawan.setNik(rs.getString(""));
				mstKaryawan.setNamaKaryawan(rs.getString(""));
				mstKaryawan.setJenisKelamin(rs.getString(""));
				mstKaryawan.setNoAbsen(rs.getString(""));
				mstKaryawan.setKodePerusahaan(rs.getString(""));
				mstKaryawan.setTanggalMasuk(rs.getDate(""));
				mstKaryawan.setNoRekening(rs.getString(""));
				
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MstKaryawan> Search(String search) {
		String query = "select * from Table_Karyawan WHERE NAMA_KARYAWAN LIKE '%"+search+"%'";
		List<MstKaryawan> listKaryawan= new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				MstKaryawan mstKaryawan= new MstKaryawan();

//				mstKaryawan.setnamaKaryawan(rs.getString(""));
//				mstKaryawan.setnik(rs.getString(""));
//				mstKaryawan.setnoRek(rs.getString(""));
//				
//					
//				
//				kodeProject = (rs.getString("kode_customer"));
//				mstProject = mstProjectDao.findOne(namaProject);
//				mstKaryawan.setnamaProject(mstProject);
//
//
//				
//				trHeader.setKodeKaryawan(mstKaryawan);
//				listKaryawan;.add(mstKaryawan);
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
