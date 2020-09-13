package th.ac.ku.atm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        Customer peter = new Customer (1,"Peter",1234,1000);
//        Customer kat = new Customer(2,"Katherine",2345,2000);

//        Bank bank = new Bank("KU Bank");
//        bank.registerCustomer(peter);
//        bank.registerCustomer(kat);

//        Customer c = bank.findCustomer(3);
//        System.out.println(c.getName());

        //การทำ dependency injection เราสามารถเปลัี่ยน object ได้ เช่นอย่างงนี้เราสามารถเปลี่ยน bank ได้ เปลี่ยน dataSource ได้
        //layer of indirection ตอนเปลี่ยน class จะง่ายขึ้น dataSourceDB, dataSourceFiles use interface


        ApplicationContext context = new AnnotationConfigApplicationContext(ATMConfig.class);
        //อยากได้ object ไหนเราสามารถเรียกผ่าน context.getBean (use spring framework)
        ATM atm = context.getBean(ATM.class);
        String name = atm.validateCustomer(1,1234);
        System.out.println(name + " has " + atm.getBalance());
        atm.withdraw(200);
        System.out.println(name + " has " + atm.getBalance());


//        atm.transfer(3,1000);
//        System.out.println(name + " has " + atm.getBalance());
//        atm.end();
//
//        name = atm.validateCustomer(3,3456);
//        System.out.println(name + " has " + atm.getBalance());
    }
}
