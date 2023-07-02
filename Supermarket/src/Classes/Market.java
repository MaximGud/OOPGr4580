package Classes;

import java.util.List;
import java.util.ArrayList;

import Interfaces.iActorBehaviuor;

import Interfaces.iMarketBehaviour;
import Interfaces.iQueueBehaviour;
import Interfaces.iReturnOrder;


public class Market implements iMarketBehaviour,iQueueBehaviour, iReturnOrder {

    private List<iActorBehaviuor> queue;

    /**
     * Класс Магазин
     */
    public Market() {
        this.queue = new ArrayList<iActorBehaviuor>();
    }

    @Override
    public void acceptToMarket(iActorBehaviuor actor) {
        System.out.println(actor.getActor().getName()+" клиент пришел в магазин ");
        takeInQueue(actor);
    }

    @Override
    public void takeInQueue(iActorBehaviuor actor) {
        this.queue.add(actor);
        System.out.println(actor.getActor().getName()+" клиент добавлен в очередь ");
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for(Actor actor:actors)
        {
            System.out.println(actor.getName()+" клиент ушел из магазина ");
            queue.remove(actor);
        }
        
    }

    @Override
    public void update() {
       takeOrder();
       giveOrder();
       releaseFromQueue();
    }

    @Override
    public void giveOrder() {
        for(iActorBehaviuor actor: queue)
        {
            if(actor.isMakeOrder())
            {
                actor.setTakeOrder(true);
                System.out.println(actor.getActor().getName()+" клиент получил свой заказ ");
            }
        }
        
    }

    @Override
    public void releaseFromQueue() {
       List<Actor> releaseActors = new ArrayList<>();
       for(iActorBehaviuor actor:queue)
       {
        if(actor.isTakeOrder())
        {
            releaseActors.add(actor.getActor());
            System.out.println(actor.getActor().getName()+" клиент ушел из очереди ");
        }

       }
    releaseFromMarket(releaseActors);
    }



    @Override
    public void takeOrder() {
        for(iActorBehaviuor actor:queue)
        {
            if(!actor.isMakeOrder())
            {
                actor.setMakeOrder(true);
                System.out.println(actor.getActor().getName()+" клиент сделал заказ ");

            }
        }
        
    }

    @Override
    public boolean checkBuy() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkBuy'");
    }

    @Override
    public boolean chekPack() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'chekPack'");
    }

    @Override
    public void setAcceptReturn(boolean acceptReturn) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAcceptReturn'");
    }

    @Override
    public void setMoneyReturn(boolean moneyReturn) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMoneyReturn'");
    }

    @Override
    public Actor getActor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActor'");
    }
   

   


    
}
