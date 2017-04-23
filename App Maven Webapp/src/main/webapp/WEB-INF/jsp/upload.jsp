<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../static/bootstrap/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../static/bootstrap/js/bootstrap.min.js"></script>
<link type="text.css" rel="stylesheet" href="../static/bootstrap/css/bootstrap.min.css">
</head>
<body>
<!-- 	<div><img src="${fileUrl}"></div> -->
<!-- 	<form action="http://127.0.0.1:8080/StudentApp/file/upload" enctype="multipart/form-data" method="post"> -->
<!-- 		<input type="text"> -->
<!-- 		<input class="upload-btn" type="button"value="上传附件"> -->
<!-- 		<input type="file" name="file" value="上传附件" style="display:none;"/> -->
<!-- 	</form> -->
<div id="showImage" style="left:100px;top:100px;width:30%">
	<img alt="上传图片" style="width:200px;height:200px" class="img-rounded">
</div>
<div class="input-group" style="left:100px;top:100px;width:30%">
  <input id="fileName" type="text" class="form-control" readonly="readonly">
  <span class="input-group-btn"><button id="uploadfile" type="button" class="btn btn-info upload-btn">上传附件</button></span>
  <form id="attachForm" enctype="multipart/form-data" method="post" action="/StudentApp/file/upload">
  	<input id="filebtn" type="file" name="file" value="上传附件" style="display:none;"/>
  </form>
  <button onclick="progress()">开始</button>
</div>
</body>
<script>
	
	$("#uploadfile").click(function(){
		$("#filebtn").click();
		
	})
	
	$("#filebtn").change(function(){
		var filePath=null;
		var files=$(this)[0].files
		var seperator="	  ";
		if($("#fileName").val()==""||$("#fileName").val()==null){
			$("#fileName").val($(files)[0].name)
		}else{
			$("#fileName").val($("#fileName").val()+seperator+$(files)[0].name)
		}
		$("#attachForm").submit();
	})
	var progress=function(){
		setInterval(function(){
			$.ajax({
				url:'http://localhost:8080/StudentApp/progress/getStatus',
				type:'post',
				success:function(data){
					console.log(Math.round(data.bytesRead/data.contentLength*100))
				}
			});
		},500);
	}
</script>
</html>