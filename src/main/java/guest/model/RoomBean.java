package guest.model;

public class RoomBean {
	private String roomNum;
	private String roomType;
	private int maxGuest;
	private String roomSize;
	private String roomStatus;

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String i) {
		this.roomNum = i;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getMaxGuest() {
		return maxGuest;
	}

	public void setMaxGuest(int maxGuest) {
		this.maxGuest = maxGuest;
	}

	
	public String getRoomSize() {
		return roomSize;
	}

	public void setRoomSize(String roomSize) {
		this.roomSize = roomSize;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
}
