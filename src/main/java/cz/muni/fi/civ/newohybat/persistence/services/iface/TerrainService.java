package cz.muni.fi.civ.newohybat.persistence.services.iface;

import java.util.List;

import cz.muni.fi.civ.newohybat.persistence.entities.Terrain;

public interface TerrainService {
	void create(Terrain terrain);
	void update(Terrain terrain);
	void delete(Terrain terrain);
	Terrain getById(Long id);
	Terrain getByIdent(String ident);
	
	List<Terrain> getAll();
}
