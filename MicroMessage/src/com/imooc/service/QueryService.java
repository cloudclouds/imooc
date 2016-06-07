package com.imooc.service;

import java.util.List;
import java.util.Random;

import com.imooc.bean.Command;
import com.imooc.bean.CommandContent;
import com.imooc.bean.Message;
import com.imooc.dao.CommandDao;
import com.imooc.dao.MessageDao;
import com.imooc.util.Iconst;


/**
 * 
 * 列表相关的业务功能
 *
 */
public class QueryService {
	
	  public List<Message> queryMesageList(String command,String description)
	  {
		  MessageDao messageDao=new MessageDao();
		 return messageDao.queryMesageList(command, description);
	  }
	  
	  /**
	   *  通过指令查询自动回复内容
	   * @param command 指令
	   * @return 自动回复的内容
	   */
	  public String queryByCommand(String name)
	  {
//		  MessageDao messageDao=new MessageDao();
//		  List<Message>messageList=null;
		  CommandDao commandDao=new CommandDao();
		  List<Command> commandList=null;
		  if(Iconst.HELP_COMMAND.equals(name))
	      {
			 commandList=commandDao.queryCommandList(null,null);
			 StringBuilder result=new StringBuilder();
			 int size=commandList.size();
			 for(int i=0;i<size;i++)
			 {
				 if(i>0) result.append("<br/>");
				 result.append("回复["+commandList.get(i).getName()+"]，可以查看"+commandList.get(i).getDescription());
			 }
			 return result.toString();
	      }
		  commandList=commandDao.queryCommandList(name, null);
		  if(commandList.size()>0)
	      {
	    	  List<CommandContent> contentList=commandList.get(0).getContentList();
	    	  int i=new Random().nextInt(contentList.size());
	    	  System.out.println(contentList.size());
	    	  System.out.println("i-->"+i);
	    	  return contentList.get(i).getContent();
	      }
	      else return Iconst.NO_MATCHING_CONTENT;
	  }
}
