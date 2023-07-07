package wave21.demoJPAHibernateSpring.service;

import org.springframework.http.ResponseEntity;
import wave21.demoJPAHibernateSpring.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    public List<TestCase> getTestCase();
    public ResponseEntity<?> saveTestCase (TestCase stu);
    public ResponseEntity<?> deleteTestCase (Long id);
    public TestCase findTestCase (Long id);
    List<TestCase> getTestCaseByDate(LocalDate date);
}
