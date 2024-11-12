package vn.iotstar.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    private String Username;
    private String Password;
    private String Phone;
    private String Fullname;
    private String Email;
    private boolean Admin;
    private boolean Active;
    private String Images;
}
