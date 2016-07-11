package com.imooc.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Command;
import com.imooc.bean.CommandContent;
import com.imooc.db.DBAccess;

public class CommandContentDao {
   public CommandContent queryContentById(int id)
   {
	      CommandContent commandContent=null;
	      SqlSession sqlSession=null;
		  DBAccess dbAccess=new DBAccess();
		  try {
			sqlSession=dbAccess.getSqlSession();
			commandContent=sqlSession.selectOne("CommandContent.queryContentById", id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			if(sqlSession!=null) sqlSession.close();  
		}
		  return commandContent;
   }
}
