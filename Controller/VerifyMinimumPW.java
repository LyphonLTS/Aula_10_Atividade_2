package Controller;

public class VerifyMinimumPW extends Chain {
  private Chain next;

  public VerifyMinimumPW() {
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
    if (type.toLowerCase().equals("7")) {
      if (verify(req.getPassword())) {
        System.out.println("Password has more than 8 characters");
      } else {
        System.out.println("Password don't has more than 8 characters");
      }
    } else {
      if (this.next == null) {
        throw new Error("Can't handle with this requisition, HANDLER7");
      }

      this.next.canHandle(req, type);
    }

  }

  @Override
  protected boolean verify(String password) {
    if (password == null || password.isEmpty()) {
      return false;
    }

    int count = password.length();

    if (8 <= count) {
      return true;
    } else {
      return false;
    }
  }
}
