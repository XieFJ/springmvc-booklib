package cn.edu.zucc.booklib.databean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "lend_detail")
public class BeanDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "detail_id", unique = true, nullable = false)
	private int detailId;
	@Column(name = "lend_date")
	private Date lendDate;
	@Column(name = "due_date")
	private Date dueDate;
	@Column(name = "return_date")
	private Date returnDate;
	@Column(name = "penalty")
	private double penalty;
	
	@ManyToOne(fetch=FetchType.LAZY) //fetch: 设置了延迟加载 ，默认为立即加载，不设置则会和reader表外连接查询
    @JoinColumn(name="reader_id")
	private BeanReader reader;
	
	@ManyToOne(fetch=FetchType.LAZY) 
    @JoinColumn(name="book_id")
	private BeanBook book;
	
	@ManyToOne(fetch=FetchType.LAZY) 
    @JoinColumn(name="lendrecord_id")
	private BeanLendRecord record;

	public BeanBook getBook() {
		return book;
	}
	public void setBook(BeanBook book) {
		this.book = book;
	}
	public BeanLendRecord getRecord() {
		return record;
	}
	public void setRecord(BeanLendRecord record) {
		this.record = record;
	}	
	public int getDetailId() {
		return detailId;
	}
	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}
	public BeanReader getReader() {
		return reader;
	}
	public void setReader(BeanReader reader) {
		this.reader = reader;
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
	public double getPenalty() {
		return penalty;
	}
	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}
	
}

