package com.ics499.loyalty.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ics499.loyalty.model.Reward;

@Repository
public interface RewardRepo extends CrudRepository<Reward, Integer> {

}


