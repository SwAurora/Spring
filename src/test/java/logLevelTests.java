import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class logLevelTests
{
    @Test
    public void test()
    {
        log.trace("traceTest");
        log.debug("DebugTest");
        log.info("InfoTest");
        log.warn("warnTest");
    }
}
