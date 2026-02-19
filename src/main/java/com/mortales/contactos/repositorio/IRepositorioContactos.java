package com.mortales.contactos.repositorio;

import com.mortales.contactos.modelo.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositorioContactos extends JpaRepository<Contacto,Integer>
{
}
