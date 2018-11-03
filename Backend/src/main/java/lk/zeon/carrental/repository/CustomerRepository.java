package lk.zeon.carrental.repository;

import lk.zeon.carrental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



/**
 * Created by Ze on 10/31/2018.
 */
public interface CustomerRepository extends JpaRepository<Customer,Integer> {



}
