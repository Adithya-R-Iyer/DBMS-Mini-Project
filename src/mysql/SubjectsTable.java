package mysql;

public class SubjectsTable {
	
	private String SUBCODE;
	private String SNAME;
	private int DID;
	private int SCHEME;
	private int SCREDITS;
	private int SEM;
	
	public SubjectsTable(String sUBCODE, String sNAME, int dID, int sCHEME, int sCREDITS, int sEM) {
		super();
		SUBCODE = sUBCODE;
		SNAME = sNAME;
		DID = dID;
		SCHEME = sCHEME;
		SCREDITS = sCREDITS;
		SEM = sEM;
	}

	public SubjectsTable(String sNAME, int dID, int sCHEME, int sCREDITS, int sEM) {
		super();
		SNAME = sNAME;
		DID = dID;
		SCHEME = sCHEME;
		SCREDITS = sCREDITS;
		SEM = sEM;
	}

	public String getSUBCODE() {
		return SUBCODE;
	}

	public void setSUBCODE(String sUBCODE) {
		SUBCODE = sUBCODE;
	}

	public String getSNAME() {
		return SNAME;
	}

	public void setSNAME(String sNAME) {
		SNAME = sNAME;
	}

	public int getDID() {
		return DID;
	}

	public void setDID(int dID) {
		DID = dID;
	}

	public int getSCHEME() {
		return SCHEME;
	}

	public void setSCHEME(int sCHEME) {
		SCHEME = sCHEME;
	}

	public int getSCREDITS() {
		return SCREDITS;
	}

	public void setSCREDITS(int sCREDITS) {
		SCREDITS = sCREDITS;
	}

	public int getSEM() {
		return SEM;
	}

	public void setSEM(int sEM) {
		SEM = sEM;
	}

	public SubjectsTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SubjectsTable [SUBCODE=" + SUBCODE + ", SNAME=" + SNAME + ", DID=" + DID + ", SCHEME=" + SCHEME
				+ ", SCREDITS=" + SCREDITS + ", SEM=" + SEM + "]";
	}
	
	
	
}
