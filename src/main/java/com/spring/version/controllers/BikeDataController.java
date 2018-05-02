package com.spring.version.controllers;

import com.spring.version.model.StoryData;
import com.spring.version.services.BikeServicesInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.jboss.logging.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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
    public ModelAndView listEmployee(ModelAndView model) throws IOException {
        List<StoryData> listBike = bikeServicesInt.getAllEmployees();
        model.addObject("listBike", listBike);
        model.setViewName("otherPaige");
        return model;
    }

    /**
     * metodo necesario para cargar el modelo que se le pasa al JSP
     * @param model
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        model.addObject("StoryData", new StoryData());
        model.setViewName("formBike");
        return model;
    }

    /**
     * metodo para guardar los datos y para actualizar los mismos
     * @param bikeData
     * @return
     */
    @RequestMapping(value = "/saveData", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute("StoryData") StoryData bikeData){
        if (bikeData.getId() == 0) { // if employee id is 0 then creating the
            // employee other updating the employee
            bikeServicesInt.addBike(bikeData);
        } else {
            bikeServicesInt.updateDataBike(bikeData);
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
            StoryData bikeData = bikeServicesInt.getDataByBike(bikeByID);
            model.addObject("StoryData", bikeData);
        }catch (Exception e){
            e.getMessage();
        }
        return model;
    }
}
