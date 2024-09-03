package uz.pdp.online.matritsaniosinshtartibidachiqarish.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResultMatrixDto {
    List<List<Integer>> generated;
    List<List<Integer>> sorted;
}
