package ua.lviv.lgs.pv.springcore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.lgs.pv.springcore.dto.CategoryDTO;
import ua.lviv.lgs.pv.springcore.dto.TransactionDTO;
import ua.lviv.lgs.pv.springcore.entity.Type;
import ua.lviv.lgs.pv.springcore.service.CategoryService;
import ua.lviv.lgs.pv.springcore.service.TransactionService;

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
    public String createTransaction(@ModelAttribute(name = "transaction") TransactionDTO transactionDTO) {
        transactionService.createInCurrentUserAccount(transactionDTO, 11L);
        return "success";
    }
}
