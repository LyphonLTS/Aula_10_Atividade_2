import Controller.Chain;
import Controller.Requisition;
import Controller.VerifyLogin;
import Controller.VerifyLowercasePW;
import Controller.VerifyMaximumPW;
import Controller.VerifyMinimumPW;
import Controller.VerifyNumberPW;
import Controller.VerifySpecialsPW;
import Controller.VerifySubseuqntialPW;
import Controller.VerifyUppercasePW;

class Main {
  public static void main(String[] args) {
    Requisition req1 = new Requisition("user1", "Teste@16");

    Chain handler = new VerifyLogin();
    handler.setNext(new VerifyUppercasePW());
    handler.setNext(new VerifyLowercasePW());
    handler.setNext(new VerifySpecialsPW());
    handler.setNext(new VerifyNumberPW());
    handler.setNext(new VerifySubseuqntialPW());
    handler.setNext(new VerifyMinimumPW());
    handler.setNext(new VerifyMaximumPW());

    try {
      handler.canHandle(req1, "1");
      handler.canHandle(req1, "2");
      handler.canHandle(req1, "3");
      handler.canHandle(req1, "4");
      handler.canHandle(req1, "5");
      handler.canHandle(req1, "6");
      handler.canHandle(req1, "7");
      handler.canHandle(req1, "8");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}