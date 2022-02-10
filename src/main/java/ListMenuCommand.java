
import org.json.JSONArray;
import org.json.JSONObject;
import picocli.CommandLine.Command;
import picocli.CommandLine.ParentCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        BufferedReader reponse = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = reponse.readLine()) != null) {
            content.append(inputLine);
        }
        reponse.close();
        JSONArray JsonContent = new JSONArray(content);
        for (int i = 0 ; i < JsonContent.length(); i++) {
            JSONObject menu = JsonContent.getJSONObject(i);
            //int userId = album.getInt("userId");
            //int id = album.getInt("id");
            //String title = album.getString("title");
            System.out.println(menu);
        }
        System.out.println(content);
        return null;
    }
}
