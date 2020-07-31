package ua.lviv.lgs.pv.springcore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.lviv.lgs.pv.springcore.dto.CategoryDTO;
import ua.lviv.lgs.pv.springcore.dto.TransactionDTO;
import ua.lviv.lgs.pv.springcore.dto.UserDTO;
import ua.lviv.lgs.pv.springcore.entity.Type;
import ua.lviv.lgs.pv.springcore.service.CategoryService;
import ua.lviv.lgs.pv.springcore.service.TransactionService;
import ua.lviv.lgs.pv.springcore.service.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class TransactionController {

    private final CategoryService categoryService;
    private final TransactionService transactionService;
    private final UserService userService;

    @Autowired
    public TransactionController(CategoryService categoryService, TransactionService transactionService, UserService userService) {
        this.categoryService = categoryService;
        this.transactionService = transactionService;
        this.userService = userService;
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
    public String createTransaction(Principal principal, @ModelAttribute(name = "transaction") @Valid TransactionDTO transactionDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "createTransaction";
        }
        UserDTO currentUser = userService.findByUserName(principal.getName());
//        SecurityContextHolder.getContext().getAuthentication().getName();
        transactionService.createInCurrentUserAccount(transactionDTO, currentUser.getId());

        return "success";
    }

    @GetMapping("/transactions/list")
    public String findAll(@RequestParam Type type, Pageable pageable, Model model) {
        Page<TransactionDTO> typeForCurrentUser = transactionService.findTypeForCurrentUser(type, pageable);
        model.addAttribute("transactions", typeForCurrentUser);
        model.addAttribute("type", type);
        return "transactions";
    }

    @GetMapping
    @ResponseBody
    @Secured("ROLE_ADMIN")
    public String adminOnly() {
        return "This can bt just admin";
    }
}
