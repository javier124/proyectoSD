package com.iesemilidarder.restaurants.web.controladores;

import com.iesemilidarder.restaurants.core.Leer;
import com.iesemilidarder.restaurants.core.Restaurant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        String name = "Restaurants";
        Leer dbManager = new Leer();
        List<Restaurant> lRestaurants = dbManager.LeerRestAPI(StringUtils.EMPTY);

        model.addAttribute("name",name);
        model.addAttribute("list",lRestaurants);
        model.addAttribute("dbManager",dbManager);
        return "index";
    }
}
