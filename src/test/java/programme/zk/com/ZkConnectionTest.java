package programme.zk.com;

import org.apache.zookeeper.CreateMode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lhy on 9/16/16.
 */
public class ZkConnectionTest {
    private ZkConnection zkConnection;
    private String createPath = "/createPath";
    private String data = "datadfdsafsa";

    @Before
    public void setUp() throws Exception {
        zkConnection = new ZkConnection();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void create() throws Exception {
        int i = 0;
        while (i < 10) {
            String result = zkConnection.create(
                    createPath + i, data.getBytes(), CreateMode.EPHEMERAL);

            assertNotNull(result);
            ++i;
        }
    }

}