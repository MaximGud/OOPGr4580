package Interfaces;

import java.util.List;

import Classes.Actor;

public interface iMarketBehaviour {
    /**
     * @param actor - покупатель
     * Метод -схема вход в магазин
     */
    void acceptToMarket(iActorBehaviuor actor);
    /**
     * @param actor- покупатель
     * Метод -схема выход из магазина
     */
    void releaseFromMarket(List<Actor> actor);
    /**
     * Обновление
     */
    void update();
}
