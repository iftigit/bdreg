package org.controller;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;
import org.model.JobDAO;
import org.table.JobseekerDTO;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
import com.opensymphony.xwork2.ActionSupport;

public class ReportJobseekerList extends ActionSupport implements ServletContextAware{
	

	private static final long serialVersionUID = 1L;

	private String mainJob;
    private String subJob;
    private String subSubJob;
    private String gender;
	private String reportMsg;
	
	public String execute() throws Exception
	{	
		Map jobMap=null;
		if(ServletActionContext.getServletContext().getAttribute("ALL_JOB")!=null)
		{
			jobMap=(Map) ServletActionContext.getServletContext().getAttribute("ALL_JOB");
		}
		else{
			jobMap=JobDAO.getAllJob();
			ServletActionContext.getServletContext().setAttribute("ALL_JOB",jobMap);
		}
			
		
		HttpServletResponse response = ServletActionContext.getResponse();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd__HH-mm-ss",Locale.getDefault());
		Calendar cal = Calendar.getInstance();
		String fileName="BD_Jobseeker_"+dateFormat.format(cal.getTime()).toUpperCase()+".pdf";
		
		JobDAO jobDAO=new JobDAO();
		ArrayList<JobseekerDTO> jsList=jobDAO.getJobseekerList(mainJob, subJob, subSubJob,gender);
		if(jsList==null || jsList.size()==0){
			reportMsg="No data found for the selected criteria.";
			return "error";
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ServletOutputStream out = response.getOutputStream();		
		
		Document document = new Document(PageSize.A4.rotate());
		document.setMargins(40, 40, 20, 20);
		document.addHeader("Jobseeker List", "");
		
		PdfPTable ptable = null;
		PdfPCell pcell=null;
		
		try{
			
			RaSummeryReportEvent eEvent = new RaSummeryReportEvent(servlet);
			
			Font font1 = new Font(Font.COURIER, 8, Font.BOLD); 
			font1.setColor(new Color(0x92, 0x90, 0x83));
			Font fontt = FontFactory.getFont("Helvetica", 8, Font.NORMAL,Color.BLACK);			
			Font fontb = FontFactory.getFont("Helvetica", 8, Font.BOLD,Color.BLACK);
			
			JobseekerDTO jsDTO=null;
			String mJob="",sJob="",ssJob="";
			if(mainJob!=null && !mainJob.equalsIgnoreCase("") && !mainJob.equalsIgnoreCase("null"))
				mJob=(String)jobMap.get(Integer.valueOf(mainJob));
			if(subJob!=null && !subJob.equalsIgnoreCase("") && !subJob.equalsIgnoreCase("null"))
				sJob=(String)jobMap.get(Integer.valueOf(subJob));
			if(subSubJob!=null && !subSubJob.equalsIgnoreCase("") && !subSubJob.equalsIgnoreCase("null"))
				ssJob=(String)jobMap.get(Integer.valueOf(subSubJob));

			
			for(int i=0;i<jsList.size();i++)
			{
				eEvent.setDisplayValue(mJob+"#"+sJob+"#"+ssJob+"#"+gender);
				jsDTO=jsList.get(i);								
				if(i==0){	
					PdfWriter.getInstance(document, baos).setPageEvent(eEvent);
					document.open();
					
					ptable = new PdfPTable(8);
					ptable.setHeaderRows(1);
					ptable.setWidthPercentage(100);
					ptable.setWidths(new float[]{5,10,17,17,16,12,10,12});
					
					pcell=new PdfPCell(new Paragraph("SL",fontb));
					pcell.setMinimumHeight(25f);
					pcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);			
					ptable.addCell(pcell);
					
					pcell=new PdfPCell(new Paragraph("Reg. ID",fontb));
					pcell.setMinimumHeight(25f);
					pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
					pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					ptable.addCell(pcell);
					
					pcell=new PdfPCell(new Paragraph("Full Name",fontb));
					pcell.setMinimumHeight(25f);
					pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
					pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					ptable.addCell(pcell);

					pcell=new PdfPCell(new Paragraph("Father Name",fontb));
					pcell.setMinimumHeight(25f);
					pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
					pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					ptable.addCell(pcell);
					
					pcell=new PdfPCell(new Paragraph("Mother Name",fontb));
					pcell.setMinimumHeight(25f);
					pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
					pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					ptable.addCell(pcell);
					
					pcell=new PdfPCell(new Paragraph("DoB",fontb));
					pcell.setMinimumHeight(25f);
					pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
					pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					ptable.addCell(pcell);
					
					
					pcell=new PdfPCell(new Paragraph("Gender",fontb));
					pcell.setMinimumHeight(25f);
					pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
					pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					ptable.addCell(pcell);
					
					pcell=new PdfPCell(new Paragraph("District",fontb));
					pcell.setMinimumHeight(25f);
					pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
					pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					ptable.addCell(pcell);
					}
				
				pcell=new PdfPCell(new Paragraph(String.valueOf(i+1),fontt));
				pcell.setFixedHeight(22f);
				pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);			
				ptable.addCell(pcell);
				
				pcell=new PdfPCell(new Paragraph(jsDTO.getJobseekerId(),fontt));
				pcell.setFixedHeight(22f);
				pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);
				
				pcell=new PdfPCell(new Paragraph(jsDTO.getName(),fontt));
				pcell.setFixedHeight(22f);
				pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);

