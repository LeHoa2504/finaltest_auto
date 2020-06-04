package testfinal.abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Consequence;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class Authenticate implements Ability {
    private String Email;
    private String Password;

    public String getEmail(){

        return this.Email;
    }

    public String getPassword(){
        return this.Password;
    }

    public Authenticate(String username, String password){
        this.Email = username;
        this.Password = password;
    }

    public static Authenticate LoadTestData(String actorName) throws IOException {
        try {
            Reader dataReader = new FileReader("src\\test\\resources\\TestData\\user."+actorName.toLowerCase()+".properties");
            Properties dataProperties = new Properties();
            dataProperties.load(dataReader);

            String Email = dataProperties.getProperty("email");
            String Password = dataProperties.getProperty("password");
            return new  Authenticate(Email, Password);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new Authenticate("", "");
    }
    public static Authenticate as(Actor actor){

        if(actor.abilityTo(Authenticate.class)==null){
            throw new ExceptionInInitializerError(actor.getName() + "doesn't has a Authenticate ability");
        }
        else {
            return actor.abilityTo(Authenticate.class);
        }
    }
}
