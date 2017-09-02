package mx.com.dxesoft.sirefi2.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * sirefi2, mx.com.dxesoft.sirefi2.web.rest . Private
 * Created by ernesto on 1/09/17.
 */
@RestController
@RequestMapping("/oauth2/sirefi")
public class Private {

    @GetMapping("/user")
    public String metodoDePrueba() {

        return "esta en el privado";
    }
}
