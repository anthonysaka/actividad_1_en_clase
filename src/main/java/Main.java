import controllers.MainController;
import io.javalin.Javalin;

public class Main {

    public static void main(String[] args) {

        Javalin app = Javalin.create( config -> {
            //set configs
            config.addStaticFiles("/public");

        }).start(7000);

        new MainController(app).routesControl();



    }
}
