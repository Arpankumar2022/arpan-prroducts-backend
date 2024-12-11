package collections;

import java.util.Optional;

public class User {

    public Optional<Address> address;

    @Override
    public String toString() {
        return "User{" +
                "address=" + address +
                '}';
    }

    public Optional<Address> getAddress() {
        return address;
    }

    public void setAddress(Optional<Address> address) {
        this.address = address;
    }

    public User(Optional<Address> address) {
        this.address = address;
    }
}
