package Controller;

public class VerifyNumberPW extends Chain {
  private Chain next;

  public VerifyNumberPW() {
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
    if (type.toLowerCase().equals("5")) {
      if (verify(req.getPassword())) {
        System.out.println("The password has a number");
      } else {
        System.out.println("The password don't has a number");
      }
    } else {
      if (this.next == null) {
        throw new Error("Can't handle with this requisition, HANDLER5");
      }

      this.next.canHandle(req, type);
    }

  }

  @Override
  protected boolean verify(String password) {
    if (password == null || password.isEmpty()) {
      return false;
    }

    for (char value : password.toCharArray()) {
      if (Character.isDigit(value)) {
        return true;
      }
    }

    return false;
  }
}
