package Domen;

public class HotDrinks extends Product {
   // Поля
    private int tempreture;
// Свойства
    public float getDrinkTempr() {
        return tempreture;
    }

    public void setBottleVolume(int tempreture) {
        this.tempreture = tempreture;
    }
    //конструкторы
    public  HotDrinks(int price, int place, String name, long id){
        super(price,place,name,id);
        this.tempreture = 30;
    }
    public HotDrinks(int price, int place, String name, long id, int tempreture){
        super(price,place,name,id);
        this.tempreture = tempreture;
    }

    @Override
    public String toString() {
        return super.toString() + "\ntempreture="+tempreture ;
    }
}
