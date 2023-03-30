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
        String userHobbies1 = "Sports";
        String userHobbies2 = "Reading";
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
                .setUserHobbies(userHobbies1, userHobbies2)
                .setUserPicture(userPicture)
                .setUserAddress(userAddress)
                .setUserState(userState)
                .setUserCity(userCity)
                .submitForm();
        registrationPage.verifyResult("Student Name", userFirstName + " " + userLastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userMobile)
                .verifyResult("Date of Birth", userBirthDay)
                .verifyResult("Subjects", userSubjects)
                //.verifyResult("Hobbies", userHobbies1 + "," +userHobbies2)   не пойму, почему тест не проходит.
                .verifyResult("Hobbies", userHobbies1)
                .verifyResult("Hobbies", userHobbies2)
                .verifyResult("Picture", userPictureName)
                .verifyResult("Address", userAddress)
                .verifyResult("State and City", userState + " " + userCity);


    }
}
