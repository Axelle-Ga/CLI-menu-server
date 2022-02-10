import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import picocli.CommandLine.Parameters;

import java.io.File;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

@Command(name = "menucli", mixinStandardHelpOptions = true, version = "checksum 4.0",subcommands = {
        ListMenuCommand.class
},
        description = "Prints the checksum (SHA-256 by default) of a file to STDOUT.")
class MenuCli implements Callable<Integer> {

    @Option(names = "--server-url", description = "Address of the server to call")
    private String server = "https://menu-server-axelle.herokuapp.com/";

    @Override
    public Integer call() throws Exception { // your business logic goes here...
        System.out.println(this.server);
        return 0;
    }

    // this example implements Callable, so parsing, error handling and handling user
    // requests for usage help or version help can be done with one line of code.
    public static void main(String... args) {
        int exitCode = new CommandLine(new MenuCli()).execute(args);
        System.exit(exitCode);
    }

    public String getServer() {
        return server;
    }
}
