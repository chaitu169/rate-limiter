package org.example.ratelimiter.repositories;

import org.example.ratelimiter.models.Tier;
import org.example.ratelimiter.models.TierEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TierRepository {
    private List<Tier> tiers = new ArrayList<>();

    public TierRepository(){
        createTiers();
    }

    public void createTiers(){
        Tier freeTier = new Tier();
        freeTier.setTierId(1);
        freeTier.setTierEnum(TierEnum.FREE);
        freeTier.setPrice(0.0);

        Tier goTier = new Tier();
        goTier.setTierId(2);
        goTier.setTierEnum(TierEnum.GO);
        goTier.setPrice(9.99);

        Tier plusTier = new Tier();
        plusTier.setTierId(3);
        plusTier.setTierEnum(TierEnum.PLUS);
        plusTier.setPrice(19.99);

        Tier proTier = new Tier();
        proTier.setTierId(4);
        proTier.setTierEnum(TierEnum.PRO);
        proTier.setPrice(49.99);

        tiers.add(freeTier);
        tiers.add(goTier);
        tiers.add(plusTier);
        tiers.add(proTier);
    }

    public Tier getTierById(int tierId){
        return tiers.stream()
                .filter(tier -> tier.getTierId() == tierId)
                .findFirst()
                .orElse(null);
    }

    public Tier getTierByEnum(TierEnum tierEnum){
        return tiers.stream()
                .filter(tier -> tier.getTierEnum() == tierEnum)
                .findFirst()
                .orElse(null);
    }

    public List<Tier> getAllTiers(){
        return new ArrayList<>(tiers);
    }
}
