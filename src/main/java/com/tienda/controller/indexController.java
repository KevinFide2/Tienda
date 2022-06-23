
package com.tienda.controller;

import com.tienda.dao.Clientedao;
import com.tienda.domain.Cliente;
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
    private ClienteService clienteService;
    
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
        
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        return "index";
    }
    
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente){
        return "modificarCliente";
    }
    
    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect/";
    }
    
    @GetMapping("/modificarCliente/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarCliente";
    }
    
    @GetMapping("/eliminarCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/";
    }
}
