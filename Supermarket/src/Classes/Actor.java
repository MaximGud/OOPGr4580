package Classes;

import Interfaces.iActorBehaviuor;


public abstract class Actor implements iActorBehaviuor {
    protected String name;
    protected boolean isTakeOrder;
    protected boolean isMakeOrder;

    /**
     * Абстрактный класс Покупатель, схема
     * @param name - имя Покупателя
     */
    public Actor(String name) {
        this.name = name;
    }

    abstract public String getName();

}
