package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestData.*;
import static utils.RandomValuesUtils.getRandomItemFromArray;

public class RegistrationWithFakerDataTests extends SetBasePageSettings {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        Faker faker = new Faker();

        String userFirstName = faker.name().firstName(),
                userLastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                userGender = getRandomItemFromArray(gender),
                userMobile = faker.phoneNumber().subscriberNumber(10),
                userBirthDay = String.valueOf(faker.number().numberBetween(1, 28)),
                userBirthMonth = getRandomItemFromArray(months),
                userBirthYear = String.valueOf(faker.number().numberBetween(1900, 2022)),
                userSubjects = getRandomItemFromArray(subjects),
                userHobbies = getRandomItemFromArray(hobbiess),
                userPicture = "pictures/pic.png",
                userPictureName = "pic.png",
                userAddress = faker.address().fullAddress(),
                userState = getRandomItemFromArray(states),
                userCity = getRandomItemFromArray(cities);


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
                .verifyResult("Date of Birth", userBirthDay + " " + userBirthMonth + "," + userBirthYear)
                .verifyResult("Subjects", userSubjects)
                .verifyResult("Hobbies", userHobbies)
                .verifyResult("Picture", userPictureName)
                .verifyResult("Address", userAddress)
                .verifyResult("State and City", userState + " " + userCity);


    }
}
