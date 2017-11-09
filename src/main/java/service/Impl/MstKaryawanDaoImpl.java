package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.MstKaryawan;
import Dao.MstKaryawanDao;

@Service("MstKaryawanSvc")
public class MstKaryawanDaoImpl implements MstKaryawanDao{

	@Autowired
	private MstKaryawanDao mstKaryawanDao;
	
	@Override
	public void save(MstKaryawan mstKaryawan) {
		mstKaryawanDao.save(mstKaryawan);
		
	}

	@Override
	public void update(MstKaryawan mstKaryawan) {
		mstKaryawanDao.update(mstKaryawan);
		
	}

	@Override
	public void delete(String nik) {
		mstKaryawanDao.delete(nik);
		
	}

	@Override
	public List<MstKaryawan> findAll() {
		
		return mstKaryawanDao.findAll();
	}

	@Override
	public MstKaryawan findone(String nik) {
		
		return mstKaryawanDao.findone(nik);
	}

	@Override
	public List<MstKaryawan> Search(String search) {
		
		return mstKaryawanDao.Search(search);
	}

}
