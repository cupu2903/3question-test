package com.mitrais.dkatalis.util;

import com.mitrais.dkatalis.repository.domain.*;
import com.mitrais.dkatalis.web.dto.*;
import fr.xebia.extras.selma.*;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 1.0
 * @since 19/09/2019
 */
@Mapper(withIgnoreMissing = IgnoreMissing.ALL, withIoC = IoC.SPRING)
public interface ModelMapper {

    UserSimpleDto asUserDto(Users user);

    @Maps(withCustomFields =
            {@Field({"CartItem.id.itemCode", "ItemDto.itemCode"}),
            @Field({"CartItem.item.itemName", "ItemDto.itemName"}),
            @Field({"CartItem.item.price", "ItemDto.price"})})
    ItemDto asItemDto(CartItem cartItem);

    ItemDto asItemDtoFromItem(Item item);
}
