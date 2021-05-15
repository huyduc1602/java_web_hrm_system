package tsg.net.vn.hrmweb.model;

import java.util.ArrayList;

import tsg.net.vn.hrmweb.dto.PositionDTO;

public class ClientWithPositionListWrapper {
	
	private ArrayList<PositionDTO> clientList;

	   public ArrayList<PositionDTO> getClientList() {
	      return clientList;
	   }
	   public void setClientList(ArrayList<PositionDTO> clients) {
	      this.clientList = clients;
	   }
}
