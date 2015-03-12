package com.rs.springredis.data;

import java.util.List;

public class Student {
	public String FNAME;
	public String LNAME;
	public String MAJOR;
	public String MINOR;
	public String ADVISOR;
	public List<String> SEMESTER;
	public List<List<String>> COURSE_NBR;
	public List<List<String>> COURSE_GRD;

	// setter & getter for SpringMVC
	public String getFNAME() {
		return FNAME;
	}

	public void setFNAME(String fNAME) {
		FNAME = fNAME;
	}

	public String getLNAME() {
		return LNAME;
	}

	public void setLNAME(String lNAME) {
		LNAME = lNAME;
	}

	public String getMAJOR() {
		return MAJOR;
	}

	public void setMAJOR(String mAJOR) {
		MAJOR = mAJOR;
	}

	public String getMINOR() {
		return MINOR;
	}

	public void setMINOR(String mINOR) {
		MINOR = mINOR;
	}

	public String getADVISOR() {
		return ADVISOR;
	}

	public void setADVISOR(String aDVISOR) {
		ADVISOR = aDVISOR;
	}

	public List<String> getSEMESTER() {
		return SEMESTER;
	}

	public void setSEMESTER(List<String> sEMESTER) {
		SEMESTER = sEMESTER;
	}

	public List<List<String>> getCOURSE_NBR() {
		return COURSE_NBR;
	}

	public void setCOURSE_NBR(List<List<String>> cOURSE_NBR) {
		COURSE_NBR = cOURSE_NBR;
	}

	public List<List<String>> getCOURSE_GRD() {
		return COURSE_GRD;
	}

	public void setCOURSE_GRD(List<List<String>> cOURSE_GRD) {
		COURSE_GRD = cOURSE_GRD;
	}
	
	@Override
	public String toString() {
		String description = "Student {FNAME=" + FNAME + ", LNAME=" + LNAME
				+ ", MAJOR=" + MAJOR + ", MINOR=" + MINOR + ", ADVISOR="
				+ ADVISOR;

		description += outputSEMESTER();
		description += outputCOURSE_NBR();
		description += outputCOURSE_GRD();
		description += "}";
		return description;
	}

	public String outputSEMESTER() {
		String description = ", SEMESTER=" + listToString(SEMESTER);
		return description;
	}

	public String outputCOURSE_NBR() {

		String description = ", COURSE_NBR=" + multiListToString(COURSE_NBR);
		return description;
	}

	public String outputCOURSE_GRD() {
		String description = ", COURSE_GRD=" + multiListToString(COURSE_GRD);
		return description;
	}
	
	public String multiListToString(List<List<String>> mlist) {
		boolean firstElement = true;
		String description = "[";
		for (List<String> list : mlist) {
			if (firstElement == true) {
				description += listToString(list);
				firstElement = false;
			} else {
				description += ", " + listToString(list);
			}
		}
		description += "]";
		return description;
	}

	public String listToString(List<String> list) {
		boolean firstElement = true;
		String description = "[";
		for (String token : list) {
			if (firstElement == true) {
				description += token;
				firstElement = false;
			} else {
				description += ", " + token;
			}
		}
		description += "]";

		return description;
	}
}
