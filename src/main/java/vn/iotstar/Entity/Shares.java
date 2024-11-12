package vn.iotstar.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shares {
    private int ShareId;
    private String Emails;
    private Date SharedDate;
    private String Username;
    private String VideoId;
}
