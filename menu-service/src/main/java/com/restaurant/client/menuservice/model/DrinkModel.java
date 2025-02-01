package com.restaurant.client.menuservice.model;

import com.restaurant.client.menuservice.model.enums.DrinkType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import static com.restaurant.client.menuservice.model.constant.AllModelConstant.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = DRINK_TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(columnNames = DRINK_NAME)
})
public class DrinkModel {
    @Id
    @Column(name = DRINK_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drinkIdl;

    @NotBlank
    @Size(max = 255)
    @Column(name = DRINK_NAME)
    private String drinkName;

    @Column(name = DRINK_TYPE)
    @Enumerated(value = EnumType.STRING)
    private DrinkType drinkType;

    @ManyToOne
    @JoinColumn(name = MENU_ID)
    private MenuModel menu;

}
