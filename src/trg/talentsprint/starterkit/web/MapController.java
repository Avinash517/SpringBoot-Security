package trg.talentsprint.starterkit.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import trg.talentsprint.starterkit.model.Route;
import trg.talentsprint.starterkit.service.RouteService;


@RestController
public class MapController {
	
	@Autowired
    private RouteService rservice;
	
	@ResponseBody
	@RequestMapping(value="/searchinmap",produces=MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
	public List<Route> getAllRoutesBycities(String from,String to,String type){
		System.out.println(from+" "+to+" "+type);
		return rservice.findInfoRoute(from, to, type);
	}

}
