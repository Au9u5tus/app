<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="bootHead.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../static/css/login.css">
	</head>
	<body>
	<button class="btn btn-info btn-lg">按钮</button>
	<button class="btn btn-danger btn-lg">按钮</button>
	<button class="btn btn-success btn-lg">按钮</button>
	<button type="button" class="btn btn-success">
  		<span class="glyphicon glyphicon-facetime-video" aria-hidden="true"></span>&nbsp;增加
	</button>
	<table class="table">
  		<caption>上下文表格布局</caption>
  		<thead>
   		 <tr>
      		<th>产品</th>
      		<th>付款日期</th>
      		<th>状态</th>
      	</tr>
  		</thead>
 		<tbody>
    		<tr class="active">
      			<td>产品1</td>
      			<td>23/11/2013</td>
      			<td>待发货</td></tr>
    		<tr class="success">
      			<td>产品2</td>
      			<td>10/11/2013</td>
      			<td>发货中</td></tr>
    		<tr class="warning">
      			<td>产品3</td>
      			<td>20/10/2013</td>
      			<td>待确认</td></tr>
    		<tr class="danger">
      			<td>产品4</td>
      			<td>20/10/2013</td>
      			<td>已退货</td></tr>
  		</tbody>
	</table>
	</body>
</html>