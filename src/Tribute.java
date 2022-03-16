
import GUI.controller.Controller;
import GUI.model.Model;
import GUI.view.View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ykx5915
 */
public class Tribute {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        model.addObserver(view);
        view.addController(controller);
    }
}
