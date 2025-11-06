package com.gaia.snpc.controllers;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import com.gaia.snpc.services.interfaces.RegionService;
import com.gaia.snpc.domains.dtos.request.RegionRequestDTO;
import com.gaia.snpc.domains.dtos.responses.RegionResponseDTO;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/regions")
@Tag(name = "Gestion des regions", description = "API pour la gestion des regions")
public class RegionController {

    private final RegionService service;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Retourne toutes les regions")
    public ResponseEntity<List<RegionResponseDTO>> getAllCommune(){
        log.info("Call retrieve all regions");
        return new ResponseEntity<>(service.search(), OK);
    }

    @GetMapping(path = "/{code}", produces = APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Retourne une region en fonction de son code",
            parameters = {
                    @Parameter(
                            name = "code",
                            description = "Code de la region",
                            required = true,
                            in = ParameterIn.PATH,
                            example = "YND"
                    )
            }
    )
    public ResponseEntity<RegionResponseDTO> getRegionByCode(@PathVariable("code") String code){
        log.info("Call retrieve one region");
        return new ResponseEntity<>(service.getByCode(code), OK);
    }


    @Operation(summary = "Creer une region")
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<RegionResponseDTO> save(@RequestBody RegionRequestDTO dto) {
        return new ResponseEntity<>(service.create(dto), CREATED);
    }

    @Operation(
            summary = "Modifier une region en fonction de son code",
            parameters = {
                    @Parameter(
                            name = "code",
                            description = "Code de la region",
                            required = true,
                            in = ParameterIn.PATH,
                            example = "YND"
                    )
            }
    )
    @PutMapping(path = "/{code}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<RegionResponseDTO> update(@PathVariable("code") String code, @RequestBody RegionRequestDTO dto) {
        return new ResponseEntity<>(service.update(code, dto), OK);
    }

    @DeleteMapping(path = "/{code}", produces = APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Supprimer une region en fonction de son code",
            parameters = {
                    @Parameter(
                            name = "code",
                            description = "Code de la region",
                            required = true,
                            in = ParameterIn.PATH,
                            example = "YND"
                    )
            }
    )
    public ResponseEntity<?> deleteByCode(@PathVariable("code") String code){
        log.info("Call delete one region by code : {}", code);
        service.delete(code);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
