package guest.model;

public class reservationBean {
	private int reservationID;
	private String guestICNumber;
	private String guestQuantity;
	private String durationOfStay;
	private String dateStart;
	private String dateEnd;
	private String totalAdult;
	private String totalKids;
	private String reserveStatus;
	private String totalRoom;
	private String totalPayment;
	private String staffICNumber;
	
	
	public int getReservationID() {
		return reservationID;
	}
	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}
	public String getGuestICNumber() {
		return guestICNumber;
	}
	public void setGuestICNumber(String guestICNumber) {
		this.guestICNumber = guestICNumber;
	}
	public String getGuestQuantity() {
		return guestQuantity;
	}
	public void setGuestQuantity(String guestQuantity) {
		this.guestQuantity = guestQuantity;
	}
	public String getDurationOfStay() {
		return durationOfStay;
	}
	public void setDurationOfStay(String durationOfStay) {
		this.durationOfStay = durationOfStay;
	}
	public String getDateStart() {
		return dateStart;
	}
	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}
	public String getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}
	public String getTotalAdult() {
		return totalAdult;
	}
	public void setTotalAdult(String totalAdult) {
		this.totalAdult = totalAdult;
	}
	public String getTotalKids() {
		return totalKids;
	}
	public void setTotalKids(String totalKids) {
		this.totalKids = totalKids;
	}
	public String getReserveStatus() {
		return reserveStatus;
	}
	public void setReserveStatus(String reserveStatus) {
		this.reserveStatus = reserveStatus;
	}
	public String getTotalRoom() {
		return totalRoom;
	}
	public void setTotalRoom(String totalRoom) {
		this.totalRoom = totalRoom;
	}
	public String getTotalPayment() {
		return totalPayment;
	}
	public void setTotalPayment(String totalPayment) {
		this.totalPayment = totalPayment;
	}
	public String getStaffICNumber() {
		return staffICNumber;
	}
	public void setStaffICNumber(String staffICNumber) {
		this.staffICNumber = staffICNumber;
	}
}
