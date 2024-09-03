package uz.pdp.online.matritsaniosinshtartibidachiqarish.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.online.matritsaniosinshtartibidachiqarish.dto.response.ResultMatrixDto;
import uz.pdp.online.matritsaniosinshtartibidachiqarish.service.GeneratingAndSortingService;

import java.lang.reflect.Method;
import java.util.List;

@RestController
@RequestMapping("/generate")
public class GeneratingAndSortingController {

    private final GeneratingAndSortingService generatingAndSortingService;

    public GeneratingAndSortingController(GeneratingAndSortingService generatingAndSortingService) {
        this.generatingAndSortingService = generatingAndSortingService;
    }

    @RequestMapping(value = "/sort-in-ascending-order/get", method = RequestMethod.GET)
    public ResponseEntity<ResultMatrixDto> generateAndSortInAscendingOrder(@RequestParam("rows") int rowLength, @RequestParam("columns") int columnLength) {

        int[][] matrix = generatingAndSortingService.generateMatrix(rowLength, columnLength);

        List<List<Integer>> generatedMatrix = generatingAndSortingService.getAsList(matrix, rowLength, columnLength);

        List<List<Integer>> sortedMatrix = generatingAndSortingService.sortMatrixAndGetAsList(matrix, rowLength, columnLength);

        return ResponseEntity.ok(new ResultMatrixDto(generatedMatrix, sortedMatrix));

    }

}
