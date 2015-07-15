package com.dmac.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "analysis")
public class Analysis {

	private int 			id;	 
	
	private int 			projectID;
		
	private Date 			timeOfAnalysis			=	null;
	
	private String			analysisName			= 	"";
	
	private String			analysisResult			=	"";

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "project_id")
	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	@Column(name = "time_of_analysis")
	public Date getTimeOfAnalysis() {
		return timeOfAnalysis;
	}

	public void setTimeOfAnalysis(Date timeOfAnalysis) {
		this.timeOfAnalysis = timeOfAnalysis;
	}

	@Column(name = "analysis_name")
	public String getAnalysisName() {
		return analysisName;
	}

	public void setAnalysisName(String analysisName) {
		this.analysisName = analysisName;
	}

	@Column(name = "analysis_result")
	public String getAnalysisResult() {
		return analysisResult;
	}

	public void setAnalysisResult(String analysisResult) {
		this.analysisResult = analysisResult;
	}
	
	
	
	
	
}
