package cz.muni.fi.civ.newohybat.persistence.dao.impl;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.TileDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Tile;

public class TileDAOImpl extends BaseDAOImpl<Tile> implements TileDAO {
	@Override
    protected boolean isValid(Tile object) {
		return object.getImprovements()!=null
				&& object.getPosX()!=null
				&& object.getPosY()!=null
				&& object.getTerrain()!=null
				&& object.getUnits()!=null;
    }


}
