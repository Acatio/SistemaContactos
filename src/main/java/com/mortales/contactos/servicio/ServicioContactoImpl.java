package com.mortales.contactos.servicio;

import com.mortales.contactos.modelo.Contacto;
import com.mortales.contactos.repositorio.IRepositorioContactos;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ServicioContactoImpl implements IServicioContactos
{
    @Autowired
    IRepositorioContactos repositorioContacto;

    @Override
    public void guardarContacto(Contacto contacto)
    {
        repositorioContacto.save(contacto);
    }

    @Override
    public void eliminarContacto(Contacto contacto)
    {
        repositorioContacto.delete(contacto);
    }

    @Override
    public List<Contacto> listarContactos()
    {
        return repositorioContacto.findAll();
    }

    @Override
    public Optional<Contacto> buscarContactoPorId(Integer id)
    {
        return repositorioContacto.findById(id);
    }
}
