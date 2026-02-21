package com.mortales.contactos.controlador;

import com.mortales.contactos.modelo.Contacto;
import com.mortales.contactos.servicio.IServicioContactos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

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
}
