package com.josepardo.tienda.service;

import com.josepardo.tienda.entity.Categorias;
import com.josepardo.tienda.entity.Cliente;
import com.josepardo.tienda.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository clienteRepository;

    public void saveCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public List<Cliente> verCliente(){

        return clienteRepository.findAll();
    }

    public Cliente verClientePorId(Integer idCliente) {
        return clienteRepository.findById(idCliente).get();
    }

    public void eliminarCliente(Integer idCliente){

        clienteRepository.deleteById(idCliente);
    }
}
