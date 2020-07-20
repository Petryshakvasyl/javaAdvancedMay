package ua.lviv.lgs.pv.springcore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.lviv.lgs.pv.springcore.dto.CategoryDTO;
import ua.lviv.lgs.pv.springcore.dto.TransactionDTO;
import ua.lviv.lgs.pv.springcore.entity.Type;
import ua.lviv.lgs.pv.springcore.service.CategoryService;
import ua.lviv.lgs.pv.springcore.service.TransactionService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TransactionController {

    private final CategoryService categoryService;
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(CategoryService categoryService, TransactionService transactionService) {
        this.categoryService = categoryService;
        this.transactionService = transactionService;
    }

    @GetMapping("/transaction/create_form")
    public String getTransactionPage(Model model, @RequestParam Type type) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setType(type);
        List<CategoryDTO> categories = categoryService.findAllByType(type);
        model.addAttribute("categories", categories);
        model.addAttribute("transaction", transactionDTO);
        return "createTransaction";
    }

    @PostMapping("/transactions")
    public String createTransaction(@ModelAttribute(name = "transaction") @Valid TransactionDTO transactionDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "createTransaction";
        }
        //todo change to real user id
        transactionService.createInCurrentUserAccount(transactionDTO, 11L);
        return "success";
    }

    @GetMapping
    @ResponseBody
    @Secured("ROLE_ADMIN")
    public String adminOnly() {
        return "This can bt just admin";
    }
}
