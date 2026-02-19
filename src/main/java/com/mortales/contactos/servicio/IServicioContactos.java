package com.mortales.contactos.servicio;

import com.mortales.contactos.ContactosApplication;
import com.mortales.contactos.modelo.Contacto;

import java.util.List;
import java.util.Optional;

public interface IServicioContactos
{
    public void guardarContacto(Contacto contacto);
    public void eliminarContacto(Contacto contacto);
    public List<Contacto>listarContactos();
    public Optional<Contacto>buscarContactoPorId(Integer id);
}
