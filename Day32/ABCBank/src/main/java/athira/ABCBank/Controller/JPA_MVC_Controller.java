package athira.ABCBank.Controller;

import athira.ABCBank.Entity.Customers;

import athira.ABCBank.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model, HttpServletRequest request) {
        String username = request.getParameter("userName");
        String password = request.getParameter("password");


        if (customerService.existById(username)) {
            if (Objects.equals(customerService.findById(username).getPassword(), password)) {
                model.addAttribute("userName", username);
                model.addAttribute("name", customerService.findById(username).getCustomerName());
                model.addAttribute("phoneNumber", customerService.findById(username).getPhoneNumber());
                model.addAttribute("accountNumber", customerService.findById(username).getAccountNumber());
                model.addAttribute("ifscCode", customerService.findById(username).getIfscCode());

                name = customerService.findById(username).getCustomerName();
                return "customerAccount";
            } else {
                model.addAttribute("errorMessage", "Invalid Credentials...! Status code : 404");
                return "login";
            }
        } else {
            model.addAttribute("errorMessage", "Invalid Credentials...! Status code : 404");
            return "login";
        }
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String details(Model model, HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String customerName = request.getParameter("customerName");
        Long accountNumber = Long.parseLong(request.getParameter("accountNumber"));
        Long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
        String ifscCode = request.getParameter("ifscCode");
//        String balance=request.getParameter("balance");

        Customers customers = new Customers(username, password, customerName, accountNumber, phoneNumber, ifscCode);

        model.addAttribute("successMessage", customerService.save(customers));
        return "login";
    }

    @RequestMapping("/updateProfile/{id}")
    public String updateProfile(@PathVariable String id, Model model) {
        model.addAttribute("customers", customerService.findById(id));
        model.addAttribute("customerName", customerService.findById(id).getCustomerName());
        model.addAttribute("userName", customerService.findById(id).getUsername());
        return "updateProfile";
    }

    @RequestMapping("/customerAccount/{id}")
    public String listAccount(@PathVariable String id, Model model) {
        model.addAttribute("customers", customerService.findById(id));
        model.addAttribute("name", customerService.findById(id).getCustomerName());
        model.addAttribute("userName", customerService.findById(id).getUsername());
        model.addAttribute("phoneNumber", customerService.findById(id).getPhoneNumber());
        model.addAttribute("ifscCode", customerService.findById(id).getIfscCode());
        model.addAttribute("accountNumber", customerService.findById(id).getAccountNumber());
        return "customerAccount";
    }

    @PostMapping("/customerAccount")
    public String updateCustomer(Model model, HttpServletRequest request) {
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        String nameOfCustomer = request.getParameter("name");
        Long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));

        Customers customer = customerService.findById(username);

        customer.setPassword(password);
        customer.setCustomerName(nameOfCustomer);
        customer.setPhoneNumber(phoneNumber);
        customerService.save(customer);

        model.addAttribute("userName", username);
        model.addAttribute("name", customer.getCustomerName());
        model.addAttribute("phoneNumber", customer.getPhoneNumber());
        model.addAttribute("accountNumber", customer.getAccountNumber());
        model.addAttribute("ifscCode", customer.getIfscCode());

        model.addAttribute("successMessage", "Profile Updated...!");
        return "customerAccount";
    }

    @RequestMapping("/transaction")
    public String transaction(Model model) {
        model.addAttribute("name", customerService.findBYAccountName(name).getCustomerName());
        model.addAttribute("accountNumber", customerService.findBYAccountName(name).getAccountNumber());
        model.addAttribute("userName", customerService.findBYAccountName(name).getUsername());
        return "transaction";

    }

    @PostMapping("/transaction")
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
                model.addAttribute("userName", fromCustomer.getUsername());
            }
        }
        return "balance";
    }

    @RequestMapping("/balance")
    public String getBalanceOfAccount(Model model) {
        model.addAttribute("userName", customerService.findBYAccountName(name).getUsername());
        model.addAttribute("name", customerService.findBYAccountName(name).getCustomerName());
        model.addAttribute("balance", customerService.findBYAccountName(name).getBalance());
        return "balance";
    }
}


//        @RequestMapping("/customerAccount")
//        public String showAccount (Model model){
//            model.addAttribute("customers", customerService.findBYAccountName(name));
//            model.addAttribute("name", customerService.findBYAccountName(name).getCustomerName());
//            model.addAttribute("userName", customerService.findBYAccountName(name).getUsername());
//            model.addAttribute("phoneNumber", customerService.findBYAccountName(name).getPhoneNumber());
//            model.addAttribute("ifscCode", customerService.findBYAccountName(name).getIfscCode());
//            model.addAttribute("accountNumber", customerService.findBYAccountName(name).getAccountNumber());
//            return "customerAccount";
//        }
