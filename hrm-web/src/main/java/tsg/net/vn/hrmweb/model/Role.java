package tsg.net.vn.hrmweb.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@Column(name="role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;
	@Column(name = "role_name")
	private String roleName;
	@Column(name = "role_code")
	private String roleCode;
	
	@OneToMany(mappedBy = "role")
	private List<UserRole> userRoleList;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public List<UserRole> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<UserRole> userRoleList) {
		this.userRoleList = userRoleList;
	}

	public Role(Long roleId, String roleName, String roleCode, List<UserRole> userRoleList) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleCode = roleCode;
		this.userRoleList = userRoleList;
	}
	
	public Role() {
		
	}
}
