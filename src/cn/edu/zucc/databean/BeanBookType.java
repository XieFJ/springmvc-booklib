package	cn.edu.zucc.databean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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

	@OneToMany(mappedBy="bookType",cascade={CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.FALSE) //设置立即加载,默认为延迟加载
    private Set<BeanBook> books = new HashSet<BeanBook>();// 图书集合
	
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
	public Set<BeanBook> getBooks() {
		return books;
	}
	public void setBooks(Set<BeanBook> books) {
		this.books = books;
	}
}
