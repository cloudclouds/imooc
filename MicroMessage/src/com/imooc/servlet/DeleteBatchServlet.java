package com.imooc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.bean.Message;
import com.imooc.service.QueryService;
import com.imooc.service.MaintainService;

public class DeleteBatchServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6144884391549672446L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		    MaintainService maintainSer=new MaintainService();
			req.setCharacterEncoding("utf-8");
			//接收页面的值
			String[] ids=req.getParameterValues("id");
			maintainSer.deleteBatch(ids);
			//跳转
		    req.getRequestDispatcher("/List.action").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
