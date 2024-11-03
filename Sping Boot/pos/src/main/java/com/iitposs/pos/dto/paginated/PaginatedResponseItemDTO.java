package com.iitposs.pos.dto.paginated;

import com.iitposs.pos.dto.response.ItemResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseItemDTO {

    List<ItemResponseDto> list;
    private long dataCount;

}
