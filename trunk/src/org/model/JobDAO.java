package org.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.table.JobDTO;
import org.table.JobseekerDTO;
import org.table.RegCountDTO;

import util.connection.ConnectionManager;

public class JobDAO {

public static ArrayList<JobDTO> getAllJob(int level, int searchType)  //0 -> Search All, 1 -> Search only active
	{
		   ArrayList<JobDTO> jobList=new ArrayList<JobDTO>();
		
	 	   Connection conn = ConnectionManager.getConnection();
	 	  String sql="";
	 	   if(level==99)
	 		  sql = "Select * from MST_JOBS where VISIBILITY=1 order by job_title";
	 	   else
	 	   {
	 		   if(searchType==1)
	 			  sql = "Select * from MST_JOBS Where level_no="+level+" and VISIBILITY=1 order by job_title";
	 		   else
	 			   sql = "Select * from MST_JOBS Where level_no="+level+" order by job_title";
	 		  
	 	   }
		   PreparedStatement stmt = null;
		   ResultSet r = null;
		   JobDTO jobDto  = null;
		   
			try
			{
				stmt = conn.prepareStatement(sql);
				r = stmt.executeQuery();
				while (r.next())
				{
					jobDto=new JobDTO();
					jobDto.setJobId(r.getInt("JOB_ID"));
					jobDto.setJobTitle(r.getString("JOB_TITLE"));
					jobList.add(jobDto);
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
	 		
	 	return jobList;

	}

public static ArrayList<JobDTO> getSubJobs(int patentJobId,int level,int searchType) //0 -> Search All, 1 -> Search only active
{
	   ArrayList<JobDTO> jobList=new ArrayList<JobDTO>();
	
 	   Connection conn = ConnectionManager.getConnection();
 	   String sql = "Select * from MST_JOBS where job_Id in (Select child_id from JOBS_MAPPING where Parent_Id="+patentJobId+") and Level_No="+level+" Order by Job_Title";
 	  
	   PreparedStatement stmt = null;
	   ResultSet r = null;
	   JobDTO jobDto  = null;
	   
		try
		{
			stmt = conn.prepareStatement(sql);
			r = stmt.executeQuery();
			while (r.next())
			{
				jobDto=new JobDTO();
				jobDto.setJobId(r.getInt("JOB_ID"));
				jobDto.setJobTitle(r.getString("JOB_TITLE"));
				jobList.add(jobDto);
			}
		} 
		catch (Exception e){e.printStackTrace();}
 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
			{e.printStackTrace();}stmt = null;conn = null;}
 		
 	return jobList;

}

public static Map getAllJob()
{
 	   Connection conn = ConnectionManager.getConnection();
 	   String sql="Select * from MST_JOBS";
	   
	   
	   PreparedStatement stmt = null;
	   ResultSet r = null;
	   JobDTO job;
	   Map jMap = new HashMap();
	   
		try
		{
			stmt = conn.prepareStatement(sql);
			r = stmt.executeQuery();
			while (r.next())
			{
				jMap.put(r.getInt("JOB_ID"), r.getString("JOB_TITLE"));
			}
		} 
		catch (Exception e){e.printStackTrace();}
 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
			{e.printStackTrace();}stmt = null;conn = null;}
 		
 	return jMap;

}

public static RegCountDTO getRegCount(String mainJob,String subJob,String subSubJob)
{
 	   Connection conn = ConnectionManager.getConnection();
 	   String extra="";
 	   
 	   if(subJob!=null && !subJob.equalsIgnoreCase("")  && !subJob.equalsIgnoreCase("null"))
 		  extra="  and sub_category="+subJob+ "";
 	  if(subSubJob!=null && !subSubJob.equalsIgnoreCase("") && !subSubJob.equalsIgnoreCase("null"))
 		 extra="  and sub_sub_category="+subSubJob+"";
	   
 	 String sql="Select * from ( " +
	  "Select count(EMP_JOB_PREFERENCE.jobseekerid) TOTAL from EMP_JOB_PREFERENCE,JOBSEEKER Where category="+mainJob+" "+extra+" AND JOBSEEKER.JOBSEEKERID=EMP_JOB_PREFERENCE.JOBSEEKERID)tmp1, " +
	 "(Select count(EMP_JOB_PREFERENCE.jobseekerid) MALE from EMP_JOB_PREFERENCE,JOBSEEKER Where category="+mainJob+" "+extra+"  AND JOBSEEKER.JOBSEEKERID=EMP_JOB_PREFERENCE.JOBSEEKERID AND GENDER='MALE')tmp2, " +
	 "(Select count(EMP_JOB_PREFERENCE.jobseekerid) FEMALE from EMP_JOB_PREFERENCE,JOBSEEKER Where category="+mainJob+" "+extra+"  AND JOBSEEKER.JOBSEEKERID=EMP_JOB_PREFERENCE.JOBSEEKERID AND GENDER='FEMALE' " +
	 ")tmp3 ";
	   
 	   
	   PreparedStatement stmt = null;
	   ResultSet r = null;
	   RegCountDTO countDTO=new RegCountDTO();
	   
		try
		{
			stmt = conn.prepareStatement(sql);
			r = stmt.executeQuery();
			String pattern = "##,##,##,###";
			DecimalFormat decimalFormat = new DecimalFormat(pattern);

			if (r.next())
			{
				
				countDTO.setTotalCount(decimalFormat.format(r.getDouble("TOTAL")));
				countDTO.setMaleCount(decimalFormat.format(r.getDouble("MALE")));
				countDTO.setFemaleCount(decimalFormat.format(r.getDouble("FEMALE")));
			}
		} 
		catch (Exception e){e.printStackTrace();}
 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
			{e.printStackTrace();}stmt = null;conn = null;}
 		
