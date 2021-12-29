package athira.ABCBank.Controller;

import athira.ABCBank.Entity.Customers;

import athira.ABCBank.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class JPA_MVC_Controller {

    @Autowired
    public CustomerService customerService;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/transaction")
    public String transaction() {
        return "transaction";
    }

    @RequestMapping("/balance")
    public String balance() {
        return "balance";
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

        return "registerDetails";
    }

    @PostMapping("/customerAccount")
    public String list(Model model, HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Customers customerData = new Customers();

        customerData = customerService.byId(username);
        if (Objects.equals(password, customerData.getPassword())) {
            model.addAttribute("customerName", customerData.getCustomerName());
            model.addAttribute("phoneNumber", customerData.getPhoneNumber());
            model.addAttribute("accountNumber", customerData.getAccountNumber());
            model.addAttribute("ifscCode", customerData.getIfscCode());
        }
        return "customerAccount";
    }
}
