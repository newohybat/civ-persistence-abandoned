package cz.muni.fi.civ.newohybat.persistence.dao.iface;

import cz.muni.fi.civ.newohybat.persistence.entities.Action;

public interface ActionDAO extends BaseDAO<Action> {
	Action getByIdent(String ident);
}
