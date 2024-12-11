package collections;

import java.util.Optional;

public class Address {
    private Optional<String> city;

    public Address(Optional<String> city) {
        this.city = city;
    }

    public Optional<String> getCity() {
        return city;
    }

    public void setCity(Optional<String> city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }


}
