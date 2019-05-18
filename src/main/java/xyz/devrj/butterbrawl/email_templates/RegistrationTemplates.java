package xyz.devrj.butterbrawl.email_templates;

public class RegistrationTemplates {

    public static String getWelcomeUser(String username, String firstname, String groupname){
        return "<div style=\"text-align:center;\"> <h2>Hello, " + firstname + "</h2> <br> " +
                "<h3> Thank you for joining butterBRAWL! </h3><br><br>" +
                "Your username is:<b> " + username + " </b><br>" +
                "Your group is:<b> " + groupname + " </b><br><br>" +
                "We are proud of you for taking control of your life and your weight! This is going<br>" +
                "to be an amazing adventure! Good Luck!" +
                "</div>";
    }
}
