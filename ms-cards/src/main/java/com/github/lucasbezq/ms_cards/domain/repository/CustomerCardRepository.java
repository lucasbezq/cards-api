package com.github.lucasbezq.ms_cards.domain.repository;

import com.github.lucasbezq.ms_cards.domain.model.CustomerCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerCardRepository extends JpaRepository<CustomerCard, Long> {

    List<CustomerCard> findByCpf(String cpf);

}
