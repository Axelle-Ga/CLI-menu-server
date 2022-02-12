import picocli.CommandLine;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "delete-menu"
)
public class MenuCliDelete implements Callable {

    @CommandLine.Parameters(index = "0", description = "Id of the menu to delete")
    private Integer id;

    @CommandLine.ParentCommand
    private MenuCli menuCli;

    @Override
    public String call() {
        System.out.println("DeleteMenu");
        String urlString = this.menuCli.getServer()+"menus/"+this.id;
        try {
            System.out.println(urlString);
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("DELETE");
            int status = con.getResponseCode();
            return(String.valueOf(status));
        }
        catch (IOException e1){
            return("Exception");
        }




    }
}
