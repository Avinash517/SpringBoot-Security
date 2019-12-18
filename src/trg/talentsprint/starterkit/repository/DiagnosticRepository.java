package trg.talentsprint.starterkit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import trg.talentsprint.starterkit.model.Diagnostic;

@Repository
public interface DiagnosticRepository extends CrudRepository<Diagnostic, Long> {

}
