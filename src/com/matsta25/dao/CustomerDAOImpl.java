package com.matsta25.dao;

import com.matsta25.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> getCustomers() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Customer> theQuery =
                currentSession.createQuery("FROM Customer" +
                        " ORDER BY lastName", Customer.class);

        return theQuery.getResultList();
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int customerId) {

        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.get(Customer.class, customerId);
    }

    @Override
    public void deleteCustomer(int customerId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Customer customer = currentSession.get(Customer.class, customerId);

        currentSession.delete(customer);
    }
}
