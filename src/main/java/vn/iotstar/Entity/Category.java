package vn.iotstar.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private int CategoryId;
    private String Categoryname;
    private String Categorycode;
    private String Images;
    private boolean Status;
}
