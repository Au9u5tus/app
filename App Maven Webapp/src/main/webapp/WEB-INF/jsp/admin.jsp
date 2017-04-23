<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="easyuiHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../static/css/MyGrid.css" rel="stylesheet" type="text/css">
</head>

<body class="easyui-layout">
  <div data-options="region:'north',title:'North Title',split:true" style="height:200px;">
  		<div id="progressbar" style="width: 400px"></div> 
  </div>   
  <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>   
  <div data-options="region:'west',title:'行政区划结构',split:true" style="width:200px;">
  		<ul id="adminTree">
		</ul>
  </div>   
  <div data-options="region:'center',title:'行政区划列表'" style="background:#eee;">
  	<div id="dataContainer" style="width:100%;height:100%">
		<table id="dataTable" border="0">
		</table>
	</div>
	<div id="toolbar">
		<a class="easyui-linkbutton" data-options="iconCls:'icon-large-add',size:'large',plain:true" onclick="add()">增加</a>
		<a class="easyui-linkbutton" data-options="iconCls:'icon-large-edit',size:'large',plain:true">编辑</a>
		<a class="easyui-linkbutton" data-options="iconCls:'icon-large-remove',size:'large',plain:true" onclick="removeRows()">删除</a>
	</div>
  </div>   


	

	
	<i class="icon-edit"></i>
	<input class="easyui-filebox" style="width:300px"/>
	<input id="file" style="width:300px"/>
 
 	
	
	
	<div id="add" style="display:none;">
		<form id="addForm">
			<table>
				<tr><td class="row_name" align="right">编号:</td><td class="row_con"><input name="id" class="easyui-validatebox" data-options="required:true"/></td></tr>
				<tr><td class="row_name" align="right">名称:</td><td class="row_con"><input name="name" class="easyui-validatebox" data-options="required:true"/></td></tr>
				<tr><td class="row_name" align="right">上级序号:</td class="row_con"><td><input name="parentId" class="easyui-validatebox" data-options="required:true"/></td></tr>
				<tr><td class="row_name" align="right">是否直辖:</td class="row_con"><td><input name="isSpecial" class="easyui-validatebox" data-options="required:true"/></td></tr>
			</table>
		</form>
	</div>
</body>
<script>
$(document).ready(function(){
	var timer=setInterval(function(){
		var value = $('#progressbar').progressbar('getValue');
		if (value < 100){
		    value += 1
		    $('#progressbar').progressbar('setValue', value);
		}
	},1000);
	
	$("#cc").calendar({
		current:new Date(),
		onSelect:function(date){
			alert(date.getFullYear()+"-"+date.getMonth()+1+"-"+date.getDate())
		}
	});

	
	$("#progressbar").progressbar({
		value:0
	});
	$("#adminTree").tree({
		url:'adminTree'
	});
	
	$("#dataTable").datagrid({
			url:'getAdmins',
			columns:[[
			        {field:'',checkbox:true,width:100,align:'center'},
					{field:'name',title:'名称',width:100,align:'center'},
					{field:'simple',title:'简称',width:100,align:'center'},
					{field:'longitude',title:'经度',width:100,align:'center',formatter:function(value,row,index){
						return "E "+value+"°";
					}},
					{field:'latitude',title:'纬度',width:100,align:'center',formatter:function(value,row,index){
						return "N "+value+"°";
					}},
					{field:'parentId',title:'上级序号',width:100,align:'center'},
					{field:'isSpecial',title:'是否直辖',width:100,align:'center'},
					{field:'id',title:'操作',width:100,align:'center',formatter:function(value,row,index){
							var name=row.name;
							return "<input type='button' class='mybtn' value='编辑' onclick='edit(\""+name+"\")'>"
					}}
					]],
			title:'行政区划信息表',
 			fitColumns:true,
 			fit:true,
			striped:true,
			loadMsg:'数据加载中...',			
			pagination:true,
			pageList:[10,15,20,25,30],
			pageSize:10,
			idField:'id',
			showHeader:true,
			toolbar:$('#toolbar')
	});
	
});

function add(){
	var $add=$('#add');
	$add.show()
	$add.dialog({
			title:'增加行政区划',
			width:400,
			cache:false,
			modal:true,
			minimizable:true,
			collapsible:true,
			buttons:[{text:'保存',iconCls:'icon-save',handler:function(){
				submitForm("add")
				}},{text:'取消',iconCls:'icon-cancel',handler:function(){
						$add.dialog('close');
						
			}}]
	})
	
}
function edit(value){
	console.log($($("#dataTable").datagrid('getPager')))
}

function removeRows(){
	var rows=$("#dataTable").datagrid('getChecked');
	var ids=new Array();
	if(rows.length>0){
		$.messager.confirm('提示','您确认要删除所选择的行吗？',function(r){
			if(r){
				reqProgress();
				$.each(rows,function(key,value){
					ids.push(value.id)
				});
				$.ajax({
					url:'removeRows',
					data:{ids:ids.join(",")},
					type:'post',
					success:function(data){
						$.messager.progress('close');
						$("#dataTable").datagrid('load');
						showResMsg(data.resMsg);
						
					},
					error:function(data){
						
					}
					
				});
			}
		});
	}else{
		$.messager.alert('提示','你未选择要删除的行','warning'); 
	}
}

var submitForm=function(obj){
	$.ajax({
		url:'addAdmin',
		type:'post',
		data:$("#"+obj).find('form').serialize(),
		success:function(data){
			showResMsg(data.resMsg)
			$("#"+obj).dialog('close')
		}
	});
	
// 	$("#"+obj).find('form').form('submit',{
// 		url:'addAdmin',
// 		onSubmit:function(){
			
// 		},
// 		success:function(data){
// 			showResMsg(data.resMsg)
// 			$("#"+obj).dialog('close')
// 		}
// 	});
}

var reqProgress=function(){
	$.messager.progress({
		title:'请求进度',
		text:'',
		interval:100
	})
}

var showResMsg=function(message){
	$.messager.show({
		title:'响应消息',
		msg:message,
		timeout:2000,
		showType:'slide'
	});
}
</script>

</html>