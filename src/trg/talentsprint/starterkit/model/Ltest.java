package trg.talentsprint.starterkit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ltest {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tid;
	
	private String testname;

	public Ltest() {
		// TODO Auto-generated constructor stub
	}
	
	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public String getTestname() {
		return testname;
	}

	public void setTestname(String testname) {
		this.testname = testname;
	}
	

}
