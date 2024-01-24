package org.ptaszek.Controller;

import java.util.ArrayList;
import java.util.List;

import org.ptaszek.Model.StorageManager;

public class RamMAnager<T> implements StorageManager<T> {
	public ArrayList<T> elements = new ArrayList<>();

	@Override
	public boolean delete(T key) {
		return false;
	}

	@Override
	public boolean insert(T element) {
		return false;
	};
	@Override


	public boolean update(T obj){
		return false;
	};

	@Override
	public List<T> select(){
		return null;
	};
}
