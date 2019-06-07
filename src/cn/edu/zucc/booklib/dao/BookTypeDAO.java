package cn.edu.zucc.booklib.dao;

import java.util.List;

import cn.edu.zucc.booklib.databean.BeanBookType;

public interface BookTypeDAO {

	public void addBookType(String booktypeName, String picture);
	
	public void deleteBookType(BeanBookType bookType);
	
	public void modifyBookType(BeanBookType bookType, String newName);

	public BeanBookType findTypeById(int booktypeId);
	
	public BeanBookType findTypeByName(String booktypeName);
	
	public List<BeanBookType> loadBookTypes();
   
}
