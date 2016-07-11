package com.imooc.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Command;
import com.imooc.db.DBAccess;

public class CommandDao {
	/*
	 * 根据查询条件查询指令列表
	 */
  public List<Command> queryCommandList(String name,String description)
  {
	  SqlSession sqlSession=null;
	  DBAccess dbAccess=new DBAccess();
	  List<Command> commandList=null;
	  Command command=new Command();
	  command.setName(name);
	  command.setDescription(description);
	  try 
	  {
		sqlSession= dbAccess.getSqlSession();
		//通过sqlSession执行SQL语句
		commandList=sqlSession.selectList("Command.queryCommand",command);
	   } catch (IOException e) {
		e.printStackTrace();
	   }
	  finally
	  {
		  if(sqlSession!=null)   sqlSession.close();
	  }
	  return commandList;
    }
  
  public Command queryByCommandId(int id)
  {
	  SqlSession sqlSession=null;
	  DBAccess dbAccess=new DBAccess();
	  Command command=new Command();
	  try {
		sqlSession= dbAccess.getSqlSession();
		command=sqlSession.selectOne("Command.queryByCommandId", id);
	} catch (IOException e) {
		e.printStackTrace();
	}
	  finally
	  {
		  if(sqlSession!=null)   sqlSession.close();
	  }
	  return command;
  }
}
