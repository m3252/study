package xunit;

import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSuite implements Test{

    List<Test> tests = new ArrayList<>();

    public TestSuite(Class<? extends TestCase> testCaseTestClass) {
        Arrays.stream(testCaseTestClass.getMethods())
        .filter(m -> AnnotationUtils.findAnnotation(m, xunit.annotation.Test.class) != null)
        .forEach(m ->{
            try {
                add(testCaseTestClass.getConstructor(String.class).newInstance(m.getName()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        ;
    }

    public void add(Test test) {
        tests.add(test);
    }

    public void run(TestResult result) {
        tests.forEach(t-> {
            t.run(result);
        });
    }

    public TestSuite(){

    }
}
