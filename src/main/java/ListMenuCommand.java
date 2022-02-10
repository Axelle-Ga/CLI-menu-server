
import picocli.CommandLine.Command;
import picocli.CommandLine.ParentCommand;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.concurrent.Callable;

@Command(name = "list-menus")
public class ListMenuCommand implements Callable<String> {

    @ParentCommand
    private MenuCli mainCommande;


    @Override
    public String call() throws Exception {
        String urlListMenu = mainCommande.getServer()+"menus";
        URL url = new URL(urlListMenu);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        String response = con.getResponseMessage();
        System.out.println(response);
        return null;
    }
}
