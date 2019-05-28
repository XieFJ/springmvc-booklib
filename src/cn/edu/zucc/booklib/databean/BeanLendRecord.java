package	cn.edu.zucc.booklib.databean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "lend_record")
public class BeanLendRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "lendrecord_id", unique = true, nullable = false)
	private int lendrecordId;
	@Column(name = "reader_id")
	private int readerId;
	@Column(name = "book_id")
	private int bookId;
	@Column(name = "lend_date")
	private Date lendDate;
	@Column(name = "due_date")
	private Date dueDate;
	@Column(name = "return_date")
	private Date returnDate;
	@Column(name = "state")
	private String state;
	@Column(name = "penalty")
	private double penalty;
	
	@ManyToOne(fetch=FetchType.LAZY) //fetch: 设置了延迟加载 ，默认为立即加载，不设置则会和bookType表外连接查询
    @JoinColumn(name="readerId")
	private BeanReader reader;
	
	@ManyToMany(cascade=CascadeType.ALL)//设置多对多和级联
    //利用第三张表实现多对多的关联
    @JoinTable(
    name = "BooksRecords", //指定第三张表名
    joinColumns = @JoinColumn(name = "lendrecordId"), //book表在第三张表中的外键
    inverseJoinColumns = @JoinColumn(name = "bookId")//record表在第三张表中的外键
    )
	private Set<BeanBook> books=new HashSet<BeanBook>();
	
	public Set<BeanBook> getBooks() {
		return books;
	}
	public void setBooks(Set<BeanBook> books) {
		this.books = books;
	}
	public BeanReader getReader() {
		return reader;
	}
	public void setReader(BeanReader reader) {
		this.reader = reader;
	}
	public int getLendrecordId() {
		return lendrecordId;
	}
	public void setLendrecordId(int lendrecordId) {
		this.lendrecordId = lendrecordId;
	}
	public int getReaderId() {
		return readerId;
	}
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public Date getLendDate() {
		return lendDate;
	}
	public void setLendDate(Date lendDate) {
		this.lendDate = lendDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getPenalty() {
		return penalty;
	}
	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}
	
}
