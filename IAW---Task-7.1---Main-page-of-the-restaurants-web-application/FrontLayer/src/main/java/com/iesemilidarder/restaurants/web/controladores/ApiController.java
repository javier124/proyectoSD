package com.iesemilidarder.restaurants.web.controladores;

import com.iesemilidarder.restaurants.core.Leer;
import com.iesemilidarder.restaurants.core.Restaurant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(path = "/rest/api/v1")
public class ApiController {

        @RequestMapping(path = "/restaurants", method = RequestMethod.GET)
        public List<Restaurant> list() {
            Leer dbManager = new Leer();
            List<Restaurant> lRestaurants = dbManager.LeerRestAPI(false);
            return lRestaurants;
        }
    }

