package com.example.actionmicroservice.service;

import com.example.actionmicroservice.model.Action;
import com.example.actionmicroservice.repository.ActionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActionService {

    private final ActionRepository actionRepository;

    public void createAction(Action action) {
        actionRepository.save(action);
    }

    public List<Action> getActions() {
        return actionRepository.findAll();
    }
}
