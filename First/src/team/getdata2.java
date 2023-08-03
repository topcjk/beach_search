package team;

public class getdata2 {
	
	private String facility;
	private String congestion;
	private String transport;
	private int rate;
	private String review;
	
	public getdata2() {}
	public getdata2(String facility,String congestion
			,String transport,String review) {
		super();
		this.facility = facility ;
		this.congestion=congestion;
		this.transport=transport;
		this.review=review;
		
	}
	
	public String getFacility() {
		return facility;
	}
	public String getCongestion() {
		return congestion;
	}
	public String getTransport() {
		return transport;
	}

	public String getReview() {
		return review;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	public void setCongestion(String congestion) {
		this.congestion = congestion;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	public void setReview(String review) {
		this.review = review;
	}


	
	
	
	
	
	
}
