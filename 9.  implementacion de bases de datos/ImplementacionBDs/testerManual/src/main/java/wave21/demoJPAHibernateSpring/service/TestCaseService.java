package wave21.demoJPAHibernateSpring.service;

import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import wave21.demoJPAHibernateSpring.model.TestCase;
import wave21.demoJPAHibernateSpring.repository.TestCaseRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService {

    private final TestCaseRepository testcaseRepository;

    public TestCaseService(TestCaseRepository testCaseRepository) {
        this.testcaseRepository = testCaseRepository;
    }

    @Override
    @Transactional
    public List<TestCase> getTestCase() {
        return testcaseRepository.findAll();
    }

    @Override
    @Transactional
    public ResponseEntity<?> saveTestCase(TestCase testCase) {
        testcaseRepository.save(testCase);
        return ResponseEntity.ok("Test Case nro " + testCase.getId_case() + " guardada con éxtio");
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteTestCase(Long id) {
        if(testcaseRepository.existsById(id)){
            testcaseRepository.deleteById(id);
            return ResponseEntity.ok("Test Case nro " + id + " eliminada con éxtio");
        }else{
            return ResponseEntity.ok("Test Case nro " + id + " no existe.");

        }

    }

    @Override
    @Transactional
    public TestCase findTestCase(Long id) {
        return testcaseRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<TestCase> getTestCaseByDate(LocalDate date){
        return testcaseRepository.findAll()
                .stream()
                .filter(testCase -> testCase.getLast_updated()
                        .isAfter(date))
                .toList();
    }
}
