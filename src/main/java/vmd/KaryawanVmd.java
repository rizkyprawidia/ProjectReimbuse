package vmd;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import entity.MstKaryawan;
import service.MstKaryawanSvc;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class KaryawanVmd {

	@WireVariable
	private MstKaryawanSvc mstKaryawanSvc;
	private MstKaryawan mstKaryawan;
	
	private List<MstKaryawan> listKaryawan = new ArrayList<>();
	private String search;
	public MstKaryawanSvc getMstKaryawanSvc() {
		return mstKaryawanSvc;
	}
	public void setMstKaryawanSvc(MstKaryawanSvc mstKaryawanSvc) {
		this.mstKaryawanSvc = mstKaryawanSvc;
	}
	public MstKaryawan getMstKaryawan() {
		return mstKaryawan;
	}
	public void setMstKaryawan(MstKaryawan mstKaryawan) {
		this.mstKaryawan = mstKaryawan;
	}
	public List<MstKaryawan> getListKaryawan() {
		return listKaryawan;
	}
	public void setListKaryawan(List<MstKaryawan> listKaryawan) {
		this.listKaryawan = listKaryawan;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	@Init
		public void load(){
		listKaryawan = mstKaryawanSvc.findAll();
	}
	
	@Command("search")
	@NotifyChange("listKaryawan")
	public void search() {
		listKaryawan.clear();
		listKaryawan = mstKaryawanSvc.Search(search);
	}
	
	
	
}
