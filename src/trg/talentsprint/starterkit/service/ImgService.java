package trg.talentsprint.starterkit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trg.talentsprint.starterkit.model.Img;
import trg.talentsprint.starterkit.repository.Imgrepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ImgService {

	
	@Autowired
    private Imgrepository repository;
    

    public List<Img> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Img save(Img place) {
        return repository.save(place);
    }

    
}