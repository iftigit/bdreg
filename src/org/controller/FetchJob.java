package org.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.model.JobDAO;
import org.table.JobDTO;

public class FetchJob{

	private String id;
	private String level;
	
	public String fetchJobs(){
		ArrayList<JobDTO> jobList=JobDAO.getSubJobs(Integer.valueOf(id),Integer.valueOf(level), 0);
		String jobs="";
		for(int i=0;i<jobList.size();i++){
			jobs+=jobList.get(i).getJobId()+":"+jobList.get(i).getJobTitle()+";";
		}
		if(!jobs.equals(""))
			jobs=jobs.substring(0, jobs.length()-1);
		else
			jobs="<->";
		 HttpServletResponse response = ServletActionContext.getResponse();
		 try{
	    	 response.setContentType("json");
	    	 response.getWriter().write(jobs);
	          }
	        catch(Exception e) {e.printStackTrace();}
	     
		return null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	
}
