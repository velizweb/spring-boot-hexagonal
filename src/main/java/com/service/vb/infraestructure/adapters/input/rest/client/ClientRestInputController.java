package com.service.vb.infraestructure.adapters.input.rest.client;

import com.service.vb.application.ports.input.ClientInputPort;
import com.service.vb.domain.model.Client;
import com.service.vb.infraestructure.adapters.input.rest.client.mapper.ClientRestMapper;
import com.service.vb.infraestructure.adapters.input.rest.client.model.request.ClientCreateRequest;
import com.service.vb.infraestructure.adapters.input.rest.client.model.response.ClientResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ClientRestInputController {

    private final ClientInputPort inputPort;
    private final ClientRestMapper mapper;

    /*@Operation(summary = "Get a book by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content) })*/
    @GetMapping("/v1")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientResponse> findAll(){
        return mapper.toClientResponseList(inputPort.findAll());
    }

    @GetMapping("/v1/{id}")
    public ClientResponse findById(@PathVariable Long id){
        return mapper.toClientResponse(inputPort.findById(id));
    }

    @PostMapping("/v1")
    public ResponseEntity<ClientResponse> save(@Valid @RequestBody ClientCreateRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toClientResponse(inputPort.save(mapper.toClient(request))));
    }

    @PutMapping("/v1/{id}")
    public ResponseEntity<ClientResponse> update(@PathVariable Long id, @Valid @RequestBody ClientCreateRequest request){
        return ResponseEntity.status(HttpStatus.OK)
                .body(mapper.toClientResponse(inputPort.update(id, mapper.toClient(request))));
    }

    @DeleteMapping("/v1/{id}")
    public void delete(Long id){
        inputPort.detele(id);
    }

}
