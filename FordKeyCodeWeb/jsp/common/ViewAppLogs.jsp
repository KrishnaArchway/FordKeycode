<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>


<%@ page import="com.archway.estore.entities.FileBean"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.DataInputStream"%>
<div>

<%
try{
	
	if(request.getAttribute("FileBean") != null){
		
		FileBean fb[] = (FileBean[])request.getAttribute("FileBean") ;
		String logPath = (String)request.getAttribute("FilePath") ;
		String strFileName = null ;
		String errorMsg = "" ;
		
		if(fb != null){
			for(int i  = 0;i<fb.length;i++){
				FileBean fb2 = fb[i];
				String fileName = fb2.getFileName() ;
				if(fileName.equalsIgnoreCase("FordKeyCode.app.log")){
					strFileName = fileName ;				
				}
			}
		}
		
		if(strFileName != null){
			File file = new File(logPath+"//"+strFileName);
			if(file.exists()){
				FileInputStream input = new FileInputStream(file);
				 DataInputStream in = new DataInputStream(input);
				  BufferedReader br = new BufferedReader(new InputStreamReader(in));
				  String strLine;
				  //Read File Line By Line
				  while ((strLine = br.readLine()) != null)   {
				  // Print the content on the console
				  %>
				  
					<p><%= strLine %></p>
				  
				  <%
				  }
			}
		}
	
	}else{
		
		%>	<center>
			<p><font color="red"><b> File not found </b></font><br>				
			</p>
			</center>
		<%
	}
}catch(Exception ex){
	
}
%>
</div>