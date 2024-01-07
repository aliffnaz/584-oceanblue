package guest.model;

public class ReservationBean {
	private int reservationID;
	private String guestICNumber;
	private int guestQuantity;
	private int durationOfStay;
	private String dateStart;
	private String dateEnd;
	private int totalAdult;
	private int totalKids;
	private String reserveStatus;
	private int totalRoom;
	private Double totalPayment;
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
	public int getGuestQuantity() {
		return guestQuantity;
	}
	public void setGuestQuantity(int guestQuantity) {
		this.guestQuantity = guestQuantity;
	}
	public int getDurationOfStay() {
		return durationOfStay;
	}
	public void setDurationOfStay(int durationOfStay) {
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
	public int getTotalAdult() {
		return totalAdult;
	}
	public void setTotalAdult(int totalAdult) {
		this.totalAdult = totalAdult;
	}
	public int getTotalKids() {
		return totalKids;
	}
	public void setTotalKids(int totalKids) {
		this.totalKids = totalKids;
	}
	public String getReserveStatus() {
		return reserveStatus;
	}
	public void setReserveStatus(String reserveStatus) {
		this.reserveStatus = reserveStatus;
	}
	public int getTotalRoom() {
		return totalRoom;
	}
	public void setTotalRoom(int totalRoom) {
		this.totalRoom = totalRoom;
	}
	public Double getTotalPayment() {
		return totalPayment;
	}
	public void setTotalPayment(Double totalPayment) {
		this.totalPayment = totalPayment;
	}
	public String getStaffICNumber() {
		return staffICNumber;
	}
	public void setStaffICNumber(String staffICNumber) {
		this.staffICNumber = staffICNumber;
	}
}
