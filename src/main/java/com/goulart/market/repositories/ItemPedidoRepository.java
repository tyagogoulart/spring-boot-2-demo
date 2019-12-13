package com.goulart.market.repositories;

import com.goulart.market.domain.ItemPedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

    
}