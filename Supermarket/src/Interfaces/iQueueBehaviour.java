package Interfaces;


public interface iQueueBehaviour {
    /**
     * @param actor - покупатель
     */
    void takeInQueue(iActorBehaviuor actor);
    /**
     * Метод-схема "Выход из очереди"
     */
    void releaseFromQueue();
    /**
     * Метод-схема "Создание заказа"
     */
    void takeOrder();
    /**
     * Метод-схема "Выдача заказа"
     */
    void giveOrder();
}
