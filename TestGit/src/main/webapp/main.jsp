<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.9.1.js" charset="utf-8"></script>  <!-- 必须放在第一句执行 -->

<title>Insert title here</title>
</head>
<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			type:"post",
			url:"user.action?op=findAll",
			dataType:"json",
			success:function(data){
				var str="";
				for(var i=0;i<data.list.length;i++){
					alert(3333);
					var user=data.list[i];
					str+="<p>用户是："+user.id+"  "+"密码是："+user.password+" </p></br>"
				}
				$("#list").html(str);
			}
		});
	});
	

</script>
<body>

	<p>用户详情</p>
	<div id="list"></div>
	
</body>
</html>