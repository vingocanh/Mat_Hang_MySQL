<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Thuoc</h1>
        <h2>
        	<a href="list">List</a>
        	
        </h2>
	</center>
	
	<div align="center">	
		<form action="update" method="post" >
                <div class="edit">
                    <div class="left">
                    
                   		 <input type="hidden" name="id" value="<c:out value='${mathang.id}'/>" />
                   		 
                    	<label for="">Ten mh</label>
                        <br>
                        <input type="text" name = "tenMH"  size = "25" value="<c:out value='${mathang.tenMH}'/>" ></input><br>
                        <label for="">Mo ta</label><br>
                        <input type="text" name = "moTa"  size = 25 value="<c:out value='${mathang.moTa}' />"></input><br>
                        <label for="">Chat luong</label><br>
                        <input type="text" name = "chatLieu"  size = 25 value="<c:out value='${mathang.chatLieu}' />"></input><br>
                        <label for="">Noi sx</label><br>
                        <input type="text" name = "noiSX"  size = 25 value="<c:out value='${mathang.noiSX}' />"></input><br>
                        <label for="">Hang SX</label><br>
                        <input type="text" name = "hangSX" size = 25 value="<c:out value='${mathang.hangSX}' />"></input><br>
                         <label for="">Ngay SX</label><br>
                        <input type="text" name = "ngaySX" size = 25 value="<c:out value='${mathang.ngaySX}' />"></input><br>
                        <button style="text-align: center; margin-left: ;" type="submit">Edit</button>
						
                    </div>
                </div>
	        </form>
	
    </div>
</body>
</html>