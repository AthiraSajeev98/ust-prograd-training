import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoteKeeperTest {
    NoteKeeper noteKeeper = new NoteKeeper();

    @BeforeEach
    public void AddItems() {
        noteKeeper.addList("Drink Water",true);
        noteKeeper.addList("Eat Healthy",false);
        noteKeeper.addList("Exercise Daily",true);
        noteKeeper.addList("Sleep on Time",false);
    }


    @Test
    public void AddItemsToTodoListTest() {
        String actualList = noteKeeper.checkList("Drink Water");
        assertEquals("Drink Water", actualList);
    }


    @Test
    public void RemoveItemsFromTodoListTest() {
        boolean actualList = noteKeeper.removeList("Eat Healthy");
        assertEquals(true, actualList);
    }


    @Test
    public void unRemoveItemsFromTodoListTest() {
        boolean actualList = noteKeeper.unRemoveList("Eat Healthy");
        assertEquals(true, actualList);
    }


    @Nested
    public class toggleBetweenCompletedAndNotCompletedTodoListTest {

        @Test
        public void checkIfTaskIsCompleted() {
            boolean actualList = noteKeeper.completedOrNotCompleted("Drink Water");
            assertEquals(true, actualList);
        }

        @Test
        public void checkIfTaskIsNotCompleted() {
            boolean actualList = noteKeeper.completedOrNotCompleted("Eat Healthy");
            assertEquals(false, actualList);
        }
    }
}

//1. As a note keeper I want to add items to my todo list.
//2. As a note keeper I want to remove items from my todo list.
//3. As a note keeper, I want to be able to bring back the removed items. (un remove)
//4. As a note keeper, I want to toggle between completed and not completed.