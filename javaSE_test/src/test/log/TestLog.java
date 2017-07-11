package test.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试SLF4J的使用
 * @author chen
 *
 */
public class TestLog {

	private static final Logger log = LoggerFactory.getLogger(TestLog.class);
	
	public static void main(String[] args) {
		log.info("abc");
		log.debug("xyz");
		log.debug(" id: {} and symbol : {} ", "a", "abc");
	}

}
