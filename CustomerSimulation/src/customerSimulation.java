import java.util.Comparator;
import java.util.PriorityQueue;

class Customer
{
    private String name, email;
    private int arrivalTime, age, money;
  
    public Customer(String n, int a, int arr)
    {
        name = n;
        age = a;
        arrivalTime = arr;
    }
  
    public Customer(String n, int a, int arr, String e, int m)
    {
        name = n;
        age = a;
        arrivalTime = arr;
        email = e;
        money = m;
    }
  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String toString()
    {
        return "Customer {name: " + this.name + ", age: " + this.age + ", arrival time: " + this.arrivalTime + " }";
    }
}

class CustomerComparator implements Comparator<Customer>
{
    public int compare(Customer c1, Customer c2){
        if(c1.getArrivalTime() < c2.getArrivalTime())
            return -1;
        else if(c1.getArrivalTime() == c2.getArrivalTime())
            return 0;
        else
            return 1;
    }
}

class WaitingLine
{
    private PriorityQueue<Customer> queue = new PriorityQueue<>(new CustomerComparator());

    public WaitingLine(){}
  
    public void addCustomer(Customer c){
        queue.add(c);
    }  
  
    public void removeCustomer(Customer c){
        queue.remove(c);
    }

    public boolean isEmpty(){
        return queue.size() == 0;
    }

    public int customersInWaiting(){
        return queue.size();
    }
  
    public Customer peekCustomer(){
        if(queue.size() == 0)
            return null;
        return queue.peek();
    }
  
    public Customer serveCustomer(){
        if(queue.size() == 0)
            return null;
        return queue.poll();
    }
}

public class customerSimulation
{
    public static void main(String args[])
    {
        WaitingLine waitingLine = new WaitingLine();

        System.out.println("\nCreating Customers: ");

        Customer c1 = new Customer("Brian Howard", 55, 47);
        System.out.println(c1);
        waitingLine.addCustomer(c1);

        Customer c2 = new Customer("Scott Thede", 50, 36);
        System.out.println(c2);
        waitingLine.addCustomer(c2);


        Customer c3 = new Customer("George Howard", 24, 52);
        System.out.println(c3);
        waitingLine.addCustomer(c3);

        System.out.println("\nCustomers in waiting: " + waitingLine.customersInWaiting());

        System.out.println("\nFrontmost Customer : " + waitingLine.peekCustomer());
        
        System.out.println("\nServing Customers: ");

        while(! waitingLine.isEmpty())
        {
            System.out.println(waitingLine.serveCustomer());
        }

        System.out.println("\nCustomers in waiting: " + waitingLine.customersInWaiting());
    }
}