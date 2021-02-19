package controllers;

import encapsulations.User;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class MainController {
    Javalin app;
    Controller controller = Controller.getInstance();

    public MainController(Javalin app) {
        this.app = app;
        User n = new User("anthony sakamoto","admin","admin");
        controller.addUser(n);
    }


    public void routesControl(){

        app.routes(() -> {

            path("/", () -> {
                before("/", ctx -> {
                    User auxUser = ctx.sessionAttribute("user");
                    if (auxUser == null){
                        ctx.redirect("/login.html");
                    }
                });

            });


            path("/authenticate", () -> {

                before("/", ctx -> {
                    String username = ctx.formParam("username");
                    String password = ctx.formParam("password");
                    User auxUser = controller.searchUser(username,password);
                    if (auxUser == null){
                        ctx.result("NO AUTORIZADO");
                    }else{
                        ctx.attribute("userFound", auxUser);
                    }
                });

                post("/", ctx -> {
                    ctx.sessionAttribute("user",ctx.attribute("userFound"));
                    ctx.redirect("/");
                });

            });



        });



    }
}
