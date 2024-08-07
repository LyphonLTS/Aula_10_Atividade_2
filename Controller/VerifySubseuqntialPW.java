package Controller;

import java.util.ArrayList;

public class VerifySubseuqntialPW extends Chain {
  private Chain next;

  public VerifySubseuqntialPW() {
    super();

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
    if (type.toLowerCase().equals("6")) {
      if (verify(req.getPassword())) {
        System.out.println("Password don't has subsequential numbers");
      } else {
        System.out.println("Password has subsequential numbers");
      }
    } else {
      if (this.next == null) {
        throw new Error("Can't handle with this requisition, HANDLER6");
      }

      this.next.canHandle(req, type);
    }

  }

  @Override
  protected boolean verify(String password) {
    if (password == null || password.isEmpty()) {
      return true;
    }

    ArrayList<Integer> numbers = new ArrayList<>();

    for (char value : password.toCharArray()) {
      if (Character.isDigit(value)) {
        numbers.add(Integer.parseInt(String.valueOf(value)));
      }
    }

    for (int i = 0; i < numbers.size() - 1; i++) {
      if (numbers.get(i + 1) == numbers.get(i) + 1 && numbers.get(i + 2) == numbers.get(i) + 2) {
        return false;
      }
    }

    return true;
  }
}
