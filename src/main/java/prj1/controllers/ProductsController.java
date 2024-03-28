package prj1.controllers;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import prj1.commons.Constants;
import prj1.exceptions.CustomExeption;
import prj1.models.product.ProductDto;
import prj1.models.response.ResponseData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import prj1.services.ProductService;
import reactor.core.publisher.Mono;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/product")
@Slf4j
public class ProductsController {
    private final ProductService productService;

    @GetMapping
    public Mono<ResponseEntity<ResponseData<Object>>> search(
            ServerHttpRequest request,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {

        ResponseData<Object> response =
                new ResponseData<>(request);
        HttpStatus statusResponse;
        try {
            statusResponse = HttpStatus.OK;
            response.success(productService.search(PageRequest.of(page, size)));
        } catch (CustomExeption ex) {
            log.error(ex.getMessage(), ex);
            statusResponse = HttpStatus.BAD_REQUEST;
            response.error(
                    statusResponse.value(), ex.getMessage(), ex.getMessageKey(), statusResponse.value());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            statusResponse = HttpStatus.INTERNAL_SERVER_ERROR;
            response.error(statusResponse.value(), ex.getMessage(), statusResponse.value());
        }
        return Mono.just(new ResponseEntity<>(response, statusResponse));
    }

    @PutMapping
    public Mono<ResponseEntity<ResponseData<Object>>> createOrUpdate(
            @RequestBody ProductDto dto, ServerHttpRequest request) {
        ResponseData<Object> response =
                new ResponseData<>(request);
        HttpStatus statusResponse;
        try {
            statusResponse = HttpStatus.OK;
            productService.createOrUpdate(dto);
            response.success("");
        } catch (CustomExeption ex) {
            log.error(ex.getMessage(), ex);
            statusResponse = HttpStatus.BAD_REQUEST;
            response.error(
                    statusResponse.value(), ex.getMessage(), ex.getMessageKey(), statusResponse.value());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            statusResponse = HttpStatus.INTERNAL_SERVER_ERROR;
            response.error(statusResponse.value(), ex.getMessage(), statusResponse.value());
        }
        return Mono.just(new ResponseEntity<>(response, statusResponse));
    }
}
