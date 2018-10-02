package com.spring.version.controllers;

import com.spring.version.model.OrderModel;
import com.spring.version.model.UserData;
import com.spring.version.services.UserDataServicesInt;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserDataControllers {

    private static final Logger logg = Logger
            .getLogger(UserDataControllers.class);

    @Autowired
    private UserDataServicesInt userDataServicesInt;

    /**
     * metodo para cargar los datos en mi JSP
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/formInfo", method = RequestMethod.GET)
    public ModelAndView getformUser(ModelAndView model) {
        model.addObject("userData", new UserData());
        model.setViewName("registerUser"); //pagina JSP que va a cargar
        return model;
    }

    /**
     * Metodo para guardar un Usuario Nuevo
     * @param userData model data of the User
     * @return
     */
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute("userData") UserData userData){
        ModelAndView model = new ModelAndView();
        UserData  dataUser = userDataServicesInt.getUserByEmail(userData.getEmail());
        if (dataUser.getEmail().isEmpty()) {
            userData.setStatus("Active");
            userData.setRolUser("ROLE_Admin");
            userDataServicesInt.saveUser(userData);
            model.setViewName("redirect:/");
        } else {
            model.addObject("error","true");
            model.setViewName("redirect:/user/formInfo");
        }

        return model;
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }

}
