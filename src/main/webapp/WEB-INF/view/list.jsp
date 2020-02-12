<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function add() {
		var formData=new FormData($("#form")[0]);
		$.ajax({
			processData:false,
			contentType:false,
			url:"publish1",
			data:formData,
			type:"post",
			success:function(msg){
				if(msg){
					alert("发布完成");
					location="list";
				}else{
					alert("发布失败");
				}
			}
		})
	}
</script>
</head>
<body>
<table border="1">
	<tr>
		<td>编号</td>
		<td>图片</td>
	</tr>
	<c:forEach items="${list }" var="p">
		<tr>
			<td>${p.id}</td>
			<td><img alt="" src="/pic/${p.magger}" width="50px"
				height="60px"></td>
		</tr>	
	</c:forEach>
</table>
<h1>表单提交</h1>
<form action="publish" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<TD>上传图片</TD>
			<td>
				<input type="file" name="file">
			</td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="提交"></td>
		</tr>
	</table>
</form>
<h1>ajax提交</h1>
<form id="form">
	<table>
		<tr>
			<TD>上传图片</TD>
			<td>
				<input type="file" name="file">
			</td>
		</tr>
		<tr>
			<td></td>
			<td><button type="button" onclick="add()">提交</button></td>
		</tr>
	</table>
</form>
</body>
</html>