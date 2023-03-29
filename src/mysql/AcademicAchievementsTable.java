package mysql;

public class AcademicAchievementsTable {

	private String USN;
	private int SNoProj;
	private int SInternShip;
	private int SBACKLOGS;
	
	public AcademicAchievementsTable(String uSN, int sNoProj, int sInternShip, int sBACKLOGS) {
		super();
		USN = uSN;
		SNoProj = sNoProj;
		SInternShip = sInternShip;
		SBACKLOGS = sBACKLOGS;
	}

	public AcademicAchievementsTable(String uSN, int sNoProj, int sInternShip) {
		super();
		USN = uSN;
		SNoProj = sNoProj;
		SInternShip = sInternShip;
	}

	public String getUSN() {
		return USN;
	}

	public void setUSN(String uSN) {
		USN = uSN;
	}

	public int getSNoProj() {
		return SNoProj;
	}

	public void setSNoProj(int sNoProj) {
		SNoProj = sNoProj;
	}

	public int getSInternShip() {
		return SInternShip;
	}

	public void setSInternShip(int sInternShip) {
		SInternShip = sInternShip;
	}

	public int getSBACKLOGS() {
		return SBACKLOGS;
	}

	public void setSBACKLOGS(int sBACKLOGS) {
		SBACKLOGS = sBACKLOGS;
	}

	public AcademicAchievementsTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AcademicAchievementsTable [USN=" + USN + ", SNoProj=" + SNoProj + ", SInternShip=" + SInternShip
				+ ", SBACKLOGS=" + SBACKLOGS + "]";
	}
}
