
package com.tienda.controller;

import com.tienda.dao.Clientedao;
import com.tienda.domain.Cliente;
import com.tienda.service.ArticuloService;
import com.tienda.service.ClienteService;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class indexController {
    
    @Autowired
    private ArticuloService articuloService;
    
    @GetMapping("/")
    public String inicio(Model model){
        log.info("Ahora se usa arquitectura MVC");
        
        /*String mensaje = "Estamos en la semana 4";
        model.addAttribute("texto", mensaje);
        
        Cliente cliente = new Cliente("Kevin", "Brenes", "kbrenesbl@gmail.com", "84025868");
        model.addAttribute("cliente", cliente);
        
        Cliente cliente2 = new Cliente("Kevin", "Brenes", "kbrenesbl@gmail.com", "84025868");
        //var clientes = Arrays.asList(cliente, cliente2);
        var clientes = Arrays.asList();*/
        
        var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos", articulos);
        
        return "index";
    }
    
}
