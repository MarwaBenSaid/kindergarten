package tn.esprit.spring.entities;


public class Distance {
	
    private final String srcCode;
    private final String destCode;
    private final int distance;
    
    
	public Distance(String srcCode, String destCode, int distance) {
		this.srcCode = srcCode;
		this.destCode = destCode;
		this.distance = distance;
	}


	public String getSrcCode() {
		return srcCode;
	}


	public String getDestCode() {
		return destCode;
	}


	public int getDistance() {
		return distance;
	}
	
}
