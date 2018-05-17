package com.spring.version.controllers;

import com.spring.version.model.OrderModel;
import com.spring.version.model.UserData;
import com.spring.version.services.BikeServicesInt;
import com.spring.version.services.UserDataServicesInt;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;

import org.jboss.logging.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BikeDataController {

    private static final Logger logg = Logger
            .getLogger(BikeDataController.class);

    public BikeDataController() {
        logg.info("Here Controller : BikeDataController ");
    }

    @Autowired
    private BikeServicesInt bikeServicesInt;
    @Autowired
    private UserDataServicesInt userDataServicesInt;

    /**
     * method back to init
     * @param model
     * @return
     */
    @RequestMapping(value = "/backTo")
    public String getAll(Model model){
        return "redirect:/"; // pagina dnd retorno .jsp
    }

    /**
     * metodo para cargar los datos
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/listData")
    public ModelAndView listEmployee(ModelAndView model,Authentication auth){
        try {
            User userDat = (User) auth.getPrincipal();
            UserData userdate = userDataServicesInt.getUserDataByIdUser(userDat.getUsername());
            List<OrderModel> listBike = bikeServicesInt.getOrderByUser(userdate);
            model.addObject("listBike", listBike);
            model.setViewName("otherPaige");
        }catch (Exception e){
            logg.info("Error load data:"+ e.getCause());
        }
        return model;
    }

    /**
     * metodo necesario para cargar el modelo que se le pasa al JSP
     * esto es solo al ingresar a la pagina
     * @param model
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        model.addObject("orderData", new OrderModel());
        model.setViewName("formBike");
        return model;
    }

    /**
     * metodo para guardar los datos y para actualizar los mismos
     * @param ordelData
     * @return
     */
    @RequestMapping(value = "/saveData", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute("orderModel") OrderModel ordelData, Authentication auth){
        User userDat = (User) auth.getPrincipal();
        UserData userdate = userDataServicesInt.getUserDataByIdUser(userDat.getUsername());
        if (ordelData.getIdOrder() == 0) { // if employee id is 0 then creating the
            // employee other updating the employee
            ordelData.setUserData(userdate);
            bikeServicesInt.addBike(ordelData);
        } else {
            ordelData.setUserData(userdate);
            bikeServicesInt.updateDataBike(ordelData);
        }
        return new ModelAndView("redirect:/");
    }

    /**
     * metodo para eliminar los datos por ID
     * @param request
     * @return
     */
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        bikeServicesInt.deleteDataBike(userId);
        return new ModelAndView("redirect:/listData");
    }

    /**
     * metodo para actualizar un dato
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView editContact(@PathVariable("id") int Id) {
        ModelAndView model = new ModelAndView("formBike");
        try{
            int bikeByID = Id;
            OrderModel orderData = bikeServicesInt.getDataByBike(bikeByID);
            model.addObject("orderData", orderData);
        }catch (Exception e){
           logg.info("Error get User:" + e.getMessage());
        }
        return model;
    }
    /**
     * method get init page Spring Security
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(HttpServletRequest request){
        ModelAndView model = new ModelAndView();
            if (request.getParameter("error") != null){
                if (request.getParameter("error").isEmpty()){
                    model.addObject("error","true");
                }
            }
            model.setViewName("loginForm");
        return model;
    }
}
