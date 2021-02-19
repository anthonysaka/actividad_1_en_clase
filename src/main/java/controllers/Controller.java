package controllers;

import encapsulations.User;

import java.util.ArrayList;

public class Controller {

    private ArrayList<User> listUser;
    private static Controller storeController;

    /* SINGLETON */
    public static Controller getInstance() {
        if(storeController == null) {
            storeController = new Controller();
        }
        return storeController;
    }

    private Controller() {
        this.listUser = new ArrayList<User>();
    }

    /* Gets and Sets */

    public ArrayList<User> getListUser() {
        return listUser;
    }

    public void setListUser(ArrayList<User> listUser) {
        this.listUser = listUser;
    }

    public static Controller getStoreController() {
        return storeController;
    }

    public static void setStoreController(Controller storeController) {
        Controller.storeController = storeController;
    }



    public User searchUser(String username, String password) {
        User auxUser = null;

        for (User user: listUser) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)){
                auxUser = user;
                break;
            }
        }
        return  auxUser;
    }

    public void addUser(User u){
        listUser.add(u);
    }
}
