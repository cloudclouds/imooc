package com.imooc.service;

import java.util.ArrayList;
import java.util.List;

import com.imooc.dao.MessageDao;

/*
 * 维护相关的业务
 */
public class MaintainService {
   /*
    * 单条删除
    */
	public void deleteOne(String id)
	{
		MessageDao messageDao=new MessageDao();
		if(id!=null||!"".equals(id.trim()))
		{
			messageDao.deleteOne(Integer.valueOf(id));
		}
	}
	
	/*
	 * 批量删除
	 */
	public void deleteBatch(String[] ids)
	{
		MessageDao messageDao=new MessageDao();
		List<Integer> idList=new ArrayList<>(); 
		for(String id:ids)
		{
			idList.add(Integer.valueOf(id));
		}
		messageDao.deleteBatch(idList);
	}
}
