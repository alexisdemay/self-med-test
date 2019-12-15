package fr.selfmed.test.controller;

import fr.selfmed.test.model.Transactions;
import fr.selfmed.test.parser.ParserFormat;
import fr.selfmed.test.service.OutputService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TransactionsController {

    private final OutputService transactionsOutputService;

    @Autowired
    public TransactionsController(OutputService transactionsOutputService) {
        this.transactionsOutputService = transactionsOutputService;
    }

    @GetMapping("api/v1/output")
    public String getTransactionsAs(@RequestParam("inputFormat") ParserFormat inputFormat,
            @RequestParam("outputFormat") ParserFormat outputFormat) {
        return transactionsOutputService.getOutput(inputFormat, outputFormat, Transactions.class);
    }

}