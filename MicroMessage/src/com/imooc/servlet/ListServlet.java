package com.imooc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.bean.Command;
import com.imooc.bean.Message;
import com.imooc.service.QueryService;

/*
 * 列表页面初始化控制
 * 
 */
@SuppressWarnings("serial")
public class ListServlet extends  HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			//指令名称
			String name=req.getParameter("name");
			String description=req.getParameter("description");
			System.out.println("name:"+name);
			System.out.println("desc:"+description);
			QueryService listService=new QueryService();
			//查询消息列表并传给页面
			List<Command> commandList=listService.queryMesageList(name, description);
			req.setAttribute("commandList",commandList);
			//跳转
		    req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
    
}
