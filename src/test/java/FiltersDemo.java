import java.util.ArrayList;

class product {
    int id;
    String name;
    double price;

    public product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

}

public class FiltersDemo {

    public static void main(String[] args) {

        ArrayList<product> al = new ArrayList<product>();
        al.add(new product(1, "apple", 90000)); 
        al.add(new product(2, "samsung", 80000));
        al.add(new product(3, "LG", 50000));
        al.add(new product(4, "lenovo", 40000));

        al.stream().filter(p -> p.price >= 50000).forEach(s->System.out.println(s.name));
        

    }

}
