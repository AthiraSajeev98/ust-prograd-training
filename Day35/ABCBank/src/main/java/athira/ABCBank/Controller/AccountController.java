package athira.ABCBank.Controller;

import athira.ABCBank.Entity.Account;
import athira.ABCBank.Entity.Customers;
import athira.ABCBank.Service.AccountService;
import athira.ABCBank.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccountController {
    @Autowired
    public AccountService accountService;
    @Autowired
    public CustomerService customerService;


    @RequestMapping("/accountRegister")
    public String registerCustomerAccount() {
        return "accountRegister";
    }

    @PostMapping("/accountRegister")
    public String saveCustomerAccount(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        String accountNumber = request.getParameter("accountNumber");
        String ifscCode = request.getParameter("ifscCode");
        String branch = request.getParameter("branch");

        Account saveAccount = new Account(username, accountNumber, ifscCode, branch);

        accountService.save(saveAccount);

        Customers customer = customerService.findById(username);
        Account account = accountService.findById(accountNumber);

        customer.setAccount(account);
        customerService.save(customer);

        model.addAttribute("successMessage", "Successfully Linked Customer With Account Please Login..!");

        return "login";
    }




}
