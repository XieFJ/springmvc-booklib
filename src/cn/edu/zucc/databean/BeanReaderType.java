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
@Table(name = "reader_type")
public class BeanReaderType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "readertype_id", unique = true, nullable = false)
	private int readertypeId;
	@Column(name = "readertype_name")
	private String readertypeName;
	@Column(name = "lend_limitted")
	private int lendLimitted;
	@Column(name = "due_time")
	private int dueTime;
	@Column(name = "is_delete")
	private int isDelete;
	
	@OneToMany(mappedBy="readerType",cascade={CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.FALSE) //设置立即加载,默认为延迟加载
    private Set<BeanReader> readers = new HashSet<BeanReader>();// 图书集合
	
	public Set<BeanReader> getReaders() {
		return readers;
	}
	public void setReaders(Set<BeanReader> readers) {
		this.readers = readers;
	}
	public int getReadertypeId() {
		return readertypeId;
	}
	public void setReadertypeId(int readertypeId) {
		this.readertypeId = readertypeId;
	}
	public String getReadertypeName() {
		return readertypeName;
	}
	public void setReadertypeName(String readertypeName) {
		this.readertypeName = readertypeName;
	}
	public int getLendLimitted() {
		return lendLimitted;
	}
	public void setLendLimitted(int lendLimitted) {
		this.lendLimitted = lendLimitted;
	}
	public int getDueTime() {
		return dueTime;
	}
	public void setDueTime(int dueTime) {
		this.dueTime = dueTime;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
}
