package th.ac.ku.atm;

public class ATM {
    private Bank bank;
    private Customer loginCustomer;

    public ATM(Bank bank){
        this.bank = bank;
        this.loginCustomer = null;
    }
    public String validateCustomer(int id, int pin){
        //check id : that id exist in the bank??
        Customer customer = bank.findCustomer(id);

        //if existed next step to check pin
        if (customer != null && customer.checkPin(pin)){
            loginCustomer = customer;
            return customer.getName();
        }
        return null;
    }
    //deligation เรียก method เป็นทอด ๆ ส่งการฝากไปให้ bankaccount ทำงานห
    public void deposit(double amount){
        loginCustomer.getAccount().deposit(amount);
    }
    public void withdraw(double amount){
        loginCustomer.getAccount().withdraw(amount);
    }
    public double getBalance(){
        return loginCustomer.getAccount().getBalance();
    }
    public void transfer (int receivingId, double amount){
        Customer receiver = bank.findCustomer(receivingId);
        loginCustomer.getAccount().withdraw(amount);
        receiver.getAccount().deposit(amount);
    }
    public void end(){
        loginCustomer = null;
    }

}
