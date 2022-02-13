import picocli.CommandLine;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "delete-menu"
)
public class MenuCliDelete implements Callable<Integer> {

    @CommandLine.Parameters(index = "0", description = "Id of the menu to delete")
    private Integer id ;

    @CommandLine.ParentCommand
    private MenuCli menuCli;

    @Override
    public Integer call() {
        System.out.println("DeleteMenu");
        String urlString = this.menuCli.getServer()+"menus/"+this.id;
        try {
            System.out.println(urlString);
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("DELETE");
            int status = con.getResponseCode();
            if (status == 200) {
                System.out.println( "Menu "+this.id+" supprimé" );
                return 0;
            } else {
                System.out.println( "Une erreur est survenue..." );
                System.out.println(String.valueOf(status));
                return 1;
            }
            
        }
        catch (IOException e1){
            System.out.println("Exception");
            return 1;
        }




    }
}
