package cz.muni.fi.civ.newohybat.persistence.services.iface;

import java.util.List;

import cz.muni.fi.civ.newohybat.persistence.entities.Player;

public interface PlayerService {
	void create(Player player);
	
	void update(Player player);
	
	void delete(Player player);
	
	Player getById(Long id);
	
	List<Player> getAll();
}
