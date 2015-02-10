package org.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;
import org.model.JobDAO;
import org.table.JobDTO;
import org.table.JobseekerDTO;
import org.table.RegCountDTO;

import com.opensymphony.xwork2.ActionSupport;

public class RegistrationStat extends ActionSupport implements ServletContextAware{
	
	private static final long serialVersionUID = -7546229642641652565L;
	ArrayList<JobDTO> mainJobList=new ArrayList<JobDTO>();
	private String mainJob;
	private String subJob;
	private String subSubJob;
	private String gender;
	List<JobseekerDTO> jobseekerList = new ArrayList<JobseekerDTO>();
	
	public String regStatHome(){
		mainJobList=JobDAO.getAllJob(1, 0);
		return SUCCESS;
	}

	public String fetchRegStat()
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		RegCountDTO countDTO=JobDAO.getRegCount(mainJob, subJob, subSubJob);
		String resp="<div class='panel panel-default'> " +
						" <div class='panel-heading'> " +
						" <h3 class='panel-title'>Jobseeker Count</h3> " +
						" <span class='pull-right clickable'><i class='glyphicon glyphicon-chevron-up'></i></span> " +
						" </div>"+
						" <div class='panel-body'> " +
						" <p class='text-warning' style='font-size: 1.75em; line-height: 1em; margin-bottom: 0px;float:left;'>" +
						" <img src='/BDREG_WEB/resources/images/male.png' />" +
						countDTO.getMaleCount()+" <br/><a href='#' class='btn btn-default' style='width: 115px;' onclick='fetchJobseekerList(\"MALE\")'>Show All (<b>M</b>)</a>" +
						" </p>" +
						" <p class='text-info' style='font-size: 1.75em; line-height: 1em; margin-bottom: 0px;float:left;margin-left:100px;'>" +
						" <img src='/BDREG_WEB/resources/images/female.png' />" +
						countDTO.getFemaleCount()+"<br/><a href='#' class='btn btn-default' style='width: 115px;' onclick='fetchJobseekerList(\"FEMALE\")'>Show All (<b>F</b>)</a>" +
						" </p>" +
						" <p class='text-danger' style='font-size: 1.75em; line-height: 1em; margin-bottom: 0px;float:left;margin-left:100px;'>" +
						" <img src='/BDREG_WEB/resources/images/all1.png' />" +
						countDTO.getTotalCount()+"<br/><a href='#' class='btn btn-default' style='width: 115px;' onclick='fetchJobseekerList(\"ALL\")'>Show All</a>" +
						" </p>" +
						" <div class='clearfix'></div> " +
						" </div> "+
						" </div>";
	     try{
	    	 response.setContentType("text/html");
	    	 response.getWriter().write(resp);
	          }
	        catch(Exception e) {e.printStackTrace();}
		return null;
	}
	public String fetchJobseekerList(){
		 return SUCCESS;
	}
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		
	}
	public ArrayList<JobDTO> getMainJobList() {
		return mainJobList;
	}
	public void setMainJobList(ArrayList<JobDTO> mainJobList) {
		this.mainJobList = mainJobList;
	}
	public String getMainJob() {
		return mainJob;
	}
	public void setMainJob(String mainJob) {
		this.mainJob = mainJob;
	}
	public String getSubJob() {
		return subJob;
	}
	public void setSubJob(String subJob) {
		this.subJob = subJob;
	}
	public String getSubSubJob() {
		return subSubJob;
	}
	public void setSubSubJob(String subSubJob) {
		this.subSubJob = subSubJob;
	}

	public List<JobseekerDTO> getJobseekerList() {
		return jobseekerList;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setJobseekerList(List<JobseekerDTO> jobseekerList) {
		this.jobseekerList = jobseekerList;
	}
	

}
