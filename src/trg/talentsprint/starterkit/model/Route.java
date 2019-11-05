package trg.talentsprint.starterkit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Route {
	
	
	public Route() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String name;
	private String type;
	private String keywords;
	private String decryption;
	private String routefrom;
	private String routeto;
	private String username;
    
	private String location;
	private String placename;
	private String placeinfo;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPlacename() {
		return placename;
	}
	public void setPlacename(String placename) {
		this.placename = placename;
	}
	public String getPlaceinfo() {
		return placeinfo;
	}
	public void setPlaceinfo(String placeinfo) {
		this.placeinfo = placeinfo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getDecryption() {
		return decryption;
	}
	public void setDecryption(String decryption) {
		this.decryption = decryption;
	}
	public String getRoutefrom() {
		return routefrom;
	}
	public void setRoutefrom(String routefrom) {
		this.routefrom = routefrom;
	}
	public String getRouteto() {
		return routeto;
	}
	public void setRouteto(String routeto) {
		this.routeto = routeto;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}