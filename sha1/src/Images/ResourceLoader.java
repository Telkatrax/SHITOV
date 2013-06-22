package Images;
import java.net.URL;



public class ResourceLoader {
static ResourceLoader rl = new ResourceLoader();
ResourceLoader(){};
public static URL getImage(String fileName){
	return ( rl.getClass().getResource(fileName));
}
}
