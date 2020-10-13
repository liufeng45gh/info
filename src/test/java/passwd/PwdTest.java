package passwd;

import com.lucifer.utils.Md5Utils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class PwdTest {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void generatePwd(){
        String md5 = Md5Utils.md5("admin"+"1111");
        logger.info(md5);
    }
}
