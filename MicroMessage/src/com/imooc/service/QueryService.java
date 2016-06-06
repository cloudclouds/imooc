package com.imooc.service;

import java.util.List;

import com.imooc.bean.Message;
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
	  public String queryByCommand(String command)
	  {
		  MessageDao messageDao=new MessageDao();
		  List<Message>messageList=null;
		  if(Iconst.HELP_COMMAND.equals(command))
	      {
			 messageList=messageDao.queryMesageList(null, null);
			 StringBuilder result=new StringBuilder();
			 int size=messageList.size();
			 for(int i=0;i<size;i++)
			 {
				 if(i>0) result.append("<br/>");
				 result.append("回复["+messageList.get(i).getCommand()+"]，可以查看"+messageList.get(i).getDescription());
			 }
			 return result.toString();
	      }
		  messageList=messageDao.queryMesageList(command, null);
		  if(messageList.size()>0)
	      {
	    	  return messageList.get(0).getContent();
	      }
	      else return Iconst.NO_MATCHING_CONTENT;
	  }
}
