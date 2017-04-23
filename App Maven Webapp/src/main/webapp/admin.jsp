<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="easyuiHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 	<div id="dataContainer" style="width:60%"> -->
<!-- 		<table id="dataTable"> -->
<!-- 		</table> -->
<!-- 	</div> -->
<!-- 	<div id="add" style="display:none;"> -->
<!-- 		<form action=""> -->
<!-- 			<table> -->
<!-- 				<tr><td class="row_name">编号:</td><td class="row_con"><input class="easyui-validatebox yhinput" data-options="required:true"></td></tr> -->
<!-- 				<tr><td class="row_name">名称:</td><td class="row_con"><input class="easyui-validatebox yhinput" data-options="required:true"></td></tr> -->
<!-- 				<tr><td class="row_name">上级序号:</td class="row_con"><td><input class="easyui-validatebox yhinput" data-options="required:true"></td></tr> -->
<!-- 				<tr><td class="row_name">是否直辖:</td class="row_con"><td><input class="easyui-validatebox yhinput" data-options="required:true"></td></tr> -->
<!-- 			</table> -->
<!-- 		</form> -->
<!-- 	</div> -->
	<div><a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">easyui</a>  
	</div>
</body>
<script>
$(document).ready(function(){

// 	$("#dataTable").datagrid({
// 			url:'http://localhost:8080/StudentApp/admin/getAdmins',
// 			columns:[[
// 					{checkbox:true,align:'center'},
// 					{field:'id',title:'编号',width:100,align:'center'},
// 					{field:'name',title:'名称',width:100,align:'center'},
// 					{field:'parentId',title:'上级序号',width:100,align:'center'},
// 					{field:'isSpecial',title:'是否直辖',width:100,align:'center'},
// 					{title:'操作',width:100,align:'center',formatter:'formatter'}
// 					]],
// 			title:'行政区划信息表',
// 			fitColumns:true,
// 			rownumbers:true,
// 			striped:true,
// 			loadMsg:'数据加载中...',			
// 			pagination:true,
// 			pageList:[10,20,30],
// 			idField:'id',
// 			iconCls:'icon-reload',
// 			showHeader:true,
// 			toolbar:[{iconCls:'icon-add',text:'增加',handler:function(){
// 						add()
// 					}},
// 					{iconCls:'icon-edit',text:'编辑',handler:function(){}},
// 					{iconCls:'icon-remove',text:'删除',handler:function(){}}
// 					]
// 	});
	
// 	$.ajax({
// 		url:'http://localhost:8080/Final/admin/getAdmins',
// 		type:'post',
// 		async:true,
// 		dataType:'json',
// 		success:function(data){
// 			console.log(data)
// 		}
// 	})
	
})

// function add(){
// 	var $add=$('#add');
// 	$add.show()
// 	$add.dialog({
// 			title:'增加行政区划',
// 			width:400,
// 			cache:false,
// 			modal:true,
// 			buttons:[{text:'保存',iconCls:'icon-save',handler:function(){
// 				}},{text:'取消',iconCls:'icon-cancel',handler:function(){
// 						$add.dialog('close');
						
// 			}}]
// 	})
	
// }
</script>

</html>