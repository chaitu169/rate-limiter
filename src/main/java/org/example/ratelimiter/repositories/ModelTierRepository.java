package org.example.ratelimiter.repositories;

import org.example.ratelimiter.models.ModelTier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelTierRepository {
    private List<ModelTier> modelTiers = new ArrayList<>();

    public ModelTierRepository(){
        createModelTiers();
    }

    public void createModelTiers(){
        // GPT-4 (modelId: 1) rate limits for each tier
        modelTiers.add(createModelTier(1, 1, false, 0, 0)); // FREE - not supported
        modelTiers.add(createModelTier(1, 2, true, 10, 100)); // GO
        modelTiers.add(createModelTier(1, 3, true, 50, 500)); // PLUS
        modelTiers.add(createModelTier(1, 4, true, 200, 2000)); // PRO

        // GPT-3.5 (modelId: 2) rate limits for each tier
        modelTiers.add(createModelTier(2, 1, true, 5, 50)); // FREE
        modelTiers.add(createModelTier(2, 2, true, 50, 500)); // GO
        modelTiers.add(createModelTier(2, 3, true, 200, 2000)); // PLUS
        modelTiers.add(createModelTier(2, 4, true, 1000, 10000)); // PRO

        // Claude (modelId: 3) rate limits for each tier
        modelTiers.add(createModelTier(3, 1, false, 0, 0)); // FREE - not supported
        modelTiers.add(createModelTier(3, 2, true, 10, 100)); // GO
        modelTiers.add(createModelTier(3, 3, true, 50, 500)); // PLUS
        modelTiers.add(createModelTier(3, 4, true, 200, 2000)); // PRO

        // Gemini (modelId: 4) rate limits for each tier
        modelTiers.add(createModelTier(4, 1, true, 10, 100)); // FREE
        modelTiers.add(createModelTier(4, 2, true, 50, 500)); // GO
        modelTiers.add(createModelTier(4, 3, true, 200, 2000)); // PLUS
        modelTiers.add(createModelTier(4, 4, true, 500, 5000)); // PRO
    }

    private ModelTier createModelTier(int modelId, int tierId, boolean isSupported,
                                      int hourlyLimit, int dailyLimit){
        ModelTier modelTier = new ModelTier();
        modelTier.setModelId(modelId);
        modelTier.setTierId(tierId);
        modelTier.setSupported(isSupported);
        modelTier.setRequestLimitPerHour(hourlyLimit);
        modelTier.setRequestLimitPerDay(dailyLimit);
        return modelTier;
    }

    public ModelTier getModelTierByModelAndTier(int modelId, int tierId){
        return modelTiers.stream()
                .filter(mt -> mt.getModelId() == modelId && mt.getTierId() == tierId)
                .findFirst()
                .orElse(null);
    }

    public List<ModelTier> getModelTiersByModelId(int modelId){
        return modelTiers.stream()
                .filter(mt -> mt.getModelId() == modelId)
                .toList();
    }

    public List<ModelTier> getModelTiersByTierId(int tierId){
        return modelTiers.stream()
                .filter(mt -> mt.getTierId() == tierId)
                .toList();
    }

    public List<ModelTier> getSupportedModelTiersForTier(int tierId){
        return modelTiers.stream()
                .filter(mt -> mt.getTierId() == tierId && mt.isSupported())
                .toList();
    }

    public List<ModelTier> getAllModelTiers(){
        return new ArrayList<>(modelTiers);
    }
}