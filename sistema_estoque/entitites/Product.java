package completo.java.construtores.entitites;

public class Product{


    private String name;
    private double price;
    private int quantity;

    public Product(){
    }

    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    //sobrecarregando construtor
    public Product(String name, double price){
        this.name = name;
        this.price = price;
        //por padrão a linguagem inicia numeros com o valor zero
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() { //apenas o método get para proteção do sistema
        return quantity;
    }

    public double totalValueInStock(){
        return price * quantity;
    }

    public void addProducts(int quantity){
        this.quantity +=quantity;
    }

    public void removeProducts(int quantity){
        this.quantity -= quantity;
    }
    public String toString(){
        return name + ", $ "+ String.format("%.2f", price)+ ", "+ quantity + "units, Total: $ "+ String.format("%.2f", totalValueInStock());
    }
}