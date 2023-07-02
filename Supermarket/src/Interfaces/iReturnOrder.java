package Interfaces;

import Classes.Actor;

public interface iReturnOrder {
  /**
   * @return
   */
  public boolean checkBuy(); // метод проверки покупки при возврате

  /**
   * @return
   */
  public boolean chekPack(); // метод проверки упаковки при возврате

  /**
   * @param acceptReturn - проверка наличия возврата
   */
  public void setAcceptReturn(boolean acceptReturn); // приемка возврата

  /**
   * @param moneyReturn - возврат денег
   */
  public void setMoneyReturn(boolean moneyReturn); // возврат денег

  /**
   * @return
   */
  Actor getActor();
}
