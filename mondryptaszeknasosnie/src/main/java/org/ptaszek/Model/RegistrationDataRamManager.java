package org.ptaszek.Model;

import java.util.List;

import org.ptaszek.Controller.RamMAnager;

public class RegistrationDataRamManager extends RamMAnager<RegistrationData> {
	@Override
	public boolean delete(RegistrationData key) {
		return this.elements.remove(key);
	}

	@Override
	public boolean insert(RegistrationData element) {
		System.out.print("SEKSKSKKSKS");
		return this.elements.add(element);
	};
	@Override


	public boolean update(RegistrationData obj) {
		return false;
	};

	@Override
	public List<RegistrationData> select(){
		return this.elements;
	};
}
