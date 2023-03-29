package mysql;

public class FeedbackTable {

	private String SI_ID;
	private int FID;
	private String SUBCODE;
	private String USN;
	private String Punctuality;
	private String Regularity;
	private String Communication;
	private String Confidence;
	private int Rating;
	private String Review;
	
	public FeedbackTable(String sI_ID, int fID, String sUBCODE, String uSN, String punctuality, String regularity,
			String communication, String confidence, int rating, String review) {
		super();
		SI_ID = sI_ID;
		FID = fID;
		SUBCODE = sUBCODE;
		USN = uSN;
		Punctuality = punctuality;
		Regularity = regularity;
		Communication = communication;
		Confidence = confidence;
		Rating = rating;
		Review = review;
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

	public String getUSN() {
		return USN;
	}

	public void setUSN(String uSN) {
		USN = uSN;
	}

	public String getPunctuality() {
		return Punctuality;
	}

	public void setPunctuality(String punctuality) {
		Punctuality = punctuality;
	}

	public String getRegularity() {
		return Regularity;
	}

	public void setRegularity(String regularity) {
		Regularity = regularity;
	}

	public String getCommunication() {
		return Communication;
	}

	public void setCommunication(String communication) {
		Communication = communication;
	}

	public String getConfidence() {
		return Confidence;
	}

	public void setConfidence(String confidence) {
		Confidence = confidence;
	}

	public int getRating() {
		return Rating;
	}

	public void setRating(int rating) {
		Rating = rating;
	}

	public String getReview() {
		return Review;
	}

	public void setReview(String review) {
		Review = review;
	}

	@Override
	public String toString() {
		return "FeedbackTable [SI_ID=" + SI_ID + ", FID=" + FID + ", SUBCODE=" + SUBCODE + ", USN=" + USN
				+ ", Punctuality=" + Punctuality + ", Regularity=" + Regularity + ", Communication=" + Communication
				+ ", Confidence=" + Confidence + ", Rating=" + Rating + ", Review=" + Review + "]";
	}

	public FeedbackTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
