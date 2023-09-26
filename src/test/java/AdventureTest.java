import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdventureTest {

@Test
public void always_True() {
    assertTrue(1 == 1);
}

@Test
public void find_Current_Room() {
    //Arrange
    String expected = "Room 1";
    Adventure adventure = new Adventure();
    //Act
    adventure.buildMap();
    //Assert
    assertEquals(expected, adventure.getCurrentRoom().getName());
}

@Test
public void move_From_Current_Position_TO_ROOM2() {
    //Arrange
    String expected = "Room 2";
    Adventure adventure = new Adventure();
    adventure.buildMap();
    //Act
   // adventure.moveToRoom("Room 2");
    //Assert
    assertEquals("Room 2", adventure.getCurrentRoom().getName());
}

}