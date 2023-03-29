package mysql;

public class TeachesTable {

	private String SI_ID;
	private int FID;
	private String SUBCODE;
	private int FAcademicYear;
	
	public TeachesTable(String sI_ID, int fID, String sUBCODE, int fAcademicYear) {
		super();
		SI_ID = sI_ID;
		FID = fID;
		SUBCODE = sUBCODE;
		FAcademicYear = fAcademicYear;
	}

	public String getSI_ID() {
		return SI_ID;
	}

	public void setSI_ID(String sI_ID) {
		SI_ID = sI_ID;
	}

	public int getFID() {
		return FID;
	}

	public void setFID(int fID) {
		FID = fID;
	}

	public String getSUBCODE() {
		return SUBCODE;
	}

	public void setSUBCODE(String sUBCODE) {
		SUBCODE = sUBCODE;
	}

	public int getFAcademicYear() {
		return FAcademicYear;
	}

	public void setFAcademicYear(int fAcademicYear) {
		FAcademicYear = fAcademicYear;
	}

	@Override
	public String toString() {
		return "TeachesTable [SI_ID=" + SI_ID + ", FID=" + FID + ", SUBCODE=" + SUBCODE + ", FAcademicYear="
				+ FAcademicYear + "]";
	}

	public TeachesTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
