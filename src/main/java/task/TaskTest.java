package task;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TaskTest {

    @Test
    @DisplayName("Task ID cannot have more than 10 characters")
    void testTaskIDWithMoreThanTenCharacters() {
        Task task = new Task("Name", "Description");
        if (task.getTaskID().length() > 10) {
            fail("Task ID has more than 10 characters.");
        }
    }

    @Test
    @DisplayName("Task Name cannot have more than 20 characters")
    void testTaskNameWithMoreThanTwentyCharacters() {
        Task task = new Task("My Task Name, which has 38 characters", "Description");
        if (task.getTaskName().length() > 20) {
            fail("Task Name has more than 20 characters.");
        }
    }

    @Test
    @DisplayName("Task Description cannot have more than 50 characters")
    void testTaskDescWithMoreThanFiftyCharacters() {
        Task task = new Task("Name", "My Task Description has 73 characters, and I love \n" +
                "this task description.");
        if (task.getTaskDesc().length() > 50) {
            fail("Task Description has more than 50 characters.");
        }
    }

    @Test
    @DisplayName("Task Name shall not be null")
    void testTaskNameNotNull() {
        Task task = new Task(null, "Description");
        assertNotNull(task.getTaskName(), "Task Name was null.");
    }

    @Test
    @DisplayName("Task Description shall not be null")
    void testTaskDescNotNull() {
        Task task = new Task("Name", null);
        assertNotNull(task.getTaskDesc(), "Task Description was null.");
    }
}