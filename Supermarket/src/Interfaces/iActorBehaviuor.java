package Interfaces;

import Classes.Actor;

public interface iActorBehaviuor {

    /**
     * @return
     * Метод-схема проверки создания заказа
     */
    public boolean isTakeOrder() ;
    /**
     * @return
     * Метод-схема проверки выполнения заказа
     */
    public boolean isMakeOrder() ;
    /**
     * @param takeOrder  - взять заказ
     * Метод-схема установки заказа
     */
    public void setTakeOrder(boolean takeOrder) ;
    /**
     * @param makeOrder - выполнить заказ
     * Метод-схема выполнения заказа
     */
    public void setMakeOrder(boolean makeOrder) ;
    /**
     * @return
     */
    Actor getActor();
    
}
