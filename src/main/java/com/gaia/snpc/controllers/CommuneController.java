package com.gaia.snpc.controllers;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import com.gaia.snpc.services.interfaces.CommuneService;
import com.gaia.snpc.domains.dtos.request.CommuneRequestDTO;
import com.gaia.snpc.domains.dtos.responses.CommuneResponseDTO;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/communes")
@Tag(name = "Gestion des Communes", description = "API pour la gestion des communes")
public class CommuneController {

    private final CommuneService service;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    //@Tag(name = "get", description = "Retourne la liste des communes")
    @Operation(summary = "Retourne toutes les communes")
    public ResponseEntity<List<CommuneResponseDTO>> getAllCommune(){
        log.info("Call retrieve all commune");
        return new ResponseEntity<>(service.search(), OK);
    }

    @GetMapping(path = "/{code}", produces = APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Retourne une commune en fonction de son code",
            parameters = {
                    @Parameter(
                            name = "code",
                            description = "Code de la commune",
                            required = true,
                            in = ParameterIn.PATH,
                            example = "75056"
                    )
            }
    )
    public ResponseEntity<CommuneResponseDTO> getCommuneByCode(@PathVariable("code") String code){
        log.info("Call retrieve one commune");
        return new ResponseEntity<>(service.getByCodeCommune(code), OK);
    }


    @Operation(summary = "Creer une commune")
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommuneResponseDTO> save(@RequestBody CommuneRequestDTO dto) {
        return new ResponseEntity<>(service.create(dto), CREATED);
    }

    @Operation(
            summary = "Modifier une commune en fonction de son code",
            parameters = {
                    @Parameter(
                            name = "code",
                            description = "Code de la commune",
                            required = true,
                            in = ParameterIn.PATH,
                            example = "75056"
                    )
            }
    )
    @PutMapping(path = "/{code}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommuneResponseDTO> update(@PathVariable("code") String code, @RequestBody CommuneRequestDTO dto) {
        return new ResponseEntity<>(service.update(code, dto), OK);
    }

    @DeleteMapping(path = "/{code}", produces = APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Supprimer une commune en fonction de son code",
            parameters = {
                    @Parameter(
                            name = "code",
                            description = "Code de la commune",
                            required = true,
                            in = ParameterIn.PATH,
                            example = "75056"
                    )
            }
    )
    public ResponseEntity<?> deleteByCode(@PathVariable("code") String code){
        log.info("Call delete one commune by code : {}", code);
        service.delete(code);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