				pcell=new PdfPCell(new Paragraph(jsDTO.getFatherName(),fontt));
				pcell.setFixedHeight(22f);
				pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);
				
				pcell=new PdfPCell(new Paragraph(jsDTO.getMotherName(),fontt));
				pcell.setFixedHeight(22f);
				pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);
				
				pcell=new PdfPCell(new Paragraph(jsDTO.getBirthDate(),fontt));
				pcell.setFixedHeight(22f);
				pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);
				
				pcell=new PdfPCell(new Paragraph(jsDTO.getGender(),fontt));
				pcell.setFixedHeight(22f);
				pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);
				
				pcell=new PdfPCell(new Paragraph(jsDTO.getDistName(),fontt));
				pcell.setFixedHeight(22f);
				pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
				pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ptable.addCell(pcell);
			}
			document.add(ptable);
			document.close();		
			response.setHeader("Content-Disposition", "attachment;filename="+fileName);
			out.write(baos.toByteArray());
			out.flush();
			
		}catch(Exception e){e.printStackTrace();
		reportMsg="Error during report genration. Please contact system administrator.";
		return "error";
		}
		
		return null;
		
	}
	
	private ServletContext servlet;
	
	public ServletContext getServlet() {
		return servlet;
	}

	public void setServlet(ServletContext servlet) {
		this.servlet = servlet;
	}

	public void setServletContext(ServletContext servlet) {
		this.servlet = servlet;
	}

	public String getReportMsg() {
		return reportMsg;
	}

	public void setReportMsg(String reportMsg) {
		this.reportMsg = reportMsg;
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
	
}
class RaSummeryReportEvent extends PdfPageEventHelper
{
	protected ServletContext servlet =null;
	protected PdfTemplate total;
	protected BaseFont helv;
	protected PdfPTable footer;
	
	private String header="";
	 private String DisplayValue=null;
	 
	public void addheader(String header)
	{
		this.header = header;
	}	
	public RaSummeryReportEvent(ServletContext servlet) {
		
		this.servlet = servlet;
		
	}

