package com.mortales.contactos.controlador;

import com.mortales.contactos.modelo.Contacto;
import com.mortales.contactos.servicio.IServicioContactos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class IndexControlador
{
    Logger logger = LoggerFactory.getLogger(IndexControlador.class);

    @Autowired
    IServicioContactos servicioContacto;

    @GetMapping("/")
    public String iniciar(ModelMap modelo)
    {
        List<Contacto> contactos = servicioContacto.listarContactos();
        contactos.forEach((contacto -> logger.info(contacto.toString())));
        modelo.put("contactos", contactos);
        return "index";
    }

    @GetMapping("/agregar")
    public String mostrarAgregarContacto()
    {
        return "agregar";
    }

    @PostMapping("/agregar")
    public String agregar(@ModelAttribute("contacto") Contacto contacto)
    {
        logger.info("Contacto a agregar:" + contacto);
        servicioContacto.guardarContacto(contacto);
        return "redirect:/"; //redirigiendo el controlador al path "/"

    }

    @GetMapping("/editar/{id}")
    public String mostrarEditarContacto(@PathVariable int id, ModelMap modelo) {

        var contacto = servicioContacto.buscarContactoPorId(id)
                .orElseThrow();
        modelo.put("contacto", contacto);
        return "editar";
    }


}
