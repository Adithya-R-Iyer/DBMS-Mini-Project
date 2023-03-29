package mysql;

public class FacultyTable {
	
	private int FID;
	private String FFNAME;
	private String FLNAME;
	private String FDESIGNATION;
	private String FSALARY;
	private String FPHNO;
	private String FCITY;
	private String FGENDER;
	private String FDOB;
	private String FEMAIL;
	private int DID;
	private String USERNAME;
	private String PASSWORD;
	private int Join_Year;
	public FacultyTable(int fID, String fFNAME, String fLNAME, String fDESIGNATION, String fSALARY, String fPHNO,
			String fCITY, String fGENDER,String fDOB, String fEMAIL, int dID, String uSERNAME, String pASSWORD,int join_Year) {
		super();
		FID = fID;
		FFNAME = fFNAME;
		FLNAME = fLNAME;
		FDESIGNATION = fDESIGNATION;
		FSALARY = fSALARY;
		FPHNO = fPHNO;
		FCITY = fCITY;
		FGENDER = fGENDER;
		FDOB = fDOB;
		FEMAIL = fEMAIL;
		DID = dID;
		USERNAME = uSERNAME;
		PASSWORD = pASSWORD;
		Join_Year = join_Year;
	}
	public FacultyTable(String fFNAME, String fLNAME, String fDESIGNATION, String fSALARY, String fPHNO, String fCITY,
			String fGENDER,String fDOB, String fEMAIL, int dID, String uSERNAME, String pASSWORD,int join_Year) {
		super();
		FFNAME = fFNAME;
		FLNAME = fLNAME;
		FDESIGNATION = fDESIGNATION;
		FSALARY = fSALARY;
		FPHNO = fPHNO;
		FCITY = fCITY;
		FGENDER = fGENDER;
		FDOB = fDOB;
		FEMAIL = fEMAIL;
		DID = dID;
		USERNAME = uSERNAME;
		PASSWORD = pASSWORD;
		Join_Year = join_Year;
	}
	
	public FacultyTable(int fID, String fFNAME, String fLNAME, String fDESIGNATION, String fSALARY, String fPHNO,
			String fCITY, String fGENDER, String fDOB, String fEMAIL, int dID) {
		super();
		FID = fID;
		FFNAME = fFNAME;
		FLNAME = fLNAME;
		FDESIGNATION = fDESIGNATION;
		FSALARY = fSALARY;
		FPHNO = fPHNO;
		FCITY = fCITY;
		FGENDER = fGENDER;
		FDOB = fDOB;
		FEMAIL = fEMAIL;
		DID = dID;
	}
	
	public int getFID() {
		return FID;
	}
	public void setFID(int fID) {
		FID = fID;
	}
	public String getFFNAME() {
		return FFNAME;
	}
	public void setFFNAME(String fFNAME) {
		FFNAME = fFNAME;
	}
	public String getFLNAME() {
		return FLNAME;
	}
	public void setFLNAME(String fLNAME) {
		FLNAME = fLNAME;
	}
	public String getFDESIGNATION() {
		return FDESIGNATION;
	}
	public void setFDESIGNATION(String fDESIGNATION) {
		FDESIGNATION = fDESIGNATION;
	}
	public String getFSALARY() {
		return FSALARY;
	}
	public void setFSALARY(String fSALARY) {
		FSALARY = fSALARY;
	}
	public String getFPHNO() {
		return FPHNO;
	}
	public void setFPHNO(String fPHNO) {
		FPHNO = fPHNO;
	}
	public String getFCITY() {
		return FCITY;
	}
	public void setFCITY(String fCITY) {
		FCITY = fCITY;
	}
	public String getFGENDER() {
		return FGENDER;
	}
	public void setFGENDER(String fGENDER) {
		FGENDER = fGENDER;
	}
	public String getFDOB() {
		return FDOB;
	}
	public void setFDOB(String fDOB) {
		FDOB = fDOB;
	}
	public String getFEMAIL() {
		return FEMAIL;
	}
	public void setFEMAIL(String fEMAIL) {
		FEMAIL = fEMAIL;
	}
	public int getDID() {
		return DID;
	}
	public void setDID(int dID) {
		DID = dID;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public int getJoin_Year() {
		return Join_Year;
	}
	public void setJoin_Year(int join_Year) {
		Join_Year = join_Year;
	}
	@Override
	public String toString() {
		return "FacultyTable [FID=" + FID + ", FFNAME=" + FFNAME + ", FLNAME=" + FLNAME + ", FDESIGNATION="
				+ FDESIGNATION + ", FSALARY=" + FSALARY + ", FPHNO=" + FPHNO + ", FCITY=" + FCITY + ", FGENDER="
				+ FGENDER + ", FEMAIL=" + FEMAIL + ", DID=" + DID + ", USERNAME=" + USERNAME + ", PASSWORD=" + PASSWORD
				+ ", Join_Year=" + Join_Year + "]";
	}
	public FacultyTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
