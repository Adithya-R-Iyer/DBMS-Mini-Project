package mysql;

public class IAMarksTable {

	private String USN;
	private String SUBCODE;
	private int IA1;
	private int IA2;
	private int IA3;
	private int AssgnMrks;
	private int FinalIA;
	private int SEE;
	private int TotalMrks;
	private int Attendance;
	private String Review;
	
	public IAMarksTable(String uSN, String sUBCODE, int iA1, int iA2, int iA3, int assgnMrks, int finalIA, int sEE,
			int totalMrks, int attendance, String review) {
		super();
		USN = uSN;
		SUBCODE = sUBCODE;
		IA1 = iA1;
		IA2 = iA2;
		IA3 = iA3;
		AssgnMrks = assgnMrks;
		FinalIA = finalIA;
		SEE = sEE;
		TotalMrks = totalMrks;
		Attendance = attendance;
		Review = review;
	}
	
	
	
	public IAMarksTable(String uSN, String sUBCODE, int iA1, int iA2, int iA3, int assgnMrks, int finalIA,
			String review) {
		super();
		USN = uSN;
		SUBCODE = sUBCODE;
		IA1 = iA1;
		IA2 = iA2;
		IA3 = iA3;
		AssgnMrks = assgnMrks;
		FinalIA = finalIA;
		Review = review;
	}



	public IAMarksTable(int iA1, int iA2, int iA3, int assgnMrks, int finalIA, String review) {
		super();
		IA1 = iA1;
		IA2 = iA2;
		IA3 = iA3;
		AssgnMrks = assgnMrks;
		FinalIA = finalIA;
		Review = review;
	}

	public IAMarksTable(String uSN, String sUBCODE) {
		super();
		USN = uSN;
		SUBCODE = sUBCODE;
	}

	public String getUSN() {
		return USN;
	}
	public void setUSN(String uSN) {
		USN = uSN;
	}
	public String getSUBCODE() {
		return SUBCODE;
	}
	public void setSUBCODE(String sUBCODE) {
		SUBCODE = sUBCODE;
	}
	public int getIA1() {
		return IA1;
	}
	public void setIA1(int iA1) {
		IA1 = iA1;
	}
	public int getIA2() {
		return IA2;
	}
	public void setIA2(int iA2) {
		IA2 = iA2;
	}
	public int getIA3() {
		return IA3;
	}
	public void setIA3(int iA3) {
		IA3 = iA3;
	}
	public int getAssgnMrks() {
		return AssgnMrks;
	}
	public void setAssgnMrks(int assgnMrks) {
		AssgnMrks = assgnMrks;
	}
	public int getFinalIA() {
		return FinalIA;
	}
	public void setFinalIA(int finalIA) {
		FinalIA = finalIA;
	}
	public int getSEE() {
		return SEE;
	}
	public void setSEE(int sEE) {
		SEE = sEE;
	}
	public int getTotalMrks() {
		return TotalMrks;
	}
	public void setTotalMrks(int totalMrks) {
		TotalMrks = totalMrks;
	}
	public int getAttendance() {
		return Attendance;
	}
	public void setAttendance(int attendance) {
		Attendance = attendance;
	}
	public String getReview() {
		return Review;
	}
	public void setReview(String review) {
		Review = review;
	}

	public IAMarksTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "IAMarksTable [USN=" + USN + ", SUBCODE=" + SUBCODE + ", IA1=" + IA1 + ", IA2=" + IA2 + ", IA3=" + IA3
				+ ", AssgnMrks=" + AssgnMrks + ", FinalIA=" + FinalIA + ", SEE=" + SEE + ", TotalMrks=" + TotalMrks
				+ ", Attendance=" + Attendance + ", Review=" + Review + "]";
	}
	
	
	
}
