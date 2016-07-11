package com.imooc.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.imooc.bean.Message;
import com.imooc.db.DBAccess;

public class MessageDaoTest {

	@Test
	public void testQueryMesageList() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteBatch()
	{
			  SqlSession sqlSession=null;
			  DBAccess dbAccess=new DBAccess();
			  List<Message> messageList=null;
			  try {
				sqlSession= dbAccess.getSqlSession();
				//通过sqlSession执行SQL语句
			    sqlSession.selectList("Message.queryMessageList2",8);
				messageList=sqlSession.selectList("Message.queryMessageList2",8);
				for(Message message2:messageList)
				{
					System.out.println(message2.getCommand());
					System.out.println(message2.getDescription());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			  finally
			  {
				  if(sqlSession!=null)   sqlSession.close();
			  }
	 }

	@Test
	public void test()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://123.206.62.205/smart?characterEncoding=utf-8";
			Connection conn=DriverManager.getConnection(url);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
