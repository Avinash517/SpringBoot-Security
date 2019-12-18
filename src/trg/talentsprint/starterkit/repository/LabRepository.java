package trg.talentsprint.starterkit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import trg.talentsprint.starterkit.model.Lab;

@Repository
public interface LabRepository extends CrudRepository<Lab, Long>{

	Lab findByLabname(String labname);

	@Query("Select l from Lab l join Diagnostic d on l.lid=d.lid join Ltest t on t.tid=d.tid where d.tid=?1")
	List<Lab> findlabnamebytid(long tid);
}
