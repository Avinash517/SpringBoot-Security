package trg.talentsprint.starterkit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import trg.talentsprint.starterkit.model.Favplace;

public interface FavplaceRepository extends CrudRepository<Favplace, Long>{
	
	@Query("select r.name,r.keywords,r.decryption,r.location,r.placeinfo,r.placename,"
			+ "r.routefrom,r.routeto,r.type from Favplace f inner join Route r"
			+ " on r.username=f.username where f.username=?1")
	List<Favplace> findinfoByUsername(String username);
}
