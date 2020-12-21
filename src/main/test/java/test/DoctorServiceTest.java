package test;

import com.medecineproject.project.ProjectApplication;
import com.medecineproject.project.model.Doctor;
import com.medecineproject.project.service.DoctorService;
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
public class DoctorServiceTest {
    @Autowired
    private DoctorService rep;

    @Test
    public void findByIdTest() {
        Doctor expected = new Doctor(2, "Apple", "Antypenko", "Psychiatrist", 3, 0, "doctor", "test123");
        Doctor current = rep.readById(2);

        Assertions.assertEquals(expected, current);
    }

    @Test
    public void allDoctorsTest() {
        List<Doctor> expected = new ArrayList<>(List.of(rep.readById(2), rep.readById(21), rep.readById(22), rep.readById(23), rep.readById(94)));

        List<Doctor> current = rep.findAll();

        Assertions.assertEquals(expected, current);
    }

    @Test
    public void getTopDocTest() {
        Doctor expected = rep.readById(22);

        Doctor current = rep.readTop();

        Assertions.assertEquals(expected, current);
    }

    @Test
    public void findAllByCategory() {
        List<Doctor> expected = new ArrayList<>(List.of(rep.readById(22), rep.readById(23)));

        List<Doctor> current = rep.findAllByCategory("Cardiologist");

        Assertions.assertEquals(expected, current);
    }

    @Test
    public void readByLogin() {
        Doctor expected = new Doctor(2, "Apple", "Antypenko", "Psychiatrist", 3, 0, "doctor", "test123");
        Doctor current = rep.readByLogin("doctor");

        Assertions.assertEquals(expected, current);
    }
}
