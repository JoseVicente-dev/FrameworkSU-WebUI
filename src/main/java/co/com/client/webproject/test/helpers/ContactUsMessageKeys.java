package co.com.client.webproject.test.helpers;

public enum ContactUsMessageKeys {
    SUBJECT("SubjectHeading"),
    EMAIL("Email"),
    MESSAGE("Message");

    private final String value;

    ContactUsMessageKeys(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
