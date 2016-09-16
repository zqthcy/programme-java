package programme.zk.com;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by lhy on 9/16/16.
 */
public class ZkConnection {

    private ZooKeeper zk;
    /**
     * server列表, 以逗号分割
     */
    protected String hosts = "localhost:2181";
    /**
     * 连接的超时时间, 毫秒
     */
    private static final int SESSION_TIMEOUT = 5000 * 100000;

    public ZkConnection() throws IOException {
        zk = new ZooKeeper(hosts, SESSION_TIMEOUT, null);
    }

    /**
     * 创建临时节点
     */
    public String create(String nodePath, byte[] data, CreateMode mode) throws Exception {
        return zk.create(nodePath, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, mode);
    }
}
