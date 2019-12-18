package trg.talentsprint.starterkit.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Favplace {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fid;
	
	private long rid;
	private String username;
	
	public Favplace() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return fid;
	}
	public void setId(Long fid) {
		this.fid = fid;
	}
	public long getRid() {
		return rid;
	}
	public void setRid(long rid) {
		this.rid = rid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
