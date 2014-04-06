package cz.muni.fi.civ.newohybat.persistence.services.iface;

import java.util.List;

import cz.muni.fi.civ.newohybat.persistence.entities.Tile;

public interface TileService {
	void create(Tile tile);
	
	void update(Tile tile);
	
	void delete(Tile tile);
	
	Tile getById(Long id);
	
	List<Tile> getAll();
}
