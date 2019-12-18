package trg.talentsprint.starterkit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import trg.talentsprint.starterkit.model.Test;

@Repository
public interface TestRepository extends CrudRepository<Test, Long>{

}
