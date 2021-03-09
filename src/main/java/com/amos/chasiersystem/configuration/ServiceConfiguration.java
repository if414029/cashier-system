package com.amos.chasiersystem.configuration;

import com.amos.chasiersystem.controller.CustomerController;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.amos.chasiersystem.persistance.gateway.customer.CustomerGateway;
import com.amos.chasiersystem.persistance.gateway.customer.CustomerJPAGateway;
import com.amos.chasiersystem.persistance.gateway.distributor.DistributorGateway;
import com.amos.chasiersystem.persistance.gateway.distributor.DistributorJPAGateway;
import com.amos.chasiersystem.persistance.gateway.item.ItemGateway;
import com.amos.chasiersystem.persistance.gateway.item.ItemJPAGateway;
import com.amos.chasiersystem.persistance.gateway.itemType.ItemTypeGateway;
import com.amos.chasiersystem.persistance.gateway.itemType.ItemTypeJPAGateway;
import com.amos.chasiersystem.persistance.gateway.paymentType.PaymentTypeGateway;
import com.amos.chasiersystem.persistance.gateway.paymentType.PaymentTypeJPAGateway;
import com.amos.chasiersystem.persistance.gateway.transaction.TransactionGateway;
import com.amos.chasiersystem.persistance.gateway.transaction.TransactionJPAGateway;
import com.amos.chasiersystem.persistance.repository.*;
import com.amos.chasiersystem.service.customer.Customer;
import com.amos.chasiersystem.service.customer.CustomerService;
import com.amos.chasiersystem.service.distributor.Distributor;
import com.amos.chasiersystem.service.distributor.DistributorService;
import com.amos.chasiersystem.service.item.Item;
import com.amos.chasiersystem.service.item.ItemService;
import com.amos.chasiersystem.service.itemType.ItemType;
import com.amos.chasiersystem.service.itemType.ItemTypeService;
import com.amos.chasiersystem.service.paymentType.PaymentType;
import com.amos.chasiersystem.service.paymentType.PaymentTypeService;
import com.amos.chasiersystem.service.transaction.Transaction;
import com.amos.chasiersystem.service.transaction.TransactionService;

@Configuration
public class ServiceConfiguration {

    @Bean
    public CustomerGateway customerGateway(CustomerRepository repository){
        return new CustomerJPAGateway(repository);
    }

    @Bean
    public Customer customer(CustomerGateway gateway){
        return new CustomerService(gateway);
    }

    @Bean
    public DistributorGateway distributorGateway(DistributorRepository repository){
        return new DistributorJPAGateway(repository);
    }

    @Bean
    public Distributor distributor(DistributorGateway gateway){
        return new DistributorService(gateway);
    }

    @Bean
    public ItemTypeGateway itemTypeGateway(ItemTypeRepository repository){
        return new ItemTypeJPAGateway(repository);
    }

    @Bean
    public ItemType itemType(ItemTypeGateway gateway){
        return new ItemTypeService(gateway);
    }

    @Bean
    public ItemGateway itemGateway(ItemRepository repository){
        return new ItemJPAGateway(repository);
    }

    @Bean
    public Item item(ItemGateway gateway, ItemTypeGateway itemTypeGateway, DistributorGateway distributorGateway){
        return new ItemService(gateway, itemTypeGateway, distributorGateway);
    }

    @Bean
    public PaymentTypeGateway paymentTypeGateway(PaymentTypeRepository repository){
        return new PaymentTypeJPAGateway(repository);
    }

    @Bean
    public PaymentType paymentType(PaymentTypeGateway gateway){
        return new PaymentTypeService(gateway);
    }

    @Bean
    public TransactionGateway transactionGateway(TransactionRepository repository){
        return new TransactionJPAGateway(repository);
    }

    @Bean
    public Transaction transaction(TransactionGateway gateway, CustomerGateway customerGateway, ItemGateway itemGateway, PaymentTypeGateway paymentTypeGateway){
        return new TransactionService(gateway, customerGateway, itemGateway, paymentTypeGateway);
    }

}
