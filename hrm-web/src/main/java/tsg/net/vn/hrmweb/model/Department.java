package tsg.net.vn.hrmweb.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@Column(name = "de_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deId;
	@Column(name = "de_name")
	private String deName;
	@Column(name = "de_code")
	private String deCode;
	@Column(name = "de_desc")
	private String deDesc;
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<DepartmentEmployee> departmentEmpList;

	public Long getDeId() {
		return deId;
	}

	public void setDeId(Long deId) {
		this.deId = deId;
	}

	public String getDeName() {
		return deName;
	}

	public void setDeName(String deName) {
		this.deName = deName;
	}

	public String getDeCode() {
		return deCode;
	}

	public void setDeCode(String deCode) {
		this.deCode = deCode;
	}

	public String getDeDesc() {
		return deDesc;
	}

	public void setDeDesc(String deDesc) {
		this.deDesc = deDesc;
	}

	public List<DepartmentEmployee> getDepartmentEmpList() {
		return departmentEmpList;
	}

	public void setDepartmentEmpList(List<DepartmentEmployee> departmentEmpList) {
		this.departmentEmpList = departmentEmpList;
	}

	public Department(Long deId, String deName, String deCode, String deDesc,
			List<DepartmentEmployee> departmentEmpList) {
		super();
		this.deId = deId;
		this.deName = deName;
		this.deCode = deCode;
		this.deDesc = deDesc;
		this.departmentEmpList = departmentEmpList;
	}
	
	public Department() {
		
	}
	
}
