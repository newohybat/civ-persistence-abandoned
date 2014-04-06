package cz.muni.fi.civ.newohybat.persistence.services.iface;

import cz.muni.fi.civ.newohybat.persistence.entities.Government;

public interface GovernmentService {
	void create(Government government);
	
	void update(Government government);
	
	void delete(Government government);
	
	Government getById(Long id);
	
	Government getByIdent(String ident);
}
