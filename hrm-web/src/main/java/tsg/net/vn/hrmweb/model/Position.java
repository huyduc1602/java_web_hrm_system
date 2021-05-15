package tsg.net.vn.hrmweb.model;

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

@Entity
@Table(name = "position")
public class Position {

	@Id
	@Column(name = "pos_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long posId;
	@Column(name = "pos_name")
	private String posName;
	@Column(name = "pos_code")
	private String posCode;
	@Column(name = "pos_desc")
	private String posDesc;

	@OneToMany(mappedBy = "position", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<PositionEmployee> positionEmpList;

	public Long getPosId() {
		return posId;
	}

	public void setPosId(Long posId) {
		this.posId = posId;
	}

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}

	public String getPosCode() {
		return posCode;
	}

	public void setPosCode(String posCode) {
		this.posCode = posCode;
	}

	public String getPosDesc() {
		return posDesc;
	}

	public void setPosDesc(String posDesc) {
		this.posDesc = posDesc;
	}

	public List<PositionEmployee> getPositionEmpList() {
		return positionEmpList;
	}

	public void setPositionEmpList(List<PositionEmployee> positionEmpList) {
		this.positionEmpList = positionEmpList;
	}

	public Position(Long posId, String posName, String posCode, String posDesc,
			List<PositionEmployee> positionEmpList) {
		super();
		this.posId = posId;
		this.posName = posName;
		this.posCode = posCode;
		this.posDesc = posDesc;
		this.positionEmpList = positionEmpList;
	}

	public Position() {
		
	}
}
