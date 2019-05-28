package	cn.edu.zucc.booklib.databean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "book")
public class BeanBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "book_id", unique = true, nullable = false)
	private int bookId;
	@Column(name = "book_name")
	private String bookName;
	@Column(name = "booktype_id")
	private int booktypeId;
	@Column(name = "author")
	private String author;
	@Column(name = "publisher")
	private String publisher;
	@Column(name = "stock_number")
	private int stockNumber;
	@Column(name = "is_delete")
	private int isDelete;
	
	@ManyToOne(fetch=FetchType.LAZY) //fetch: 设置了延迟加载 ，默认为立即加载，不设置则会和bookType表外连接查询
    @JoinColumn(name="booktypeId")
	private BeanBookType bookType;

	@ManyToMany(mappedBy="books")//设置多对多并指定维护关系的控制权交给Emp类这一方
    private Set<BeanLendRecord> records = new HashSet<BeanLendRecord>();
	
	public Set<BeanLendRecord> getRecords() {
		return records;
	}
	public void setRecords(Set<BeanLendRecord> records) {
		this.records = records;
	}
	public BeanBookType getBookType() {
		return bookType;
	}
	public void setBookType(BeanBookType bookType) {
		this.bookType = bookType;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBooktypeId() {
		return booktypeId;
	}
	public void setBooktypeId(int booktypeId) {
		this.booktypeId = booktypeId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getStockNumber() {
		return stockNumber;
	}
	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
}
