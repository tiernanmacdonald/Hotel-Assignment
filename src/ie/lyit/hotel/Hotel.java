package ie.lyit.hotel;

import java.util.ArrayList;

public class Hotel {
	ArrayList<Room> rooms;
	ArrayList<Booking> bookings;
	
	public Hotel() {
		rooms=new ArrayList<Room>(); //Arraylist of rooms
		bookings=new ArrayList<Booking>(); //Arraylist of bookings
		populateRooms();
	}
	
	
	public void populateRooms() { //Method to populate arraylist with rooms
				// Add 10 Double Rooms
				for(int i=1;i<=10;i++)
					rooms.add(new Room(2,0,85.00,i));		
				// Add 8 Family Rooms
				for(int i=11;i<=18;i++)
					rooms.add(new Room(2,2,120.00,i));				

				/* Display Room’s
				System.out.println("ROOMS IN HOTEL");
				for(Room room:rooms)
					System.out.println(room);*/
	}
	
	public Room findAvailableRoom(int noAdults, int noKids) { //Method to find all available unallocated rooms
		
		for(Room tmpRoom : rooms) { //for each loop to check every object in the room list
			if(tmpRoom.getMaxAdults() >= noAdults || tmpRoom.getMaxKids() >= noKids && tmpRoom.getAllocated() != true) {
				tmpRoom.setAllocated(true); //false booleans set to true
				return tmpRoom;
			}
			}
			return null;
	}
	
	public Room getRooms() { //Method to return a list of all rooms
		for(Room tmpRoom : rooms) {
		return tmpRoom;}
		return null;
	}
	
	public Booking getBookings() { //Method to return a list of all bookings
		for(Booking tmpBooking : bookings) {
			return tmpBooking;}
			return null;
	}
	
	public void addBooking(Booking booking) {		
		bookings.add(booking); // method will add a new specified booking object to the booking list
	}

}
