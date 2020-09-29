package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.atm.model.Customer;
import th.ac.ku.atm.service.BankAccountService;
import th.ac.ku.atm.service.CustomerService;

@Controller
@RequestMapping("/login")
public class LoginController {

    private CustomerService customerService;
    private BankAccountService bankAccountService;

    public LoginController(CustomerService customerService, BankAccountService bankAccountService) {
        this.customerService = customerService;
        this.bankAccountService = bankAccountService;
    }

    @GetMapping
    public String getLoginPage(){
        return "login";
    }

    @PostMapping
    public String login(@ModelAttribute Customer customer, Model model){
        // cheack match id pin with customer info
        Customer matchingCustomer = customerService.checkPin(customer);

        // if match , welcome
        if(matchingCustomer != null){
            model.addAttribute("customertitle",matchingCustomer.getName()
                    +" Bank Accounts");
            model.addAttribute("bankaccounts",
                    bankAccountService.getCustomerBankAccounts(customer.getId()));

            return "customeraccount";
        }
        // if not , display incorrect info
        else{
            model.addAttribute("greeting","Can't find customer");
            return "home";
        }


    }
}
