package trg.talentsprint.starterkit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import trg.talentsprint.starterkit.model.Ltest;

@Repository
public interface LtestRepository extends CrudRepository<Ltest, Long>{

	Ltest findByTestname(String testname);
}
