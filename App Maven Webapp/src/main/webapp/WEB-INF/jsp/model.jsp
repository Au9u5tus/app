<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="http://127.0.0.1:8080/StudentApp/file/genarateMod" method="post">  
    <div id="file" align="center">  
        <h1><input type="text" name="title" class="textField" value="我的简历"/></h1>  
        <hr/>  
        <table>  
            <tr>  
                <td class="key">姓名：</td>  
                <td><input type="text" name="name" class="textField"/></td>  
                <td class="key">性别：</td>  
                <td>  
                    <input type="radio" name="gender" value="男" checked/>男  
                    <input type="radio" name="gender" value="女" />女  
                </td>  
            </tr>  
            <tr>  
                <td class="key">联系电话：</td>  
                <td><input type="text" name="mobile" class="textField"/></td>  
                <td class="key">家庭住址：</td>  
                <td><input type="text" name="address" class="textField"/></td>  
            </tr>  
            <tr>  
                <td colspan="4" class="key">个人简介：</td>  
            </tr>  
            <tr>  
                <td colspan="4">  
                    <textarea rows="10" cols="100" name="content"></textarea>  
                </td>  
            </tr>  
        </table>  
    </div>  
    <div align="center" style="margin-top:15px;">  
        <input type="submit" value="保存Word文档" />  
    </div>  
    </form> 
</body>
</html>