	@Override
	public void onOpenDocument(PdfWriter writer, Document document) {
		// TODO Auto-generated method stub

		
		
		total = writer.getDirectContent().createTemplate(100, 100);
		total.setBoundingBox(new Rectangle(-20,-20,100,100));
		
		try{
			helv=BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.WINANSI,BaseFont.NOT_EMBEDDED);
		}catch(Exception e){
			throw new ExceptionConverter(e);
		}
		
	}
	
	@Override
	public void onEndPage(PdfWriter writer, Document document) {
		// TODO Auto-generated method stub
		
		PdfContentByte cb = writer.getDirectContent();
		
		footer = new PdfPTable(5);
		footer.setTotalWidth(700);
		footer.setWidthPercentage(80);

		try
		{
			footer.setWidths(new float[] {20,14,30,14,20});
			footer.setHorizontalAlignment(Element.ALIGN_CENTER);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		PdfPCell pcell=null;
		
		Font f10nornal = new Font(Font.TIMES_ROMAN,10,Font.NORMAL);
		
		pcell=new PdfPCell(new Paragraph("Prepared by",f10nornal));		
		pcell.setHorizontalAlignment(Element.ALIGN_LEFT);
		pcell.setMinimumHeight(50f);
		pcell.setBorderWidth(0);
		footer.addCell(pcell);
		
		
		pcell=new PdfPCell(new Paragraph("\n Page"+document.getPageNumber(),f10nornal));
		pcell.setColspan(3);
		pcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		pcell.setMinimumHeight(50f);
		pcell.setBorderWidth(0);
		footer.addCell(pcell);
		
		
		pcell=new PdfPCell(new Paragraph("",f10nornal));		
		pcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		pcell.setMinimumHeight(50f);
		pcell.setBorderWidth(0);
		footer.addCell(pcell);
		
		
		
		footer.writeSelectedRows(0, -1, (document.right()-document.left()-600)/2-document.leftMargin(),document.bottom()+5,cb);
		
		
	}
	
	@Override
	public void onStartPage(PdfWriter writer, Document document) {
		
		PdfContentByte cb = writer.getDirectContent();
		
		cb.saveState();
		String text = header;
		float textBase = document.top()+5;
		float textSize = helv.getWidthPoint(text, 12);
		cb.beginText();
		cb.setFontAndSize(helv, 10);
		if ((writer.getPageNumber() > 1))
		{
			cb.setTextMatrix((document.getPageSize().width()/2)-(textSize/2), textBase);
			cb.showText(text);
			cb.endText();
			cb.addTemplate(total,(document.getPageSize().width()/2)-(textSize/2), textBase);
		}
		else
		{
		cb.setTextMatrix(document.left()+50, textBase);
		cb.showText("");
		cb.endText();
		cb.addTemplate(total, document.right() + textSize, textBase);
			
		}
	
		cb.restoreState();
		
		String realpath = servlet.getRealPath("");
		String filepath = "/resources/images/bmetLogo.png";
		String bmetLogo=realpath+filepath;

		bmetLogo=realpath+filepath;
		

		try{
			
			URL  url = new URL("file", "localhost",bmetLogo);
			
			Image jpg = Image.getInstance(url);
			jpg.scalePercent(100f);
			Paragraph pg =null;
			
			PdfPTable ptable = new PdfPTable(2);
			ptable.setWidthPercentage(90f);
			ptable.setWidths(new float[] {20f,80f });
			ptable.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell pcell = new PdfPCell();
			
			
			pcell.addElement(jpg);
			//pcell.setPaddingBottom(-3f);
			pcell.setHorizontalAlignment(Element.ALIGN_CENTER);		
			pcell.setBorderColor(Color.WHITE);
			pcell.setFixedHeight(50f);
			ptable.addCell(pcell);

			String dValue=getDisplayValue();
			String[] valArr=dValue.split("#");
			
			
			String header1="Bureau of Manpower , Employment and Training (BMET)\nMinistry of Expatriates’ Welfare and Overseas Employment\nJobseeker List from BMET Database\nMain Job :"+valArr[0]+", Sub Job :"+valArr[1]+", Sub Sub Job :"+valArr[2]+", Gender :"+valArr[3];
			pcell = new PdfPCell();
			pg = new Paragraph(header1,new Font(Font.TIMES_ROMAN,10,Font.BOLD));
			pg.setAlignment(Element.ALIGN_LEFT);
			pcell.setColspan(4);
			pcell.addElement(pg);
			pcell.setPaddingBottom(5f);
			pcell.setBorderColor(Color.WHITE);
			pcell.setHorizontalAlignment(Element.ALIGN_CENTER);		
			pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);		
			ptable.addCell(pcell);
			
			ptable.setSpacingBefore(40f);
			ptable.setSpacingAfter(10f);
			
			document.add(ptable);
			
			
		}catch(Exception ex){
			
		}
		
		
	}

	public ServletContext getServlet() {
		return servlet;
	}

	public void setServlet(ServletContext servlet) {
		this.servlet = servlet;
	}



	public String getDisplayValue() {
		return DisplayValue;
	}



	public void setDisplayValue(String displayValue) {
		DisplayValue = displayValue;
	}

	
}