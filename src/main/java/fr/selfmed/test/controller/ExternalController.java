package fr.selfmed.test.controller;

import fr.selfmed.test.parser.ParserFormat;
import fr.selfmed.test.exception.InvalidFormatException;
import fr.selfmed.test.exception.NotSupportFormatException;
import fr.selfmed.test.service.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExternalController {

    private final InputService inputService;

    @Autowired
    public ExternalController(InputService inputService) {
        this.inputService = inputService;
    }

    @GetMapping(value = "api/input")
    public String getInput(@RequestParam("format") ParserFormat format)
            throws NotSupportFormatException, InvalidFormatException {
        return inputService.getInput(format);
    }

}