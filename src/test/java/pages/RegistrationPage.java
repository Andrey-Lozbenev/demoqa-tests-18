package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private SelenideElement
            firstNameInpute = $("[id=firstName]"),
            lastNameInput = $("[id=lastName]"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            mobileInput = $("#userNumber"),
            birthDateElement = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesChecBoxs = $("#hobbiesWrapper"),
            addressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitButton = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setUserFirstName(String value) {
        firstNameInpute.setValue(value);

        return this;
    }

    public RegistrationPage setUserLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserMobile(String value) {
        mobileInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserBirthDate(String day, String month, String year) {
        birthDateElement.click();
        CalendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setUserSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setUserHobbies(String value) {
        hobbiesChecBoxs.$(byText(value)).click();
        return this;

    }

    public RegistrationPage setUserPicture(String value) {
        $("#uploadPicture").uploadFromClasspath(value);
        return this;

    }

    public RegistrationPage setUserAddress(String value) {
        addressInput.setValue(value);
        return this;

    }

    public RegistrationPage setUserState(String value) {
        stateInput.setValue(value).pressEnter();

        return this;

    }

    public RegistrationPage setUserCity(String value) {
        cityInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.click();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResultFromModal(key, value);

        return this;
    }
}
