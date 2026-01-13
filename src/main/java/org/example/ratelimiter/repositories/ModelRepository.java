package org.example.ratelimiter.repositories;

import org.example.ratelimiter.models.AIModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelRepository {
    List<AIModel> models = new ArrayList<>();

    public ModelRepository(){
        createAIModels();
    }

    public void createAIModels(){
        AIModel gpt4 = new AIModel();
        gpt4.setId(1);
        gpt4.setName("GPT-4");

        AIModel gpt35 = new AIModel();
        gpt35.setId(2);
        gpt35.setName("GPT-3.5");

        AIModel claude = new AIModel();
        claude.setId(3);
        claude.setName("Claude");

        AIModel gemini = new AIModel();
        gemini.setId(4);
        gemini.setName("Gemini");

        models.add(gpt4);
        models.add(gpt35);
        models.add(claude);
        models.add(gemini);
    }

    public AIModel getAIModelById(int id){
        return models.stream()
                .filter(model -> model.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<AIModel> getAllModels(){
        return new ArrayList<>(models);
    }
}
