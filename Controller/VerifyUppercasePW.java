package Controller;

public class VerifyUppercasePW extends Chain {
  private Chain next;

  public VerifyUppercasePW() {
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
    if (type.toLowerCase().equals("2")) {
      if (verify(req.getPassword())) {
        System.out.println("Password has uppecased letter");
      } else {
        System.out.println("Password don't has uppercased letter");
      }
    } else {
      if (this.next == null) {
        throw new Error("HANDLER2: Can't handle with this requisition");
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
      if (Character.isUpperCase(value)) {
        return true;
      }
    }

    return false;
  }
}
