package trg.talentsprint.starterkit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Diagnostic {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long did;
	
	private long lid;
	private long tid;
	
	public Diagnostic() {
		// TODO Auto-generated constructor stub
	}
	
	public long getDid() {
		return did;
	}
	public void setDid(long did) {
		this.did = did;
	}
	public long getLid() {
		return lid;
	}
	public void setLid(long lid) {
		this.lid = lid;
	}
	public long getTid() {
		return tid;
	}
	public void setTid(long tid) {
		this.tid = tid;
	}

}
