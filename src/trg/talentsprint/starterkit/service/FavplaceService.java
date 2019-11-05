package trg.talentsprint.starterkit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trg.talentsprint.starterkit.model.Favplace;

import trg.talentsprint.starterkit.repository.FavplaceRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FavplaceService {

	
	@Autowired
    private FavplaceRepository repository;
    

    public List<Favplace> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<Favplace> findById(Long id) {
        return repository.findById(id);
    }

    public Favplace save(Favplace place) {
        return repository.save(place);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
}