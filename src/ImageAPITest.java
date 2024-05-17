import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class ImageAPITest {

    public static void main(String[] args) {
        String[] imageUrls = {
                "https://cdn.nba.com/headshots/nba/latest/1040x760/203999.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1629008.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1629008.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/2544.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/203484.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1627750.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1631128.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1631221.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/202704.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1627752.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/203076.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1631108.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1629216.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/202691.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/101108.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/201939.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1630228.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1630228.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/203994.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/201142.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1626164.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1628973.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1630193.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1628369.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/204001.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1628971.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1630169.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1629614.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1629673.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1626145.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1629023.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1626179.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1630552.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1628969.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1630560.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1627747.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1628384.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1627783.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1629018.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/201144.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/202710.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1631105.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1630595.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/201942.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1629640.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1627763.png",
                "https://cdn.nba.com/headshots/nba/latest/1040x760/1630178.png"

        };

        String[] destinationFiles = {
                "Nikola_Jokic.png","Michael_Porter_Jr.png","Aaron_Gordon.png","Lebron_James.png","Kentavious_Caldwell-Pope.png","Jamal_Murray.png","Christian_Braun.png",
                "Collin_Gillespie.png","Reggie_Jackson.png","Taurean_Prince.png","Anthony_Davis.png","Max_Christie.png","Gabe_Vincent.png","Klay_Thompson.png","Chris_Paul.png",
                "Stephen_Curry.png","Jonathan_Kuminga.png","Dario_Saric.png","Jusuf_Nurkic.png","Kevin_Durant.png","Devin_Booker.png","Jalen_Brunson.png","Immanuel_Quickley.png",
                "Jayson_Tatum.png","Kristaps_Porzingis.png","Bruce_Brown.png","Tyrese_Haliburton.png","Andrew_Nembhard.png","Jordan_Poole.png","Tyus_Jones.png","P.J.Washington.png",
                "Terry_Rozier.png","Jalen_Johnson.png","Mikal_Bridges.png","Cam_Thomas.png","Caris_LeVert.png","OG_Anunoby.png","Pascal_Siakam.png","Gary_Trent_Jr.png","Mike_Conley.png",
                "Jimmy_Butler.png","Jalen_Duren.png","Cade_Cunningham.png","DeMar_DeRozan.png","Keldon_Johnson.png","Malcolm_Brogdon.png","Tyrese_Maxey.png"


        };

        try {
            for (int i = 0; i < imageUrls.length; i++) {
                downloadImage(imageUrls[i], destinationFiles[i]);
                System.out.println("Image downloaded successfully: " + destinationFiles[i]);
            }
        } catch (IOException e) {
            System.out.println("Error downloading images: " + e.getMessage());
        }
    }

    private static void downloadImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        URLConnection conn = url.openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");

        try (InputStream is = conn.getInputStream();
             OutputStream os = new FileOutputStream(destinationFile)) {
            byte[] buffer = new byte[2048];
            int length;
            while ((length = is.read(buffer)) != -1) {
                os.write(buffer, 0, length);
            }
        }
    }
}

