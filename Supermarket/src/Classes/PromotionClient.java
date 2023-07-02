package Classes;

public class PromotionClient extends Actor {
  private String promoName;
  private int promoID;

  /**
   * Класс Промо-покупатель
   * @param name - имя покупателя
   * @param promoName - Название акции
   * @param promoID - ИД покупателя- промо
   */
  public PromotionClient(String name, String promoName, Integer promoID) {
    super(name + " - участник акции");
    this.promoID = promoID;
    this.promoName = promoName;

  }
//добавлен статичное поле количество промо-участников
  public static int counter = 0;

//добавлен статичный метод подсчета вызова метода
  public static void countPromoClients() {
    counter++;
      }

  

  @Override
  public String getName() {
    return super.name;
  }

  public boolean isTakeOrder() {
    return super.isTakeOrder;
  }

  public boolean isMakeOrder() {
    return super.isMakeOrder;
  }

  public void setTakeOrder(boolean makeOder) {
    super.isMakeOrder = makeOder;
  }

  public void setMakeOrder(boolean pikUpOrder) {
    super.isTakeOrder = pikUpOrder;
  }

  public Actor getActor() {
    return this;
  }
}
