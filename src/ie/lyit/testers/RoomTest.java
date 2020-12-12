package ie.lyit.testers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ie.lyit.hotel.Room;

public class RoomTest {
	private Room r1;

	@Before
	public void setUp() throws Exception {
		r1 = new Room(2,0,85.0,1);
	}

	@Test
	public void testRoomIntIntDoubleInt() {
		r1=new Room(1,0,85,1);
		
		// Check r1's adults is below maximum
		assertEquals(1, r1.getMaxAdults());
		// Check r1's kids is below maximum
		assertEquals("Kids should be 0", 0, r1.getMaxKids());		
	}

	@Test
	public void testToString() {
		//Checks r1's toString outputs the same
		assertEquals("Room should be ROOM 1 [2 adult(s),0 kid(s) @ €85.0 p/n,NOT allocated]","ROOM 1 [2 adult(s),0 kid(s) @ €85.0 p/n,NOT allocated]",r1.toString());
	}
	
	@Test
	public void testSetMaxAdults() {
		r1.setMaxAdults(2);
		// Check the set r1 adults are below maximum
		assertEquals("Expected Adults should be 2",2, r1.getMaxAdults());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetMaxAdultsForException(){
		r1.setMaxAdults(3);
		//test exception handlers for when adults exceed max 
		assertEquals("Expected Adults should not be more than 2", 3, r1.getMaxAdults());
	}

	@Test
	public void testSetMaxKids() {
		r1.setMaxKids(0);
		// Check the set r1 kids are below maximum
		assertEquals("Expected Adults should be 0",0, r1.getMaxKids());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetMaxKidsForException(){
		r1.setMaxKids(4);
		//test exception handlers for when kids exceed max 
		assertEquals("Expected Kids should not be more than 3", 4, r1.getMaxKids());
	}
	
	
	@Test
	public void testSetPricePerNight() {
		r1.setPricePerNight(85.0);
		assertTrue("Expected Price per night should be 85",85.0 == r1.getPricePerNight());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetPricePerNightForException() {
		r1.setPricePerNight(59.0);
		//Test exception handler for when price is below minimum amount
		assertTrue("Expected Price per night should be less than 60",59.0 == r1.getPricePerNight());
	}

	@Test
	public void testSetAllocated() {
		assertTrue("Expected room is NOT allocted",false==r1.getAllocated());
	}

}
