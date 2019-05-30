package	cn.edu.zucc.booklib.databean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_type")
public class BeanBookType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "booktype_id", unique = true, nullable = false)
	private int booktypeId;
	@Column(name = "booktype_name")
	private String booktypeName;
	@Column(name = "is_delete")
	private int isDelete;

	public void setBooktype_id(int booktypeId){
		this.booktypeId = booktypeId;
	}
	public int getBooktype_id(){
		return booktypeId;
	}
	public void setBooktype_name(String booktypeName){
		this.booktypeName = booktypeName;
	}
	public String getBooktype_name(){
		return booktypeName;
	}
	public void setIs_delete(int isDelete){
		this.isDelete = isDelete;
	}
	public int getIs_delete(){
		return isDelete;
	}
}
