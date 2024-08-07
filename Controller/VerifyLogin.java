package Controller;

import java.util.ArrayList;

public class VerifyLogin extends Chain {
  private ArrayList<String> data;
  private Chain next;

  public VerifyLogin() {
    super();

    this.data = new ArrayList<>();
    this.data.add("user1");
    this.data.add("user2");
    this.data.add("user3");
    this.next = null;
  }

  public void setNext(Chain next) {
    if (this.next == null) {
      this.next = next;
    } else {
      this.next.setNext(next);
    }
  }

  public void canHandle(Requisition req, String type) throws Exception {
    if (type.toLowerCase().equals("1")) {
      if (verify(req.getLogin())) {
        System.out.println("Valid login");
      } else {
        System.out.println("Invalid login");
      }
    } else {
      if (this.next == null) {
        throw new Error("HANDLER1: Can't handle with this requisition");
      }

      this.next.canHandle(req, type);
    }
  }

  @Override
  protected boolean verify(String login) {
    for (String value : data) {
      if (!login.toLowerCase().equals(value) || login == null || login.isEmpty()) {

      } else {
        return true;
      }
    }

    return false;
  }
}
