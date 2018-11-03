package lk.zeon.carrental.service;

import lk.zeon.carrental.dto.CustomerDto;
import lk.zeon.carrental.entity.Customer;

import java.util.ArrayList;

/**
 * Created by Ze on 10/31/2018.
 */
public interface CustomerService {
    public boolean addCustomerDetail(CustomerDto customerDto);
    public boolean deleteCustomerDetail(int cid);
    public  CustomerDto updateCustomerDetail(CustomerDto  customerDto);
    public CustomerDto searchCustomerByIDNo(int cid);
    public ArrayList<CustomerDto>getAllCustoers();

}
