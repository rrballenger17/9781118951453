<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="lesson27.tryit.StockPriceGenerator"%>
<%@page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%if(request.getParameter("symbol") == null){ %>
		<p>No symbol provided </p>
	<% }else{ %>
	
	<jsp:useBean id="Generator" class="lesson27.tryit.StockPriceGenerator" />

	<!--  java bean -->
	<jsp:useBean id="Stock" class="lesson27.tryit.Stock" />
	
	<jsp:setProperty property="symbol" name="Stock" value="<%=request.getParameter("symbol") %>" />
  
 	<p> Symbol: <%=Stock.getSymbol() %> Price: <%= Generator.getQuote(Stock) %> </p>
 

	<br/>
	<br/>
	Available stocks:<br/>
	<% for(String sym: Generator.getNasdaqSymbols() ){ %>
		<%= sym %><br/>
	<% } %> 
	
	<%} %>
	

	</body>
</html>









