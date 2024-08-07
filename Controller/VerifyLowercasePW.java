package Controller;

public class VerifyLowercasePW extends Chain {
  private Chain next;

  public VerifyLowercasePW() {
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
    if (type.toLowerCase().equals("3")) {
      if (verify(req.getPassword())) {
        System.out.println("Password has lowercased letter");
      } else {
        System.out.println("Password don't has lowercased letter");
      }
    } else {
      if (this.next == null) {
        throw new Error("HANDLER3: Can't handle with this requisition");
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
      if (Character.isLowerCase(value)) {
        return true;
      }
    }

    return false;
  }
}
