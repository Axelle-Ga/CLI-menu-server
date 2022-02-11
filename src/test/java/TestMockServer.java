import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.mockserver.integration.ClientAndServer;

public class TestMockServer {

    private ClientAndServer mockServer;

    @BeforeClass
    public void startServer() {
        mockServer = ClientAndServer.startClientAndServer(1080);
    }
 
    @AfterClass 
    public void stopServer() { 
        mockServer.stop();
    }
}