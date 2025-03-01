package com.restaurant.client.menuservice.model;

import com.restaurant.client.menuservice.model.enums.DrinkType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.Set;

import static com.restaurant.client.menuservice.model.constant.AllModelConstant.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TABLE_DRINK, uniqueConstraints = {
        @UniqueConstraint(columnNames = FIELD_DRINK_NAME)
})
public class DrinkModel {
    @Id
    @Column(name = FIELD_DRINK_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drinkId;

    @NotBlank
    @Size(max = 255)
    @Column(name = FIELD_DRINK_NAME)
    private String drinkName;

    @NotBlank
    @Size(max = 255)
    private String picture;

    @NotBlank
    @Column(name = FIELD_DRINK_TYPE)
    private String drinkType;

    @ManyToOne
    @JoinColumn(name = FIELD_MENU_ID)
    private MenuModel menu;

    @ManyToMany(mappedBy = MAPPED_BY_DRINKS, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<IngredientModel> ingredients;

}
