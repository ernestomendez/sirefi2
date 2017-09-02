package mx.com.dxesoft.sirefi2.web.rest;

import mx.com.dxesoft.sirefi2.entities.User;
import mx.com.dxesoft.sirefi2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * sirefi2, mx.com.dxesoft.sirefi2.resource . Public
 * Created by ernesto on 1/09/17.
 */
@RestController
@RequestMapping("/public")
public class Public {

    private Logger log = LoggerFactory.getLogger(Public.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public List<User> metodoDePrueba() {

        log.debug("Metodo de prueba");
        return userRepository.findAll();
    }
//    @GetMapping("/user")
//    public String metodoDePrueba() {
//
//        return "Esto es publico";
//    }
}
