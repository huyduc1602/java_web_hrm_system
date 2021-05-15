package tsg.net.vn.hrmweb.dto;
public class DepartmentDTO {
	private Boolean selected;
	private Long deId;
	private String deName;
	private String deCode;
	private String deDesc;
	public DepartmentDTO() {
		
	}
	public DepartmentDTO(Boolean selected, Long deId, String deName, String deCode, String deDesc) {
		super();
		this.selected = selected;
		this.deId = deId;
		this.deName = deName;
		this.deCode = deCode;
		this.deDesc = deDesc;
	}
	public Boolean getSelected() {
		return selected;
	}
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
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
	
	
}
