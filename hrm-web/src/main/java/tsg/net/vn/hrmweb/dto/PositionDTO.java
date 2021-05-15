package tsg.net.vn.hrmweb.dto;
public class PositionDTO {
	
	private Boolean selected;
	private Long posId;
	private String posName;
	private String posCode;
	private String posDesc;
	public PositionDTO() {
		
	}
	public PositionDTO(Boolean selected, Long posId, String posName, String posCode, String posDesc) {
		super();
		this.selected = selected;
		this.posId = posId;
		this.posName = posName;
		this.posCode = posCode;
		this.posDesc = posDesc;
	}
	public Boolean getSelected() {
		return selected;
	}
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
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
	
}
