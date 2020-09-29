package th.ac.ku.atm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.atm.service.BankAccountService;

@Controller
@RequestMapping("/bankaccount")
public class BankAccountController {

    private BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }
    @GetMapping
    public String getBankAccountPage(Model model){

//        model.addAttribute("allBankAccounts",bankAccountService.getBankAccountList());

        return "bankaccount";
    }

//    @PostMapping
//    public String registerBankAccount(@ModelAttribute BankAccount bankAccount,Model model){
//        bankAccountService.createBankAccount(bankAccount);
//
//
//        model.addAttribute("allBankAccounts",bankAccountService.getBankAccountList());
//        return "redirect:bankaccount";
//
//    }

}
