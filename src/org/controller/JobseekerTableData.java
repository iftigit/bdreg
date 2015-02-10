package org.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.json.simple.JSONObject;
import org.model.JobDAO;
import org.table.JobseekerDTO;

import com.opensymphony.xwork2.ActionSupport;

public class JobseekerTableData extends ActionSupport implements ServletRequestAware, ServletContextAware, SessionAware {
	
	private static final long serialVersionUID = -7546229642641652565L;
	  private String mainJob;
	  private String subJob;
	  private String subSubJob;
	  private String gender;
		
	  private int iDisplayStart;
	  private int iDisplayLength;
	  private int iColumns;
	  private String sSearch;
	  private String sEcho;
	  private String _;
	  private String[] bRegex;
	  private boolean bRegex_0;
	  private boolean bRegex_1;
	  private boolean bRegex_2;
	  private boolean bRegex_3;
	  private boolean bRegex_4;
	  private boolean bRegex_5;
	  private boolean bRegex_6;
	  private boolean bRegex_7;
	  private boolean bSearchable_0;
	  private boolean bSearchable_1;
	  private boolean bSearchable_2;
	  private boolean bSearchable_3;
	  private boolean bSearchable_4;
	  private boolean bSearchable_5;
	  private boolean bSearchable_6;
	  private boolean bSearchable_7;
	  private boolean bSortable_0;
	  private boolean bSortable_1;
	  private boolean bSortable_2;
	  private boolean bSortable_3;
	  private boolean bSortable_4;
	  private boolean bSortable_5;
	  private boolean bSortable_6;
	  private boolean bSortable_7;
	  private int iSortCol_0;
	  private int iSortingCols;
	  private String mDataProp_0;
	  private String mDataProp_1;
	  private String mDataProp_2;
	  private String mDataProp_3;
	  private String mDataProp_4;
	  private String mDataProp_5;
	  private String mDataProp_6;
	  private String mDataProp_7;
	  private String sColumns;
	  private String sSearch_0;
	  private String sSearch_1;
	  private String sSearch_2;
	  private String sSearch_3;
	  private String sSearch_4;
	  private String sSearch_5;
	  private String sSearch_6;
	  private String sSearch_7;
	  private String sSortDir_0;
	  private String sSortDir_1;
	  private String sSortDir_2;
	  private String sSortDir_3;
	  private String sSortDir_4;
	  private String sSortDir_5;
	  private String sSortDir_6;
	  private String sSortDir_7;
	  public HttpServletRequest request;
	  public String execute() throws Exception {
		  	  JobDAO jobDAO=new JobDAO();
		  	  
		      int total =0;
		      if(ServletActionContext.getServletContext().getAttribute("J-"+mainJob+"-"+subJob+"-"+subSubJob+"-"+gender) !=null)
		    	  total=(Integer) ServletActionContext.getServletContext().getAttribute("J-"+mainJob+"-"+subJob+"-"+subSubJob+"-"+gender);
		      else{
		    	  total=jobDAO.getTotalJobseekerList(mainJob,subJob,subSubJob,gender);  
		    	  ServletActionContext.getServletContext().setAttribute("J-"+mainJob+"-"+subJob+"-"+subSubJob+"-"+gender,total);
		      }
		      
		      List<JobseekerDTO> jobSeekerList = null;

		      jobSeekerList =
		    		  jobDAO.sortJobseekerList(
		            	mainJob,subJob,subSubJob,gender,
		                iDisplayStart,
		                iDisplayLength,
		                iSortCol_0,
		                sSortDir_0);

		      Map<String, Object> jsonMap = new HashMap<String, Object>();
		      jsonMap.put("sEcho", sEcho);
		      jsonMap.put("iTotalRecords", String.valueOf(total));
		      jsonMap.put("iTotalDisplayRecords", String.valueOf(total));

		      List<List<String>> columns = new ArrayList();

		      for (JobseekerDTO jobseeker : jobSeekerList) {
		        List<String> columnList = new ArrayList();
		        columnList.add(jobseeker.getJobseekerId());
		        columnList.add(jobseeker.getName());
		        columnList.add(jobseeker.getFatherName());
		        columnList.add(jobseeker.getMotherName());
		        columnList.add(jobseeker.getBirthDate());
		        columnList.add(jobseeker.getReligion());
		        columnList.add(jobseeker.getGender());
		        columnList.add(jobseeker.getDistName());
		        columns.add(columnList);
		      }

		      jsonMap.put("aaData", columns);
		      JSONObject json = new JSONObject(jsonMap);
		      request.setAttribute("tableData", json);
		    
		    return SUCCESS;
}
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		
	}
	 public void setServletRequest(HttpServletRequest request) {
		    this.request = request;
		  }

		  public HttpServletRequest getServletRequest() {
		    return this.request;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getiDisplayStart() {
		return iDisplayStart;
	}
	public void setiDisplayStart(int iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}
	public int getiDisplayLength() {
		return iDisplayLength;
	}
	public void setiDisplayLength(int iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}
	public int getiColumns() {
		return iColumns;
	}
	public void setiColumns(int iColumns) {
		this.iColumns = iColumns;
	}
	public String getsSearch() {
		return sSearch;
	}
	public void setsSearch(String sSearch) {
		this.sSearch = sSearch;
	}
	public String getsEcho() {
		return sEcho;
	}
	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}
	public String get_() {
		return _;
	}
	public void set_(String _) {
		this._ = _;
	}
	public String[] getbRegex() {
		return bRegex;
	}
	public void setbRegex(String[] bRegex) {
		this.bRegex = bRegex;
	}
	public boolean isbRegex_0() {
		return bRegex_0;
	}
	public void setbRegex_0(boolean bRegex_0) {
		this.bRegex_0 = bRegex_0;
	}
	public boolean isbRegex_1() {
		return bRegex_1;
	}
	public void setbRegex_1(boolean bRegex_1) {
		this.bRegex_1 = bRegex_1;
	}
	public boolean isbRegex_2() {
		return bRegex_2;
	}
	public void setbRegex_2(boolean bRegex_2) {
		this.bRegex_2 = bRegex_2;
	}
	public boolean isbRegex_3() {
		return bRegex_3;
	}
	public void setbRegex_3(boolean bRegex_3) {
		this.bRegex_3 = bRegex_3;
	}
	public boolean isbRegex_4() {
		return bRegex_4;
	}
	public void setbRegex_4(boolean bRegex_4) {
		this.bRegex_4 = bRegex_4;
	}
	public boolean isbRegex_5() {
		return bRegex_5;
	}
	public void setbRegex_5(boolean bRegex_5) {
		this.bRegex_5 = bRegex_5;
	}
	public boolean isbRegex_6() {
		return bRegex_6;
	}
	public void setbRegex_6(boolean bRegex_6) {
		this.bRegex_6 = bRegex_6;
	}
	public boolean isbRegex_7() {
		return bRegex_7;
	}
	public void setbRegex_7(boolean bRegex_7) {
		this.bRegex_7 = bRegex_7;
	}
	public boolean isbSearchable_0() {
		return bSearchable_0;
	}
	public void setbSearchable_0(boolean bSearchable_0) {
		this.bSearchable_0 = bSearchable_0;
	}
	public boolean isbSearchable_1() {
		return bSearchable_1;
	}
	public void setbSearchable_1(boolean bSearchable_1) {
		this.bSearchable_1 = bSearchable_1;
	}
	public boolean isbSearchable_2() {
		return bSearchable_2;
	}
	public void setbSearchable_2(boolean bSearchable_2) {
		this.bSearchable_2 = bSearchable_2;
	}
	public boolean isbSearchable_3() {
		return bSearchable_3;
	}
	public void setbSearchable_3(boolean bSearchable_3) {
		this.bSearchable_3 = bSearchable_3;
	}
	public boolean isbSearchable_4() {
		return bSearchable_4;
	}
	public void setbSearchable_4(boolean bSearchable_4) {
		this.bSearchable_4 = bSearchable_4;
	}
	public boolean isbSearchable_5() {
		return bSearchable_5;
	}
	public void setbSearchable_5(boolean bSearchable_5) {
		this.bSearchable_5 = bSearchable_5;
	}
	public boolean isbSearchable_6() {
		return bSearchable_6;
	}
	public void setbSearchable_6(boolean bSearchable_6) {
		this.bSearchable_6 = bSearchable_6;
	}
	public boolean isbSearchable_7() {
		return bSearchable_7;
	}
	public void setbSearchable_7(boolean bSearchable_7) {
		this.bSearchable_7 = bSearchable_7;
	}
	public boolean isbSortable_0() {
		return bSortable_0;
	}
	public void setbSortable_0(boolean bSortable_0) {
		this.bSortable_0 = bSortable_0;
	}
	public boolean isbSortable_1() {
		return bSortable_1;
	}
	public void setbSortable_1(boolean bSortable_1) {
		this.bSortable_1 = bSortable_1;
	}
	public boolean isbSortable_2() {
		return bSortable_2;
	}
	public void setbSortable_2(boolean bSortable_2) {
		this.bSortable_2 = bSortable_2;
	}
	public boolean isbSortable_3() {
		return bSortable_3;
	}
	public void setbSortable_3(boolean bSortable_3) {
		this.bSortable_3 = bSortable_3;
	}
	public boolean isbSortable_4() {
		return bSortable_4;
	}
	public void setbSortable_4(boolean bSortable_4) {
		this.bSortable_4 = bSortable_4;
	}
	public boolean isbSortable_5() {
		return bSortable_5;
	}
	public void setbSortable_5(boolean bSortable_5) {
		this.bSortable_5 = bSortable_5;
	}
	public boolean isbSortable_6() {
		return bSortable_6;
	}
	public void setbSortable_6(boolean bSortable_6) {
		this.bSortable_6 = bSortable_6;
	}
	public boolean isbSortable_7() {
		return bSortable_7;
	}
	public void setbSortable_7(boolean bSortable_7) {
		this.bSortable_7 = bSortable_7;
	}
	public int getiSortCol_0() {
		return iSortCol_0;
	}
	public void setiSortCol_0(int iSortCol_0) {
		this.iSortCol_0 = iSortCol_0;
	}
	public int getiSortingCols() {
		return iSortingCols;
	}
	public void setiSortingCols(int iSortingCols) {
		this.iSortingCols = iSortingCols;
	}
	public String getmDataProp_0() {
		return mDataProp_0;
	}
	public void setmDataProp_0(String mDataProp_0) {
		this.mDataProp_0 = mDataProp_0;
	}
	public String getmDataProp_1() {
		return mDataProp_1;
	}
	public void setmDataProp_1(String mDataProp_1) {
		this.mDataProp_1 = mDataProp_1;
	}
	public String getmDataProp_2() {
		return mDataProp_2;
	}
	public void setmDataProp_2(String mDataProp_2) {
		this.mDataProp_2 = mDataProp_2;
	}
	public String getmDataProp_3() {
		return mDataProp_3;
	}
	public void setmDataProp_3(String mDataProp_3) {
		this.mDataProp_3 = mDataProp_3;
	}
	public String getmDataProp_4() {
		return mDataProp_4;
	}
	public void setmDataProp_4(String mDataProp_4) {
		this.mDataProp_4 = mDataProp_4;
	}
	public String getmDataProp_5() {
		return mDataProp_5;
	}
	public void setmDataProp_5(String mDataProp_5) {
		this.mDataProp_5 = mDataProp_5;
	}
	public String getmDataProp_6() {
		return mDataProp_6;
	}
	public void setmDataProp_6(String mDataProp_6) {
		this.mDataProp_6 = mDataProp_6;
	}
	public String getmDataProp_7() {
		return mDataProp_7;
	}
	public void setmDataProp_7(String mDataProp_7) {
		this.mDataProp_7 = mDataProp_7;
	}
	public String getsColumns() {
		return sColumns;
	}
	public void setsColumns(String sColumns) {
		this.sColumns = sColumns;
	}
	public String getsSearch_0() {
		return sSearch_0;
	}
	public void setsSearch_0(String sSearch_0) {
		this.sSearch_0 = sSearch_0;
	}
	public String getsSearch_1() {
		return sSearch_1;
	}
	public void setsSearch_1(String sSearch_1) {
		this.sSearch_1 = sSearch_1;
	}
	public String getsSearch_2() {
		return sSearch_2;
	}
	public void setsSearch_2(String sSearch_2) {
		this.sSearch_2 = sSearch_2;
	}
	public String getsSearch_3() {
		return sSearch_3;
	}
	public void setsSearch_3(String sSearch_3) {
		this.sSearch_3 = sSearch_3;
	}
	public String getsSearch_4() {
		return sSearch_4;
	}
	public void setsSearch_4(String sSearch_4) {
		this.sSearch_4 = sSearch_4;
	}
	public String getsSearch_5() {
		return sSearch_5;
	}
	public void setsSearch_5(String sSearch_5) {
		this.sSearch_5 = sSearch_5;
	}
	public String getsSearch_6() {
		return sSearch_6;
	}
	public void setsSearch_6(String sSearch_6) {
		this.sSearch_6 = sSearch_6;
	}
	public String getsSearch_7() {
		return sSearch_7;
	}
	public void setsSearch_7(String sSearch_7) {
		this.sSearch_7 = sSearch_7;
	}
	public String getsSortDir_0() {
		return sSortDir_0;
	}
	public void setsSortDir_0(String sSortDir_0) {
		this.sSortDir_0 = sSortDir_0;
	}
	public String getsSortDir_1() {
		return sSortDir_1;
	}
	public void setsSortDir_1(String sSortDir_1) {
		this.sSortDir_1 = sSortDir_1;
	}
	public String getsSortDir_2() {
		return sSortDir_2;
	}
	public void setsSortDir_2(String sSortDir_2) {
		this.sSortDir_2 = sSortDir_2;
	}
	public String getsSortDir_3() {
		return sSortDir_3;
	}
	public void setsSortDir_3(String sSortDir_3) {
		this.sSortDir_3 = sSortDir_3;
	}
	public String getsSortDir_4() {
		return sSortDir_4;
	}
	public void setsSortDir_4(String sSortDir_4) {
		this.sSortDir_4 = sSortDir_4;
	}
	public String getsSortDir_5() {
		return sSortDir_5;
	}
	public void setsSortDir_5(String sSortDir_5) {
		this.sSortDir_5 = sSortDir_5;
	}
	public String getsSortDir_6() {
		return sSortDir_6;
	}
	public void setsSortDir_6(String sSortDir_6) {
		this.sSortDir_6 = sSortDir_6;
	}
	public String getsSortDir_7() {
		return sSortDir_7;
	}
	public void setsSortDir_7(String sSortDir_7) {
		this.sSortDir_7 = sSortDir_7;
	}
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}