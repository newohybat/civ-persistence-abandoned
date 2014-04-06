package cz.muni.fi.civ.newohybat.persistence.services.iface;

import cz.muni.fi.civ.newohybat.persistence.entities.Action;

public interface ActionService {

	void create(Action action);
	
	void update(Action action);
	
	void delete(Action action);
	
	Action getById(Long id);
	
	Action getByIdent(String ident);
}
