package com.josepardo.tienda.repository;

import com.josepardo.tienda.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProovedorRepository extends JpaRepository<Proveedor,Integer> {

}
