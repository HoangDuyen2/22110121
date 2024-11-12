package vn.iotstar.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Video {
    private String VideoId;
    private String Title;
    private String Poster;
    private int Views;
    private String Description;
    private boolean Active;
    private int CategoryId;
}
