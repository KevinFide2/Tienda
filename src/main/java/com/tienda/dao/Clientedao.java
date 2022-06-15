
package com.tienda.dao;

import com.tienda.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface Clientedao extends CrudRepository<Cliente, Long> {
    
}
