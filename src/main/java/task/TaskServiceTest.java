package task;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

    @Test
    @DisplayName("Test updating a task name.")
    @Order(1)
    void testUpdateTaskName() {
        TaskService service = new TaskService();
        service.addTask("Task Name", "Description");
        service.updateTaskName("Update Task Name", "3");
        service.displayTaskList();
        assertEquals("Update Task Name", service.getTask("3").getTaskName(), "Task name FAILED to update.");
    }

    @Test
    @DisplayName("Test updating a task description.")
    @Order(2)
    void testUpdateTaskDesc() {
        TaskService service = new TaskService();
        service.addTask("Task Name", "Description");
        service.updateTaskDesc("Update Description", "1");
        service.displayTaskList();
        assertEquals("Update Description", service.getTask("1").getTaskDesc(), "Task description FAILED to update.");
    }

    @Test
    @DisplayName("Test deleting a task.")
    @Order(5)
    void testDeleteContact() {
        TaskService service = new TaskService();
        service.addTask("Task Name", "Description");
        service.deleteTask("0");
        ArrayList<Task> taskListEmpty = new ArrayList<Task>();
        service.displayTaskList();
        assertEquals(service.taskList, taskListEmpty, "The contact FAILED to delete.");
    }

    @Test
    @DisplayName("Test adding a task.")
    @Order(6)
    void testAddContact() {
        TaskService service = new TaskService();
        service.addTask("Task Name", "Description");
        service.displayTaskList();
        assertNotNull(service.getTask("0"), "Task FAILED to add.");
    }
}
