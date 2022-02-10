import picocli.CommandLine;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@CommandLine.Command(
        name = "delete"
)
public class MenuCliDelete implements Runnable {

    @CommandLine.Parameters(index = "0", description = "Id of the menu to delete")
    private Integer id;

    @CommandLine.ParentCommand
    private MenuCli menuCli;

    @Override
    public void run() {
        System.out.println("DeleteMenu");
        String urlString = this.menuCli.getServer()+"menus/"+this.id;
        try {
            System.out.println(urlString);
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("DELETE");
            int status = con.getResponseCode();
            System.out.println(status);
        }
        catch (IOException e1){
            System.out.println("Exception");
        }




    }
}
