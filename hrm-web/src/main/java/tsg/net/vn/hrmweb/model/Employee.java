package tsg.net.vn.hrmweb.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "em_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long emId;
	@Column(name = "name")
	private String name;
	@Column(name = "birthday")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthday;
	@Column(name = "general")
	private Long general;
	@Column(name = "address")
	private String address;
	@Column(name = "start_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date startDate;
	@Column(name = "end_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date endDate;
	@Column(name = "result")
	private String result;
	@Column(name = "it")
	private String it;
	@Column(name = "language")
	private String language;
	@Column(name = "major")
	private String major;

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<PositionEmployee> positionEmpList;

	@OneToMany(mappedBy = "employee")
	private List<DepartmentEmployee> departmentEmpList;

	public Long getEmId() {
		return emId;
	}

	public void setEmId(Long emId) {
		this.emId = emId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Long getGeneral() {
		return general;
	}

	public void setGeneral(Long general) {
		this.general = general;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getIt() {
		return it;
	}

	public void setIt(String it) {
		this.it = it;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public List<PositionEmployee> getPositionEmpList() {
		return positionEmpList;
	}

	public void setPositionEmpList(List<PositionEmployee> positionEmpList) {
		this.positionEmpList = positionEmpList;
	}

	public List<DepartmentEmployee> getDepartmentEmpList() {
		return departmentEmpList;
	}

	public void setDepartmentEmpList(List<DepartmentEmployee> departmentEmpList) {
		this.departmentEmpList = departmentEmpList;
	}

	public Employee(Long emId, String name, Date birthday, Long general, String address, Date startDate, Date endDate,
			String result, String it, String language, String major, List<PositionEmployee> positionEmpList,
			List<DepartmentEmployee> departmentEmpList) {
		super();
		this.emId = emId;
		this.name = name;
		this.birthday = birthday;
		this.general = general;
		this.address = address;
		this.startDate = startDate;
		this.endDate = endDate;
		this.result = result;
		this.it = it;
		this.language = language;
		this.major = major;
		this.positionEmpList = positionEmpList;
		this.departmentEmpList = departmentEmpList;
	}

	public Employee() {
		
	}
}