 	return countDTO;

}

public ArrayList<JobseekerDTO> getJobseekerList(String mainJob,String subJob,String subSubJob,String gender)
{
 	   Connection conn = ConnectionManager.getConnection();
 	   String sql="Select JOBSEEKER.*,to_char(BIRTH_DATE,'dd-MM-YYYY') BIRTH_DATE_ from  EMP_JOB_PREFERENCE,JOBSEEKER Where category="+mainJob+" ";
 	   if(subJob!=null && !subJob.equalsIgnoreCase("")  && !subJob.equalsIgnoreCase("null"))
 		   sql+="  and sub_category="+subJob+ "";
 	  if(subSubJob!=null && !subSubJob.equalsIgnoreCase("") && !subSubJob.equalsIgnoreCase("null"))
		   sql+="  and sub_sub_category="+subSubJob+"";
	   
	   sql+=" and JOBSEEKER.JOBSEEKERID=EMP_JOB_PREFERENCE.JOBSEEKERID";
 	  
	   if(gender!=null && !gender.equalsIgnoreCase("") && !gender.equalsIgnoreCase("ALL"))
	   {
		   sql+=" and Gender='"+gender+"'";
	   }
	   
	   PreparedStatement stmt = null;
	   ResultSet r = null;
	   JobseekerDTO jobseeker;
	   ArrayList<JobseekerDTO> jobseekerList=new ArrayList<JobseekerDTO>();
	   
		try
		{
			stmt = conn.prepareStatement(sql);
			r = stmt.executeQuery();
			while (r.next())
			{
				jobseeker=new JobseekerDTO();
				jobseeker.setJobseekerId(r.getString("JOBSEEKERID"));
				jobseeker.setName(r.getString("NAME"));
				jobseeker.setFatherName(r.getString("FATHER_NAME"));
				jobseeker.setMotherName(r.getString("MOTHER_NAME"));
				jobseeker.setBirthDate(r.getString("BIRTH_DATE_"));
				jobseeker.setReligion(r.getString("RELIGION"));
				jobseeker.setGender(r.getString("GENDER"));
				jobseeker.setDistName(r.getString("DIST_NAME"));
				jobseekerList.add(jobseeker);
			}
		} 
		catch (Exception e){e.printStackTrace();}
 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
			{e.printStackTrace();}stmt = null;conn = null;}
 		
 	return jobseekerList;

}

