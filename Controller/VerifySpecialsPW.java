package Controller;

public class VerifySpecialsPW extends Chain {
  private Chain next;

  public VerifySpecialsPW() {
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
    if (type.toLowerCase().equals("4")) {
      if (verify(req.getPassword())) {
        System.out.println("Password has special character");
      } else {
        System.out.println("Password don't has special character");
      }
    } else {
      if (this.next == null) {
        throw new Error("HANDLER4: Can't handle with this requisition");
      }

      this.next.canHandle(req, type);
    }

  }

  @Override
  protected boolean verify(String password) {
    return password.matches(".*[@#$%&*].*");
  }
}
