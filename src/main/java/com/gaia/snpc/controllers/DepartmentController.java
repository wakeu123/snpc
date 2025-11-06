package com.gaia.snpc.controllers;

import com.gaia.snpc.domains.dtos.request.DepartmentRequestDTO;
import com.gaia.snpc.domains.dtos.request.RegionRequestDTO;
import com.gaia.snpc.domains.dtos.responses.DepartmentResponseDTO;
import com.gaia.snpc.domains.dtos.responses.RegionResponseDTO;
import com.gaia.snpc.services.interfaces.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/departments")
@Tag(name = "Gestion des departements", description = "API pour la gestion des departements")
public class DepartmentController {

    private final DepartmentService service;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Retourne toutes les departments")
    public ResponseEntity<List<DepartmentResponseDTO>> getAllDepartments(){
        log.info("Call retrieve all departments");
        return new ResponseEntity<>(service.search(), OK);
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Retourne un department en fonction de son id",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "Identifiant du department",
                            required = true,
                            in = ParameterIn.PATH,
                            example = "afaffs-ssfas-ffasf-fafsa-fsfas"
                    )
            }
    )
    public ResponseEntity<DepartmentResponseDTO> getDepartmentById(@PathVariable("id") String id){
        log.info("Call retrieve one department");
        return new ResponseEntity<>(service.getById(id), OK);
    }


    @Operation(summary = "Creer un department")
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentResponseDTO> save(@RequestBody DepartmentRequestDTO dto) {
        return new ResponseEntity<>(service.create(dto), CREATED);
    }

    @Operation(
            summary = "Modifier un department en fonction de son id",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "Identifiant du department",
                            required = true,
                            in = ParameterIn.PATH,
                            example = "saassac-casc-ccascs-caascs-sccac-asascs"
                    )
            }
    )
    @PutMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentResponseDTO> update(@PathVariable("id") String id, @RequestBody DepartmentRequestDTO dto) {
        return new ResponseEntity<>(service.update(id, dto), OK);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(
            summary = "Supprimer un department en fonction de son id",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "Identifiant du department",
                            required = true,
                            in = ParameterIn.PATH,
                            example = "fssaf-safasfa-ssadf-afsfa-asfas-fasds"
                    )
            }
    )
    public ResponseEntity<?> deleteById(@PathVariable("id") String id){
        log.info("Call delete one department by id : {}", id);
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
