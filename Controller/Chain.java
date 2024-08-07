package Controller;

public abstract class Chain {
  protected Chain next;

  public Chain() {
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
    if (type.toLowerCase().equals("verify login")) {
      if (verify(req.getLogin())) {
        System.out.println("Valid login");
      } else {
        System.out.println("Invalid login");
      }
    } else {
      if (this.next == null) {
        throw new Error("Can't handle with the requisition");
      }

      this.next.canHandle(req, type);
    }
  }

  protected abstract boolean verify(String login);
}
