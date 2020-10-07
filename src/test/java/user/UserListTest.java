package user;


import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserListTest {

    @Test
    void getUserList_AllMatch() {
        List<User> userList = getUserList();

        assertTrue(userList.stream().allMatch(user -> user.getId() <= 50));
    }

    /**
     * console output:<br>
     * "expected:&lt;true&gt; but was: &lt;false&gt;"
     */
    @Test
    void getUserList_AllMatch_fails() {
        List<User> userList = getUserList2();

        assertTrue(userList.stream().allMatch(user -> user.getId() <= 50));
    }

    @Test
    void getUserList_Filter() {
        List<User> userList = getUserList();

        List<User> filtered = userList.stream()
            .filter(user -> !(user.getId() <= 50))
            .collect(Collectors.toList());
        assertEquals(Collections.emptyList(), filtered);
    }

    /**
     * console output:<br>
     * "expected:&lt;[]&gt; but was: &lt;[User(id=60)]&gt;"
     */
    @Test
    void getUserList_Filter_fails() {
        List<User> userList = getUserList2();

        List<User> filtered = userList.stream()
            .filter(user -> !(user.getId() <= 50))
            .collect(Collectors.toList());
        assertEquals(Collections.emptyList(), filtered);
    }

    private List<User> getUserList() {
        return List.of(
            new User(10),
            new User(20),
            new User(30),
            new User(40),
            new User(50)
        );
    }

    private List<User> getUserList2() {
        return List.of(
            new User(10),
            new User(20),
            new User(30),
            new User(40),
            new User(50),
            new User(60)
        );
    }

}
