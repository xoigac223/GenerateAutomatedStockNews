package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import maucau.iMauCau;

public class Tag {
	
	private String nameTag;
	private List<iMauCau> listMauCau;
	private int heSoRandom;
	
	public Tag(String nameTag, int heSoRandom) {
		this.nameTag = nameTag;
		this.heSoRandom = heSoRandom;
		listMauCau = new ArrayList<iMauCau>();
	}

	
	public String getNameTag() {
		return nameTag;
	}

	public void setNameTag(String nameTag) {
		this.nameTag = nameTag;
	}
	
	public int getHeSoRandom() {
		return heSoRandom;
	}
	
	public void setHeSoRandom(int heSoRandom) {
		this.heSoRandom = heSoRandom;
	}
	public List<iMauCau> getListMauCau() {
		return listMauCau;
	}

	
	public void add(iMauCau mauCau) {
		listMauCau.add(mauCau);
	}
	
	public int getSize() {
		return listMauCau.size();
	}
	
	public Set<String> sinhDoanVan () {
		Set<String> doanVan = new LinkedHashSet<String>();
		if (heSoRandom!=0) {
			Collections.shuffle(listMauCau);
			for (int i = 0; i < heSoRandom;i++) {
				doanVan.add(listMauCau.get(i).sinhCau() + "\n");
			}
		} else {
			for (int i = 0; i < getSize();i++) {
				doanVan.add(listMauCau.get(i).sinhCau() + "\n");
				}
			}
		return doanVan;
	}
}
