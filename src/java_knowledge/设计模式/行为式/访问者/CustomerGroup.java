package java_knowledge.设计模式.行为式.访问者;

import java.util.ArrayList;
import java.util.List;

/**
 * 类似于一个树形的组合结构，Customer下面有order,order下面有item。这只是各种Element的实现，并通过一定的条件组合.CustomerGroup是组合的顶部。
 * 而访问者提供几种实现的访问方式.
 */
public class CustomerGroup {
    private List<Customer> customers = new ArrayList<>();

    void accept(Visitor visitor) {
        for (Customer customer : customers) {
            customer.accept(visitor);
        }
    }

    void addCustomer(Customer customer) {
        customers.add(customer);
    }
}
