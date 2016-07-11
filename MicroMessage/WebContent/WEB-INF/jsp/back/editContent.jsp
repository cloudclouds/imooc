<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>内容列表页面</title>
		<link href="<%= basePath %>resources/css/all.css" rel="stylesheet" type="text/css" />
		<script src="<%=basePath %>resources/js/common/jquery-1.8.0.min.js"></script>
		<script src="<%=basePath %>resources/js/back/list.js"></script>
	</head>
	<body style="background: #e1e9eb;">
		<form  action="<%=basePath %>List.action"  id="mainForm" method="post">
			<div class="right"  align="center">
				<div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容编辑</a> &gt; 内容列表</div>
				<div class="rightCont">
					<table class="tab1">
						<tbody>
							<tr>
								<td width="90" align="right">指令名称：</td>
								<td>
									<input type="text"  name="command" class="allInput"  readonly="readonly" value="${content.command.name} "/>
								</td>
								</tr>
								<tr>
								<td width="90" align="right">指令描述：</td>
								<td>
									<input type="text" name="description"  readonly="readonly" class="allInput" value="${content.command.description} "/>
								</td>
								</tr>
								<tr>
								<td width="90" align="right">指令内容：</td>
								<td>
									<input type="text" name="description"   class="allInput" value="${content.content} "/>
								</td>
								</tr>
								<tr>
	                            <td width="85" align="right"><input type="submit" class="tabSub" value="提交" /></td>
	       					</tr>
						</tbody>
					</table>
				</div>
			</div>
	    </form>
	</body>
</html>