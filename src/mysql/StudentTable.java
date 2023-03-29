package mysql;

public class StudentTable {

private int SID;
private String SFNAME;
private String SLNAME;
private String USN;
private String SPHNO;
private String SCITY;
private String SGENDER;
private String SDOB;
private String SEMAIL;
private String SI_ID;
private String USERNAME;
private String PASSWORD;

public StudentTable(int sID, String sFNAME, String sLNAME, String uSN, String sPHNO, String sCITY, String sGENDER,String sDOB,
		String sEMAIL, String sI_ID, String uSERNAME, String pASSWORD) {
	super();
	SID = sID;
	SFNAME = sFNAME;
	SLNAME = sLNAME;
	USN = uSN;
	SPHNO = sPHNO;
	SCITY = sCITY;
	SGENDER = sGENDER;
	SDOB = sDOB;
	SEMAIL = sEMAIL;
	SI_ID = sI_ID;
	USERNAME = uSERNAME;
	PASSWORD = pASSWORD;
}

public StudentTable(String sFNAME, String sLNAME, String uSN, String sPHNO, String sCITY, String sGENDER,String sDOB, String sEMAIL,
		String sI_ID, String uSERNAME, String pASSWORD) {
	super();
	SFNAME = sFNAME;
	SLNAME = sLNAME;
	USN = uSN;
	SPHNO = sPHNO;
	SCITY = sCITY;
	SGENDER = sGENDER;
	SDOB = sDOB;
	SEMAIL = sEMAIL;
	SI_ID = sI_ID;
	USERNAME = uSERNAME;
	PASSWORD = pASSWORD;
}

public StudentTable(String sFNAME, String sLNAME, String uSN, String sPHNO, String sCITY, String sGENDER, String sDOB,
		String sEMAIL, String sI_ID) {
	super();
	SFNAME = sFNAME;
	SLNAME = sLNAME;
	USN = uSN;
	SPHNO = sPHNO;
	SCITY = sCITY;
	SGENDER = sGENDER;
	SDOB = sDOB;
	SEMAIL = sEMAIL;
	SI_ID = sI_ID;
}



public int getSID() {
	return SID;
}

public void setSID(int sID) {
	SID = sID;
}

public String getSFNAME() {
	return SFNAME;
}

public void setSFNAME(String sFNAME) {
	SFNAME = sFNAME;
}

public String getSLNAME() {
	return SLNAME;
}

public void setSLNAME(String sLNAME) {
	SLNAME = sLNAME;
}

public String getUSN() {
	return USN;
}

public void setUSN(String uSN) {
	USN = uSN;
}

public String getSPHNO() {
	return SPHNO;
}

public void setSPHNO(String sPHNO) {
	SPHNO = sPHNO;
}

public String getSCITY() {
	return SCITY;
}

public String getSDOB() {
	return SDOB;
}

public void setSDOB(String sDOB) {
	SDOB = sDOB;
}

public void setSCITY(String sCITY) {
	SCITY = sCITY;
}

public String getSGENDER() {
	return SGENDER;
}

public void setSGENDER(String sGENDER) {
	SGENDER = sGENDER;
}

public String getSEMAIL() {
	return SEMAIL;
}

public void setSEMAIL(String sEMAIL) {
	SEMAIL = sEMAIL;
}

public String getSI_ID() {
	return SI_ID;
}

public void setSI_ID(String sI_ID) {
	SI_ID = sI_ID;
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

public StudentTable() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "StudentTable [SID=" + SID + ", SFNAME=" + SFNAME + ", SLNAME=" + SLNAME + ", USN=" + USN + ", SPHNO="
			+ SPHNO + ", SCITY=" + SCITY + ", SGENDER=" + SGENDER + ", SEMAIL=" + SEMAIL + ", SI_ID=" + SI_ID
			+ ", USERNAME="
			+ USERNAME + ", PASSWORD=" + PASSWORD + "]";
}




	
}
