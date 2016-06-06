package com.imooc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.imooc.bean.Message;
import com.imooc.db.DBAccess;

public class MessageDao {
	/*
	 * 根据查询条件查询消息列表
	 */
  public List<Message> queryMesageList(String command,String description)
  {
	  SqlSession sqlSession=null;
	  DBAccess dbAccess=new DBAccess();
	  List<Message> messageList=null;
	  Message message=new Message();
	  message.setCommand(command);
	  message.setDescription(description);
	  try {
		sqlSession= dbAccess.getSqlSession();
		//通过sqlSession执行SQL语句
		messageList=sqlSession.selectList("Message.queryMessageList",message);
		for(Message message2:messageList)
		{
//			System.out.println(message2.getCommand());
//			System.out.println(message2.getDescription());
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	  finally
	  {
		  if(sqlSession!=null)   sqlSession.close();
	  }
	  return messageList;
  }
	/*
	 * 根据查询条件查询消息列表
	 */
  /*
  public List<Message> queryMesageList(String command,String description)
  {
	  List<Message> messageList=null;
	  try{
	    Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://115.159.158.26:3306/micro_message?characterEncoding=utf-8","root","bnrc608");
	    StringBuilder sql= new StringBuilder("select id,command,description,content from message where 1=1");
		List<String> paramList=new ArrayList<>();
		if(command!=null&&!"".equals(command.trim()))
		{
			sql.append(" and command like '%' ? '%'");
			paramList.add(command);
		}
		if(description!=null&&!"".equals(description.trim()))
		{
			sql.append(" and description like '%' ? '%'");
			paramList.add(description);
		}
	    PreparedStatement pSt=conn.prepareStatement(sql.toString());
	    for(int i=0;i<paramList.size();i++)
	    { 
	    	pSt.setString(i+1,paramList.get(i));
	    }
		ResultSet res=pSt.executeQuery();
		messageList=new ArrayList<>();
		while(res.next())
		{
			Message message=new Message();
			messageList.add(message);
			message.setId(res.getInt("id"));
			message.setCommand(res.getString("command"));
			message.setDescription(res.getString("description"));
			message.setContent(res.getString("content"));
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  return messageList;
  }
  */
  
  
  public void deleteOne(int id)
  {
	  SqlSession sqlSession=null;
	  DBAccess dbAccess=new DBAccess();
	  try {
		sqlSession= dbAccess.getSqlSession();
		//通过sqlSession执行SQL语句
		sqlSession.delete("Message.deleteOne", id);
		sqlSession.commit();
	} catch (IOException e) {
		e.printStackTrace();
	}
	  finally
	  {
		  if(sqlSession!=null)   sqlSession.close();
	  }
  }
  
  public void deleteBatch(List<Integer> ids)
  {
	  SqlSession sqlSession=null;
	  DBAccess dbAccess=new DBAccess();
	  try {
		sqlSession=dbAccess.getSqlSession();
		sqlSession.delete("deleteBatch",ids);
		sqlSession.commit();
	  } catch (IOException e) {
		e.printStackTrace();
	  }
	  finally
	  {
		  if(sqlSession!=null) sqlSession.close();
	  }
  }
}
