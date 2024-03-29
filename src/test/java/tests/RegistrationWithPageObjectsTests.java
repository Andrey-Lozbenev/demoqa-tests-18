package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTests extends SetBasePageSettings {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {


        String userFirstName = "Vasia";
        String userLastName = "Petrov";
        String userEmail = "test@test.com";
        String userGender = "Male";
        String userMobile = "7900000000";
        String userBirthDay = "2";
        String userBirthMonth = "May";
        String userBirthYear = "1990";
        String userSubjects = "Maths";
        String userHobbies = "Sports";
        String userPicture = "pictures/pic.png";
        String userPictureName = "pic.png";
        String userAddress = "Lenina";
        String userState = "ncr";
        String userCity = "Noida";


        registrationPage.openPage()
                .setUserFirstName(userFirstName)
                .setUserLastName(userLastName)
                .setUserEmail(userEmail)
                .setUserGender(userGender)
                .setUserMobile(userMobile)
                .setUserBirthDate(userBirthDay, userBirthMonth, userBirthYear)
                .setUserSubjects(userSubjects)
                .setUserHobbies(userHobbies)
                .setUserPicture(userPicture)
                .setUserAddress(userAddress)
                .setUserState(userState)
                .setUserCity(userCity)
                .submitForm();
        registrationPage.verifyResult("Student Name", userFirstName + " " + userLastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userMobile)
                .verifyResult("Date of Birth", userBirthDay + " "  + userBirthMonth + "," + userBirthYear)
                .verifyResult("Subjects", userSubjects)
                .verifyResult("Hobbies", userHobbies)
                .verifyResult("Picture", userPictureName)
                .verifyResult("Address", userAddress)
                .verifyResult("State and City", userState + " " + userCity);


    }
}
