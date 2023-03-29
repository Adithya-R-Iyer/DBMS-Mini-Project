package mysql;

public class GPATable {

	String USN;
	int sem;
	double SGPA;
	
	public GPATable(String uSN, int sem, double sGPA) {
		super();
		USN = uSN;
		this.sem = sem;
		SGPA = sGPA;
	}

	public GPATable(String uSN, int sem) {
		super();
		USN = uSN;
		this.sem = sem;
	}

	public GPATable(String uSN) {
		super();
		USN = uSN;
	}

	public String getUSN() {
		return USN;
	}

	public void setUSN(String uSN) {
		USN = uSN;
	}

	public int getSem() {
		return sem;
	}

	public void setSem(int sem) {
		this.sem = sem;
	}

	public double getSGPA() {
		return SGPA;
	}

	public void setSGPA(double sGPA) {
		SGPA = sGPA;
	}

	public GPATable() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GPATable [USN=" + USN + ", sem=" + sem + ", SGPA=" + SGPA + "]";
	}
}
