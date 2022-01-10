package athira.ABCBank.Controller;

import athira.ABCBank.Entity.Account;
import athira.ABCBank.Entity.Customers;

import athira.ABCBank.Service.AccountService;
import athira.ABCBank.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class CustomerController {

    @Autowired
    public CustomerService customerService;

    @Autowired
    public AccountService accountService;

    Double balance;
    String customerID;
    String accountID;


    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String registerCustomer() {
        return "register";
    }

    @PostMapping("/register")
    public String saveCustomer(Model model, HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String customerName = request.getParameter("customerName");
        String address = request.getParameter("address");
        Long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
        String emailId = request.getParameter("emailId");

        Customers customers = new Customers(username, password, customerName, address, phoneNumber, emailId);
        customerService.save(customers);
        model.addAttribute("successMessage", "Successfully Registered " + customerName + " Please Add Account Details..!");
        return "accountRegister";
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
        model.addAttribute("address", customer.getAddress());
        model.addAttribute("emailId", customer.getEmailId());

        model.addAttribute("successMessage", "Profile Updated...!");
        return "customerAccount";
    }

    @PostMapping("/login")
    public String login(Model model, HttpServletRequest request) {
        String username = request.getParameter("userName");
        String password = request.getParameter("password");


        Cookie loginCookie =new Cookie("username", "loginCookie");

        loginCookie.setMaxAge(1);
        loginCookie.setSecure(true);
        loginCookie.setHttpOnly(true);
        loginCookie.setPath("/login");


        if (customerService.existById(username)) {
            if (Objects.equals(customerService.findById(username).getPassword(), password)) {
                model.addAttribute("userName", username);
                model.addAttribute("name", customerService.findById(username).getCustomerName());
                model.addAttribute("phoneNumber", customerService.findById(username).getPhoneNumber());
                model.addAttribute("emailId", customerService.findById(username).getEmailId());
                model.addAttribute("address", customerService.findById(username).getAddress());
                model.addAttribute("accountNumber", customerService.findById(username).getAccount().getAccountNumber());
                model.addAttribute("ifscCode", customerService.findById(username).getAccount().getIfscCode());
                model.addAttribute("branch", customerService.findById(username).getAccount().getBranch());
                accountID = customerService.findById(username).getAccount().getAccountNumber();
                customerID = customerService.findById(username).getUsername();
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

    @RequestMapping("/customerAccount")
    public String showAccount() {
        return "customerAccount";
    }

    @RequestMapping("/customerAccount/{id}")
    public String listAccount(@PathVariable String id, Model model) {

        model.addAttribute("userName", id);
        model.addAttribute("name", customerService.findById(id).getCustomerName());
        model.addAttribute("phoneNumber", customerService.findById(id).getPhoneNumber());
        model.addAttribute("emailId", customerService.findById(id).getEmailId());
        model.addAttribute("address", customerService.findById(id).getAddress());
        model.addAttribute("accountNumber", customerService.findById(id).getAccount().getAccountNumber());
        model.addAttribute("ifscCode", customerService.findById(id).getAccount().getIfscCode());
        model.addAttribute("branch", customerService.findById(id).getAccount().getBranch());
        return "customerAccount";
    }

    @PostMapping("/updateProfile")
    public String updateProfile(Model model, HttpServletRequest request) {
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
        model.addAttribute("emailId", customer.getEmailId());
        model.addAttribute("phoneNumber", customer.getPhoneNumber());
        model.addAttribute("address", customer.getAddress());
        model.addAttribute("accountNumber", customer.getAccount().getAccountNumber());
        model.addAttribute("ifscCode", accountService.findById(accountID).getIfscCode());
        model.addAttribute("branch", accountService.findById(accountID).getBranch());

        model.addAttribute("successMessage", "Profile Updated...!");
        return "customerAccount";
    }


    @RequestMapping("/updateProfile/{id}")
    public String updateProfileMain(@PathVariable String id, Model model) {
        model.addAttribute("customers", customerService.findById(id));
        model.addAttribute("customerName", customerService.findById(id).getCustomerName());
        model.addAttribute("userName", customerService.findById(id).getUsername());
        return "updateProfile";
    }

    @RequestMapping("/transaction")
    public String transaction(Model model) {
        model.addAttribute("account", accountService.findById(accountID));
        model.addAttribute("userName", customerService.findById(customerID).getUsername());
        model.addAttribute("name", customerService.findById(customerID).getCustomerName());
        return "transaction";
    }

    @PostMapping("/transaction")
    public String TransferAmount(Model model, HttpServletRequest request) {
        String fromAccountNumber = request.getParameter("fromAccountNumber");
        String toAccountNumber = request.getParameter("toAccountNumber");
        Double amount = Double.parseDouble(request.getParameter("amount"));

        Account fromAccount = accountService.findById(fromAccountNumber);
        Account toAccount = accountService.findById(toAccountNumber);
        if (amount < fromAccount.getBalance() && amount>0) {
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            accountService.save(fromAccount);
            toAccount.setBalance(toAccount.getBalance() + amount);
            accountService.save(toAccount);
            model.addAttribute("message", "Transferred Successfully...!");
            model.addAttribute("name", customerService.findById(fromAccount.getUsername()).getCustomerName());
            model.addAttribute("balance", fromAccount.getBalance());
            model.addAttribute("userName", fromAccount.getUsername());
            return "balance";
        }else{
            model.addAttribute("errorMessage", "Invalid amount..!");
            model.addAttribute("name", customerService.findById(fromAccount.getUsername()).getCustomerName());
            model.addAttribute("balance", fromAccount.getBalance());
            model.addAttribute("userName", fromAccount.getUsername());
            return "balance";
        }
    }

    @RequestMapping("/balance")
    public String getBalanceOfAccount(Model model) {
        model.addAttribute("userName", customerService.findById(customerID).getUsername());
        model.addAttribute("name", customerService.findById(customerID).getCustomerName());
        model.addAttribute("balance", customerService.findById(customerID).getAccount().getBalance());
        return "balance";
    }

}


//                                   } else {
//                        model.addAttribute("errorMessage", "Insufficient balance..!");
//                        return "transaction";
//                    }
//                } catch (IllegalArgumentException ae) {
//                    model.addAttribute("errorMessage", "Invalid Amount..!");
//                    return "transaction";
//                }
//            }
//        } catch (IllegalArgumentException ae) {
//            model.addAttribute("errorMessage", "Account number is invalid..!");
//            return "transaction";
//        }
//        return "balance";
//    }