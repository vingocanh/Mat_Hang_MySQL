<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        td {
            padding: 10px;
        }
        
        thead td {
            text-align: center;
        }
        
        .btn {
            text-decoration: none;
            background-color: rgb(16, 73, 14);
            color: #FFF;
            padding-top: 10px;
            padding-right: 30px;
            padding-bottom: 10px;
            border-radius: 10px;
            padding-left: 30px;
            margin: 10px;
        }
        
        .delete {
            background-color: #5A0002;
        }
        
        .edit {
            background-color: #D7CF07;
        }
        .trangThai{
        	display: flex;
            align-items: center;
            justify-content: center;
        }
        
        .edit:hover {
            background-color: #A40606;
            color: #FFF;
        }
        
        .btn:hover {
            background-color: #A40606;
            color: #FFF;
        }
    </style>
    <title>Document</title>
</head>

<body style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
    <div style="margin: 40px;">
        <h1>Quản MH</h1>
        <h4 style="color: #555555;">Danh MH</h4>
       <a href="create">Add</a>
        <table>
            <thead>
                <tr style="padding: 10px; font-weight: bold;">
                    <td>ID</td>
                    <td>Tên MH</td>
                     <td>Mo ta</td>
                    <td>Chất liêu</td>
                    <td>noi sx</td>
                    <td>Hãng sx</td>
                    <td>Ngày</td>
                    <td>Hành động</td>
                </tr>
            </thead>
            <tbody>
	            <c:forEach var="mh" items="${mathang}" >
						<tr>
							<td><c:out value="${mh.getId()}"></c:out> </td>
							<td><c:out value="${mh.getTenMH()}"></c:out> </td>
							<td><c:out value="${mh.getMoTa()}"></c:out> </td>
							<td><c:out value="${mh.getChatLieu()}"></c:out> </td>
							<td><c:out value="${mh.getNoiSX()}"></c:out> </td>
							<td><c:out value="${mh.getHangSX()}"></c:out> </td>
							<td><c:out value="${mh.getNgaySX()}"></c:out> </td>
							<td class="trangThai">
								<a class="btn edit" href="edit?id=<c:out value="${mh.getId()}"/>">Edit</a>
								<a class="btn delete" href="delete?id=<c:out value="${mh.getId()}"/>">Delete</a>
							</td>
							
						</tr>
						
				</c:forEach>
            </tbody>
        </table>
    </div>

</body>

</html>