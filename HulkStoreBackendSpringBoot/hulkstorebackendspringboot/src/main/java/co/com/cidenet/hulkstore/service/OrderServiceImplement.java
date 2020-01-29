package co.com.cidenet.hulkstore.service;

import co.com.cidenet.hulkstore.entity.Order;
import co.com.cidenet.hulkstore.entity.Product;
import co.com.cidenet.hulkstore.repository.InterfaceOrderRepository;
import co.com.cidenet.hulkstore.repository.InterfaceProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImplement implements InterfaceOrderService {
    @Autowired
    private InterfaceOrderRepository orderDao;

    @Autowired
    private InterfaceProductRepository productDao;

    @Override
    @Transactional(readOnly = true)
    public Order findOrderById(Long id) {
        return orderDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Order saveOrder(Order order) {
        return orderDao.save(order);
    }

    @Override
    @Transactional
    public void deleteOrderById(Long id) {
        orderDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findProductByName(String term) {
        return productDao.findByNameContainingIgnoreCase(term);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> findAll() {
        return (List<Order>) orderDao.findAll();
    }
}