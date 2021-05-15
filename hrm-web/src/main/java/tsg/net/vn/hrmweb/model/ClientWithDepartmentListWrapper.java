package tsg.net.vn.hrmweb.model;

import java.util.ArrayList;

import tsg.net.vn.hrmweb.dto.DepartmentDTO;

public class ClientWithDepartmentListWrapper {
	
	private ArrayList<DepartmentDTO> clientList;

	   public ArrayList<DepartmentDTO> getClientList() {
	      return clientList;
	   }
	   public void setClientList(ArrayList<DepartmentDTO> clients) {
	      this.clientList = clients;
	   }
}
