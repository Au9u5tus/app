//1.数据栅格
var Grid=function(key,url,title){
	this.key="#"+key,
	this.url=url,
	this.title=title
}

Grid.prototype.loadGrid=function(){
	var settings={
			url:this.url,
			fitColumns:true,
//			fit:true,
			striped:true,
			loadMsg:'数据加载中...',			
			pagination:true,
			pageList:[10,15,20],
			pageSize:10,
			idField:'id',
			showHeader:true
	}
}
