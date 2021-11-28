package com.example.actionmicroservice.controller;

import com.example.actionmicroservice.model.Action;
import com.example.actionmicroservice.service.ActionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/actions")
@Api(value = "Endpoints for work with actions")
public class ActionController {

    private final ActionService actionService;

    @PostMapping
    @ApiOperation(value = "Create a new action")
    public void createAction(@RequestBody Action action) {
        actionService.createAction(action);
    }

    @GetMapping
    @ApiOperation(value = "Get all actions")
    public List<Action> getActions() {
        return actionService.getActions();
    }

}
