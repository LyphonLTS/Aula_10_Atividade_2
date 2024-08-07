package Controller;

public class Requisition {
  private String login;
  private String password;

  public Requisition(String login, String password) {
    this.login = login;
    this.password = password;
  }

  public String getLogin() {
    return this.login;
  }

  public String getPassword() {
    return this.password;
  }
}
