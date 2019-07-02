public enum Constants {

    YANDEXURL("https://api.rasp.yandex.net/v3.0"),
    KEY("47578f4e-0b00-45d2-be0d-2b263e9b5c04");

    private String value;
    private Constants(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
