package cn.edu.zucc.booklib.service;

import java.util.List;

import cn.edu.zucc.booklib.databean.BeanBookType;
import cn.edu.zucc.booklib.exception.BooklibException;

public interface BookTypeService {
	public void addBookType(String booktypeName, String picture) throws BooklibException;
	
	public void deleteBookType(int booktypeId) throws BooklibException;
	
	public void modifyBookType(int booktypeId, String newName)throws BooklibException ;
	
	public List<BeanBookType> loadBookTypes()throws BooklibException ;
}
