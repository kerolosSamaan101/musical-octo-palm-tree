package Pages.Registeration;

public class RegisterationTest {

    final Registeration registeration = new Registeration();

    @org.testng.annotations.Test(priority = 1)
    public void RegisterWithUser() throws InterruptedException {
        registeration.RegisterWithValidUser();
    }
}