public int getTotalJobseekerList(String mainJob,String subJob,String subSubJob,String gender)
{
 	   Connection conn = ConnectionManager.getConnection();
 	  String sql="Select count(JOBSEEKER.JOBSEEKERID) TOTAL from  EMP_JOB_PREFERENCE,JOBSEEKER Where category="+mainJob+" ";
 	  
 	  if(subJob!=null && !subJob.equalsIgnoreCase("")  && !subJob.equalsIgnoreCase("null"))
 		   sql+="  and sub_category="+subJob+ "";
 	  if(subSubJob!=null && !subSubJob.equalsIgnoreCase("") && !subSubJob.equalsIgnoreCase("null"))
		   sql+="  and sub_sub_category="+subSubJob+"";
	   
	   sql+=" and JOBSEEKER.JOBSEEKERID=EMP_JOB_PREFERENCE.JOBSEEKERID";
	   
	   if(gender!=null && !gender.equalsIgnoreCase("") && !gender.equalsIgnoreCase("ALL"))
	   {
		   sql+=" and Gender='"+gender+"'";
	   }
	   int totalCount=10;
	   PreparedStatement stmt = null;
	   ResultSet r = null;
		try
		{
			stmt = conn.prepareStatement(sql);
			r = stmt.executeQuery();
			if (r.next())
			{
				totalCount=r.getInt("TOTAL");
			}
		} 
		catch (Exception e){e.printStackTrace();}
 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
			{e.printStackTrace();}stmt = null;conn = null;}
 		
 	return totalCount;

}
public List<JobseekerDTO> sortJobseekerList(String mainJob,String subJob,String subSubJob,String gender,
											int pStartIndex,int pTotal,int pSortColumn,String pSortDirection) 
	{
		
		List<JobseekerDTO> jobseekerList = new ArrayList<JobseekerDTO>();

		
		String sortColumn = "JOBSEEKER.JOBSEEKERID";
		
		switch (pSortColumn) {
		case 0:
			sortColumn = "JOBSEEKER.JOBSEEKERID";
			break;
		
		case 1:
			sortColumn = "NAME";
			break;
		
		case 2:
			sortColumn = "FATHER_NAME";
			break;
		
		case 3:
			sortColumn = "MOTHER_NAME";
			break;
		
		case 4:
			sortColumn = "BIRTH_DATE_";
			break;
		
		case 5:
			sortColumn = "RELIGION";
			break;
		
		case 6:
			sortColumn = "GENDER";
			break;
			
		case 7:
			sortColumn = "DIST_NAME";
			break;
		}

		String sql="Select JOBSEEKER.*,to_char(BIRTH_DATE,'dd-MM-YYYY') BIRTH_DATE_ from  EMP_JOB_PREFERENCE,JOBSEEKER Where category="+mainJob+" ";
		
		if(subJob!=null && !subJob.equalsIgnoreCase("")  && !subJob.equalsIgnoreCase("null"))
	 		   sql+="  and sub_category="+subJob+ "";
	 	  if(subSubJob!=null && !subSubJob.equalsIgnoreCase("") && !subSubJob.equalsIgnoreCase("null"))
			   sql+="  and sub_sub_category="+subSubJob+"";
		   
		   sql+=" and JOBSEEKER.JOBSEEKERID=EMP_JOB_PREFERENCE.JOBSEEKERID";
		   
		   if(gender!=null && !gender.equalsIgnoreCase("") && !gender.equalsIgnoreCase("ALL"))
		   {
			   sql+=" and Gender='"+gender+"'";
		   }
		   
		sql = "SELECT table1.*\n" +
        "FROM\n" +
        "  (SELECT table2.*, rownum r\n" +
        "  FROM\n" +
        "    ("+sql+
        "    ORDER BY " + sortColumn + " " + pSortDirection + "\n" +
        "    ) table2  \n" +
        "  ) table1\n" +
        "WHERE r > ?\n" +
        "AND r  <= ?";
		
		JobseekerDTO jobseeker;
		Connection conn = ConnectionManager.getConnection();
		   PreparedStatement stmt = null;
		   ResultSet r = null;

			try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, pStartIndex);
				stmt.setInt(2, pStartIndex+pTotal);
				r = stmt.executeQuery();
				while (r.next())
				{
					jobseeker=new JobseekerDTO();
					jobseeker.setJobseekerId(r.getString("JOBSEEKERID"));
					jobseeker.setName(r.getString("NAME"));
					jobseeker.setFatherName(r.getString("FATHER_NAME"));
					jobseeker.setMotherName(r.getString("MOTHER_NAME"));
					jobseeker.setBirthDate(r.getString("BIRTH_DATE_"));
					jobseeker.setReligion(r.getString("RELIGION"));
					jobseeker.setGender(r.getString("GENDER"));
					jobseeker.setDistName(r.getString("DIST_NAME"));
					jobseekerList.add(jobseeker);
				}
			} 
			catch (Exception e){e.printStackTrace();}
	 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
				{e.printStackTrace();}stmt = null;conn = null;}
		return jobseekerList;
	}
}