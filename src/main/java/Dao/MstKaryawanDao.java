package Dao;

import java.util.List;

import entity.MstKaryawan;

public interface MstKaryawanDao {
	public void save(MstKaryawan mstKaryawan);
	public void update(MstKaryawan mstKaryawan);
	public void delete(String nik);
	public List<MstKaryawan> findAll();
	public MstKaryawan findone(String nik);
	public List<MstKaryawan> Search(String search);
	
}
