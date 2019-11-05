package trg.talentsprint.starterkit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trg.talentsprint.starterkit.model.Route;
import trg.talentsprint.starterkit.repository.RouteRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RouteService {

    private RouteRepository repository;

    
    @Autowired
    public RouteService(RouteRepository repository) {
        this.repository = repository;
    }

    public List<Route> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<Route> findById(Long id) {
        return repository.findById(id);
    }

    public Route save(Route route) {
        return repository.save(route);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
    public List<Route> findInfoRoute(String routefrom,String routeto,String type)
    {
    	return repository.getInforoute(routefrom, routeto, type);
    }
    
    public List<Route> findInfoRouteByname(String username)
    {
    	return repository.getInforouteByname(username);
    }
    
}