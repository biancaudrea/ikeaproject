package ro.utcn.project.dto;

public class UserAddressDto {
    private String address;

    public String getAddress() {
        return address;
    }

    public UserAddressDto() {
    }

    public UserAddressDto(String address) {
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
