package Controller;

public class VerifyMaximumPW extends Chain {
  private Chain next;

  public VerifyMaximumPW() {
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
    if (type.toLowerCase().equals("8")) {
      if (verify(req.getPassword())) {
        System.out.println("Password has less than 16 characters");
      } else {
        System.out.println("Password don't has less than 16 characters");
      }
    } else {
      if (this.next == null) {
        throw new Error("Can't handle with this requisition, HANDLER8");
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

    if (count <= 16) {
      return true;
    } else {
      return false;
    }
  }
}
