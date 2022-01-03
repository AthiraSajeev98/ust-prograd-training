package athira.ABCBank.Controller;

import athira.ABCBank.Entity.Customers;

import athira.ABCBank.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class JPA_MVC_Controller {

    @Autowired
    public CustomerService customerService;

    Double balance;
    String name;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/registerDetails")
    public String details(Model model, HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String customerName = request.getParameter("customerName");
        Long accountNumber = Long.parseLong(request.getParameter("accountNumber"));
        Long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
        String ifscCode = request.getParameter("ifscCode");
//        String balance=request.getParameter("balance");

        Customers customers = new Customers(username, password, customerName, accountNumber, phoneNumber, ifscCode);

        model.addAttribute("details", customerService.save(customers));
        model.addAttribute("message1", customerService.save(customers));
        return "login";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/customerAccount")
    public String listAccount(Model model, HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String returnStatus = null;

        if (Objects.equals(customerService.findById(username).getPassword(), password)
                && Objects.equals(customerService.findById(username).getUsername(), username)) {
            model.addAttribute("customerName", customerService.findById(username).getCustomerName());
            model.addAttribute("phoneNumber", customerService.findById(username).getPhoneNumber());
            model.addAttribute("accountNumber", customerService.findById(username).getAccountNumber());
            model.addAttribute("ifscCode", customerService.findById(username).getIfscCode());
            balance = customerService.findById(username).getBalance();
            name=customerService.findById(username).getCustomerName();
            returnStatus = "customerAccount";
        } else {
            model.addAttribute("message2", "Invalid Credentials...!");
            returnStatus = "login";
        }

        return returnStatus;
    }

    @RequestMapping("/balance")
    public String getBalanceOfAccount(Model model) {
        model.addAttribute("name", name);
        model.addAttribute("balance", balance);
        return "balance";
    }


    @RequestMapping("/transaction")
    public String transaction() {
        return "transaction";


    }

    @PostMapping("/transactionDetails")
    public String TransferAmount(Model model, HttpServletRequest request) {
        Long fromAccountNumber = Long.parseLong(request.getParameter("fromAccountNumber"));
        Long toAccountNumber = Long.parseLong(request.getParameter("toAccountNumber"));
        Double amount = Double.parseDouble(request.getParameter("amount"));

        Customers fromCustomer = customerService.findBYAccountNumber(fromAccountNumber);
        Customers toCustomer = customerService.findBYAccountNumber(toAccountNumber);
        if (Objects.equals(fromCustomer.getAccountNumber(), fromAccountNumber)
                && Objects.equals(toCustomer.getAccountNumber(), toAccountNumber)) {

            if (fromCustomer.getBalance() > amount) {

                fromCustomer.setBalance(fromCustomer.getBalance() - amount);
                customerService.save(fromCustomer);
                toCustomer.setBalance(toCustomer.getBalance() + amount);
                customerService.save(toCustomer);
                model.addAttribute("message", "Transferred Successfully...!");
                model.addAttribute("name", fromCustomer.getCustomerName());
                model.addAttribute("balance", fromCustomer.getBalance());
            }
        }
        return "balance";
    }


}
