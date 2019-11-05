package trg.talentsprint.starterkit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import trg.talentsprint.starterkit.model.Route;

public interface RouteRepository extends CrudRepository<Route, Long>{
	@Query("select r from Route r where r.routefrom=?1 or r.routeto=?2 or r.type=?3")
	List<Route> getInforoute(String routefrom,String routeto,String type);
	
	@Query("select r from Route r where r.username=?1")
	List<Route> getInforouteByname(String username);
}