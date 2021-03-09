package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import persistance.gateway.customer.CustomerGateway;
import persistance.gateway.customer.CustomerJPAGateway;
import persistance.gateway.distributor.DistributorGateway;
import persistance.gateway.distributor.DistributorJPAGateway;
import persistance.gateway.item.ItemGateway;
import persistance.gateway.item.ItemJPAGateway;
import persistance.gateway.itemType.ItemTypeGateway;
import persistance.gateway.itemType.ItemTypeJPAGateway;
import persistance.gateway.paymentType.PaymentTypeGateway;
import persistance.gateway.paymentType.PaymentTypeJPAGateway;
import persistance.gateway.transaction.TransactionGateway;
import persistance.gateway.transaction.TransactionJPAGateway;
import persistance.repository.*;
import service.customer.Customer;
import service.customer.CustomerService;
import service.distributor.Distributor;
import service.distributor.DistributorService;
import service.item.Item;
import service.item.ItemService;
import service.itemType.ItemType;
import service.itemType.ItemTypeService;
import service.paymentType.PaymentType;
import service.paymentType.PaymentTypeService;
import service.transaction.Transaction;
import service.transaction.TransactionService;

@EnableJpaRepositories(basePackageClasses = CustomerRepository.class)
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
