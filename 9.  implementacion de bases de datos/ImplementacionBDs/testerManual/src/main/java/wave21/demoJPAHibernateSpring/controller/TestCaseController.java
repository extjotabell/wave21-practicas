package wave21.demoJPAHibernateSpring.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wave21.demoJPAHibernateSpring.model.TestCase;
import wave21.demoJPAHibernateSpring.service.ITestCaseService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TestCaseController {

    @Autowired
    private ITestCaseService ITestCaseService;

    @PostMapping("/testcases/new")
    public ResponseEntity<?> createTestCase(@RequestBody TestCase tc){
        return ITestCaseService.saveTestCase(tc);
    }

    @GetMapping("/testcases")
    public List<TestCase> getTestCases(){
        return ITestCaseService.getTestCase();
    }

    @GetMapping("/testcases/{id}")
    public TestCase getTestCaseById(@PathVariable long id){
        return ITestCaseService.findTestCase(id);
    }

    @PutMapping("/testcases/{id}")
    public ResponseEntity<?> editTestCase(@PathVariable long id, @RequestBody TestCase testCase) {
        TestCase tc = ITestCaseService.findTestCase(id);
        tc.setDescription(testCase.getDescription());
        tc.setTested(testCase.getTested());
        tc.setPassed(testCase.getPassed());
        tc.setNumber_of_tries(testCase.getNumber_of_tries());
        tc.setLast_updated(testCase.getLast_updated());
        return ITestCaseService.saveTestCase(tc);
    }


    @DeleteMapping("/testcases/delete/{id}")
    public ResponseEntity<?> deleteTestCase (@PathVariable long id){
        return ITestCaseService.deleteTestCase(id);
    }

    @GetMapping("/api/testcases?last_update={date}")
    public List<TestCase> getTestCasesAfterDate(@PathVariable("date") @JsonFormat(pattern="dd-MM-yyyy") LocalDate date){
        return ITestCaseService.getTestCaseByDate(date);
    }

}
