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
public class Favorites {
    private int FavoriteId;
    private Date LikedDate;
    private String VideoId;
    private String Username;
}
