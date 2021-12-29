package athira.ABCBank.Service;


import athira.ABCBank.Entity.Customers;
import athira.ABCBank.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public String save(Customers customers) {
        customerRepository.save(customers);

        return "Customer Details Updated...";
    }

    public List<Customers> listAll() {
        return customerRepository.findAll();
    }


    public Customers byId(String id){
        return customerRepository.getById(id);
    }

}
