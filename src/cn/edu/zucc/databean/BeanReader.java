package	cn.edu.zucc.databean;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
@Entity
@Table(name = "reader")
public class BeanReader {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "reader_id", unique = true, nullable = false)
	private int readerId;
	@Column(name = "reader_name")
	private String reader_Name;
	@Column(name = "readertype_id")
	private int readertypeId;
	@Column(name = "password")
	private String password;
	@Column(name = "lend_number")
	private int lendNumber;
	@Column(name = "create_date")
	private Date createDate;
	@Column(name = "is_delete")
	private int isDelete;
	
	@ManyToOne(fetch=FetchType.LAZY) //fetch: 设置了延迟加载 ，默认为立即加载，不设置则会和bookType表外连接查询
    @JoinColumn(name="readertypeId")
	private BeanReaderType readerType;
	
	@OneToMany(mappedBy="reader",cascade={CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.FALSE) //设置立即加载,默认为延迟加载
    private Set<BeanLendRecord> records = new HashSet<BeanLendRecord>();// 图书集合
	
	public BeanReaderType getReaderType() {
		return readerType;
	}
	public void setReaderType(BeanReaderType readerType) {
		this.readerType = readerType;
	}
	public Set<BeanLendRecord> getRecords() {
		return records;
	}
	public void setRecords(Set<BeanLendRecord> records) {
		this.records = records;
	}
	public int getReaderId() {
		return readerId;
	}
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
	public String getReader_Name() {
		return reader_Name;
	}
	public void setReader_Name(String reader_Name) {
		this.reader_Name = reader_Name;
	}
	public int getReadertypeId() {
		return readertypeId;
	}
	public void setReadertypeId(int readertypeId) {
		this.readertypeId = readertypeId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLendNumber() {
		return lendNumber;
	}
	public void setLendNumber(int lendNumber) {
		this.lendNumber = lendNumber;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
}
