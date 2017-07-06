package package1;

import java.sql.Date;

public class Commit {

	private  String commit;
	private Date committime;
	public Commit(String commit) {
		
		this.commit = commit;
	}
	public Commit(String commit, Date committime) {
		super();
		this.commit = commit;
		this.committime = committime;
	}
	public String getCommit() {
		return commit;
	}
	public void setCommit(String commit) {
		this.commit = commit;
	}
	public Date getCommittime() {
		return committime;
	}
	public void setCommittime(Date committime) {
		this.committime = committime;
	}
	
}
