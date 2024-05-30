package Team;

import java.util.ArrayList;
import java.util.Random;

public class profilePicture {
    ArrayList<String>imageList=new ArrayList<>();

    public profilePicture(){
        imageList.add("/playerIcon/Aaron_Gordon.png");
        imageList.add("/playerIcon/Andrew_Nembhard.png");
        imageList.add("/playerIcon/Anthony_Davis.png");
        imageList.add("/playerIcon/Bruce_Brown.png");
        imageList.add("/playerIcon/Cade_Cunningham.png");
        imageList.add("/playerIcon/Cam_Thomas.png");
        imageList.add("/playerIcon/Caris_LeVert.png");
        imageList.add("/playerIcon/Chris_Paul.png");
        imageList.add("/playerIcon/Christian_Braun.png");
        imageList.add("/playerIcon/Collin_Gillespie.png");
        imageList.add("/playerIcon/Dario_Saric.png");
        imageList.add("/playerIcon/DeMar_DeRozan.png");
        imageList.add("/playerIcon/Devin_Brooker.png");
    }
    public String getImage(){
        Random r=new Random();
        int i=r.nextInt(imageList.size()-1);
        String s=imageList.get(i);
        imageList.remove(i);
        return s;
    }
}
