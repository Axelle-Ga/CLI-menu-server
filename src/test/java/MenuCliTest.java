import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

import picocli.CommandLine;

public class MenuCliTest {

    private Runtime rt = Runtime.getRuntime();

    private String addressServer;

    @Rule
    public GenericContainer menusServer = new GenericContainer(DockerImageName.parse("mailysm/menu-server:1.0.0:latest"))
                                        .withExposedPorts(8080);

    @Before
    public void setUp() {
        String address = menusServer.getHost();
        Integer port = menusServer.getFirstMappedPort();
        addressServer = "http://"+address + ":"+port+"/";
        try {
            rt.exec("curl -H \"Content-Type: application/json\" --data-raw \'{\"name\": \"Menu spécial du chef\", \"dishes\": [{\"name\": \"Bananes aux fraises\"},{\"name\": \"Bananes flambées\"}]}\' " + addressServer+"menus");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // @Test
    // public void testDeleteMenuCommandLine() {

    //     String[] args = { "--server-url", addressServer, "delete-menu", "--","0"};
    //     int exitCode = new CommandLine(new MenuCli()).execute(args);
    //     assertEquals(1,exitCode);
    // }

    // @Test
    // public void testDeleteMenuCommandLineNotExisting() {

    //     String[] args = { "--server-url", addressServer, "delete-menu", "--","1"};
    //     int exitCode = new CommandLine(new MenuCli()).execute(args);
    //     assertEquals(0,exitCode);
    // }
}