package com.ics499.loyalty.services;

import com.ics499.loyalty.model.Reward;
import com.ics499.loyalty.repositories.RewardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RewardService {

    @Autowired
    private RewardRepo rewardRepo;

    public List<Reward> findAll() {
        var it = rewardRepo.findAll();

        var rewards = new ArrayList<Reward>();
        it.forEach(e -> rewards.add(e));

        return rewards;
    }

    public Optional<Reward> findById(int id) {
        return rewardRepo.findById(id);
    }

    public void add(Reward reward) {
        rewardRepo.save(reward);
    }

    public Long count() {
        return rewardRepo.count();
    }

    public void deleteById(int rewardID) {
        rewardRepo.deleteById(rewardID);
    }
}
