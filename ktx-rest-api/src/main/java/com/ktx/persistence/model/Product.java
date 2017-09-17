package com.ktx.persistence.model;


import com.ktx.common.interfaces.IWithAllFields;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class  Product implements IWithAllFields {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(position = 1,required = true,value = "Auto-Generated")
    private @Getter  @Setter int id;

    @ApiModelProperty(position = 2,required = true,value = "String Value")
    @Column(nullable = false)
    private @Getter @Setter String name;

    @ApiModelProperty(position = 3,required = true,value = "Inte  ger Value")
    @Column(nullable = false)
    private @Getter @Setter int price;
}
