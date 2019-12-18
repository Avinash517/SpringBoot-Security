package trg.talentsprint.starterkit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import trg.talentsprint.starterkit.model.Img;
@Repository
public interface Imgrepository extends CrudRepository<Img,String>{
}
