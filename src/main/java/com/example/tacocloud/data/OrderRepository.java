package com.example.tacocloud.data;
import com.example.tacocloud.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository
        extends CrudRepository<TacoOrder, Long> {

}


