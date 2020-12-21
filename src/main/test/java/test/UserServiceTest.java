package test;

import com.medecineproject.project.ProjectApplication;
import com.medecineproject.project.model.Doctor;
import com.medecineproject.project.model.User;
import com.medecineproject.project.service.DoctorService;
import com.medecineproject.project.service.UserService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProjectApplication.class)
public class UserServiceTest {
    @Autowired
    private UserService rep;

    @Test
    public void findByIdTest() {
        User expected = new User(1, "Danylo", "Ant", "user", "user123");
        User current = rep.readById(1);

        Assertions.assertEquals(expected, current);
    }

    @Test
    public void allDoctorsTest() {
        List<User> expected = new ArrayList<>(List.of(rep.readById(1), rep.readById(6), rep.readById(10), rep.readById(93), rep.readById(72)));

        List<User> current = rep.findAll();

        Assertions.assertEquals(expected, current);
    }

    @Test
    public void readByLogin() {
        User expected = new User(1, "Danylo", "Ant", "user", "user123");
        User current = rep.readByLogin("user");

        Assertions.assertEquals(expected, current);
    }
}
