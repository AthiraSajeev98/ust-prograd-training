package athira.ABCBank;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class MVCController {

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

    @RequestMapping("/accountDetails")
    public String accountDetails(Model model, HttpServletRequest request) {

        Map<String, ArrayList<String>> accountMap = new HashMap<>();

        ArrayList<String> setDetails;
        String setAccountNumber = null;
        String setName = null;
        String setIfscCode = null;
        String setBalance = null;

        ArrayList<String> details1 = new ArrayList<>(List.of("1234", "ABCAC001", "Manu Raj", "ABC001", "2000"));
        accountMap.put("Manu@123", details1);
        ArrayList<String> details2 = new ArrayList<>(List.of("1234", "ABCAC010", "Varun Sajeev", "ABC002", "30000"));
        accountMap.put("Varun@123", details2);
        ArrayList<String> details3 = new ArrayList<>(List.of("1234", "ABCAC021", "Akshay Krishna", "ABC001", "15000"));
        accountMap.put("Akshay@123", details3);

        String userName = request.getParameter("username");
        String password = request.getParameter("password");
//        String  accountNumber = request.getParameter("accountNumber");
//        String  customerName = request.getParameter("customerName");
//        String  ifscCode = request.getParameter("ifscCode");
//        String balance =request.getParameter("balance");

//        ArrayList<String> details = new ArrayList<>(List.of(password, accountNumber, customerName, ifscCode, balance));
//        accountMap.put(userName, details);

        if (accountMap.containsKey(userName)) {
            for (Map.Entry<String, ArrayList<String>> accountList : accountMap.entrySet()) {
                if (Objects.equals(accountList.getKey(), userName) && accountList.getValue().contains(password)) {
                    setDetails = accountList.getValue();
                    int j = 1;
                    while (j < setDetails.size()) {

                        if (j == 1) {
                            setAccountNumber = setDetails.get(j);
                        }

                        if (j == 2) {
                            setName = setDetails.get(j);
                        }
                        if (j == 3) {
                            setIfscCode = setDetails.get(j);
                        }
                        if (j == 4) {
                            setBalance = setDetails.get(j);
                        }

                        j++;
                    }
                }
            }
        }
        model.addAttribute("accountNumber", setAccountNumber);
        model.addAttribute("customerName", setName);
        model.addAttribute("ifscCode", setIfscCode);
        model.addAttribute("balance", setBalance);

        return "accountDetails";
    }
    @RequestMapping("/transaction")
    public String transaction() {
        register();
        return "transaction";
    }
    @RequestMapping("/balance")
    public String balance() {
        register();
        return "balance";
    }


}

//
//        if(accountMap.containsKey(accountNumber)){
//
//  String  customerName = request.getParameter("customerName");
//        String  accountNumber = request.getParameter("accountNumber");
//        String  ifscCode = request.getParameter("ifscCode");
//        String balance =request.getParameter("balance");
//      details.addAll(List.of(userName,password,customerName,ifscCode,balance));
//
//        accountMap.put(accountNumber,details);
//        displayCustomerName=accountMap.get(details.get(2));
//        model.addAttribute("customerName",displayCustomerName);
//        model.addAttribute("accountNumber",accountNumber);
//            model.addAttribute("ifscCode", accountMap.get(details.get(3));
//            model.addAttribute("balance",accountMap.get(details.get(4));