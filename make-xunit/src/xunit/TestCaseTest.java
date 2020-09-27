package xunit;

public class TestCaseTest extends TestCase{

    public TestCaseTest(String name) {
        super(name);
    }

    WasRun wasRun;

    @Override
    public void setUp(){
        wasRun = new WasRun("testMethod");
    }

    public void testRunning(){
        // assert wasRun.wasRun == false; 의미있는 값들을 확인하기 어렵다.
        Assert.assertEquals(false, wasRun.wasRun);
        wasRun.run();
        Assert.assertEquals(true, wasRun.wasRun);
    }

    public void testSetUp(){
        // assert wasRun.wasRun == false; 의미있는 값들을 확인하기 어렵다.
        Assert.assertEquals(false, wasRun.wasSetUp);
        wasRun.run();
        Assert.assertEquals(true, wasRun.wasSetUp);
    }
}
