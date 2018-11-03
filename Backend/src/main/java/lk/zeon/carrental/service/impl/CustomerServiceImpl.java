package lk.zeon.carrental.service.impl;

import lk.zeon.carrental.dto.CustomerDto;
import lk.zeon.carrental.entity.Customer;
import lk.zeon.carrental.repository.CustomerRepository;
import lk.zeon.carrental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ze on 10/31/2018.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS ,readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public boolean addCustomerDetail(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setCid(customerDto.getCid());
        customer.setCity(customerDto.getCity());
        customer.setCountry(customerDto.getCountry());
        customer.setFullName(customerDto.getFullName());
        customer.setMobile(customerDto.getMobile());
        customer.setNationality(customerDto.getNationality());
        customer.setNic(customerDto.getNic());

        customerRepository.save(customer);
        return true;
    }

    @Override
    public boolean deleteCustomerDetail(int cid) {
        customerRepository.deleteById(cid);
        return true;

    }

    @Override
    public CustomerDto updateCustomerDetail(CustomerDto customerDto) {
        return null;
    }

    @Override
    public CustomerDto searchCustomerByIDNo(int cid) {
        Customer customer = customerRepository.findById(cid).get();
        CustomerDto customerDto = new CustomerDto(customer.getCid(),customer.getCity() , customer.getCountry() , customer.getFullName() , customer.getMobile() , customer.getNationality() , customer.getNic());
        return customerDto;
    }

    @Override
    public ArrayList<CustomerDto> getAllCustoers() {
        List<Customer> all = customerRepository.findAll();
        ArrayList<CustomerDto> customerDtos = new ArrayList<>();

        for (Customer customer:all) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setCid(customer.getCid());
            customerDto.setCity(customer.getCity());
            customerDto.setCountry(customer.getCountry());
            customerDto.setFullName(customer.getFullName());
            customerDto.setMobile(customer.getMobile());
            customerDto.setNationality(customer.getNationality());
            customerDto.setNic(customer.getNic());

            customerDtos.add(customerDto);

        }
        return customerDtos;

    }
}
