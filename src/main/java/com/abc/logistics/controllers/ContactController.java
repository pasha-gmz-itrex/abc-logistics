package com.abc.logistics.controllers;

import com.abc.logistics.dto.models.ContactModel;
import com.abc.logistics.dto.models.MasterDataModel;
import com.abc.logistics.dto.models.errors.InvalidRequestError;
import com.abc.logistics.dto.models.errors.UnexpectedServerError;
import com.abc.logistics.dto.requests.post.ContactCreateRequest;
import com.abc.logistics.dto.requests.get.ContactRequest;
import com.abc.logistics.dto.requests.post.MasterDataCreateRequest;
import com.abc.logistics.dto.requests.put.ContactUpdateRequest;
import com.abc.logistics.dto.requests.put.MasterDataUpdateRequest;
import com.abc.logistics.dto.responses.ContactSuccessResponse;
import com.abc.logistics.services.ContactService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(
    value = "Contacts",
    description = "REST api for managing contacts",
    tags = "Contacts"
)
@RestController
@RequestMapping(value = "/api/v1/contacts", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping("")
    @ApiOperation(value = "Get a list of contacts using filters")
    @ApiResponses(
        {
            @ApiResponse(code = 200, message = "Successful response", response = ContactSuccessResponse.class),
            @ApiResponse(code = 400, message = "An invalid request", response = InvalidRequestError.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message = "An unexpected error occurred", response =  UnexpectedServerError.class)
        }
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ContactModel>> getAll(ContactRequest request) {
        return new ResponseEntity<>(contactService.get(request), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get contact by identifier")
    @ApiResponses(
        {
            @ApiResponse(code = 200, message = "Successful response", response = ContactModel.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "An object with such identifier doesn't exists"),
            @ApiResponse(code = 500, message = "An unexpected error occurred", response =  UnexpectedServerError.class)
        }
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ContactModel> getById(
        @ApiParam("Contact identifier")
        @PathVariable
            String id
    ) {
        return new ResponseEntity<>(contactService.getById(id), HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Create a new contact")
    @ApiResponses(
        {
            @ApiResponse(code = 201, message = "An object has been created", response = ContactModel.class),
            @ApiResponse(code = 400, message = "An invalid request", response = InvalidRequestError.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message = "An unexpected error occurred", response =  UnexpectedServerError.class)
        }
    )
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContactModel> create(
        @ApiParam("Contact create request")
        @RequestBody
            ContactCreateRequest request
    ) {
        return new ResponseEntity<>(contactService.create(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Updated an existing contact")
    @ApiResponses(
        {
            @ApiResponse(code = 200, message = "An object has been updated", response = ContactModel.class),
            @ApiResponse(code = 400, message = "An invalid request", response = InvalidRequestError.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "An object with such identifier doesn't exists"),
            @ApiResponse(code = 500, message = "An unexpected error occurred", response =  UnexpectedServerError.class)
        }
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ContactModel> update(
        @ApiParam("Contact identifier")
        @PathVariable
            String id,
        @ApiParam("Contact update request")
        @RequestBody
            ContactUpdateRequest request
    ) {
        return new ResponseEntity<>(contactService.update(id, request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete an existing contact")
    @ApiResponses(
        {
            @ApiResponse(code = 204, message = "An object has been deleted", response = ContactModel.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "An object with such identifier doesn't exists"),
            @ApiResponse(code = 500, message = "An unexpected error occurred", response =  UnexpectedServerError.class)
        }
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(
        @ApiParam("Contact identifier")
        @PathVariable
            String id
    ) {
        contactService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{contactId}/master-data-records")
    @ApiOperation(value = "Get a list of contact's master data records")
    @ApiResponses(
        {
            @ApiResponse(code = 200, message = "Successful response", response = MasterDataModel.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "An object with such identifier doesn't exists"),
            @ApiResponse(code = 500, message = "An unexpected error occurred", response =  UnexpectedServerError.class)
        }
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MasterDataModel>> getMasterDataRecords(
        @ApiParam("Contact identifier")
        @PathVariable
            String contactId
    ) {
        return new ResponseEntity<>(contactService.getMasterDataRecords(contactId), HttpStatus.OK);
    }

    @PostMapping("/{contactId}/master-data-records")
    @ApiOperation(value = "Create contact's master data record")
    @ApiResponses(
        {
            @ApiResponse(code = 201, message = "An object has been created", response = MasterDataModel.class),
            @ApiResponse(code = 400, message = "An invalid request", response = InvalidRequestError.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "An object with such identifier doesn't exists"),
            @ApiResponse(code = 500, message = "An unexpected error occurred", response =  UnexpectedServerError.class)
        }
    )
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MasterDataModel> createMasterDataRecord(
        @ApiParam("Contact identifier")
        @PathVariable
            String contactId,
        @ApiParam("Master data create request")
        @RequestBody
            MasterDataCreateRequest request
    ) {
        return new ResponseEntity<>(contactService.createMasterDataRecord(contactId, request), HttpStatus.CREATED);
    }

    @PutMapping("/{contactId}/master-data-records/{masterDataId}")
    @ApiOperation(value = "Update contact's master data record")
    @ApiResponses(
        {
            @ApiResponse(code = 200, message = "An object has been updated", response = MasterDataModel.class),
            @ApiResponse(code = 400, message = "An invalid request", response = InvalidRequestError.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "An object with such identifier doesn't exists"),
            @ApiResponse(code = 500, message = "An unexpected error occurred", response =  UnexpectedServerError.class)
        }
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MasterDataModel> updateMasterDataRecord(
        @ApiParam("Contact identifier")
        @PathVariable
            String contactId,
        @ApiParam("Master data identifier")
        @PathVariable
            String masterDataId,
        @ApiParam("Master data update request")
        @RequestBody
            MasterDataUpdateRequest request
    ) {
        return new ResponseEntity<>(contactService.updateMasterData(contactId, masterDataId, request), HttpStatus.OK);
    }

    @DeleteMapping("/{contactId}/master-data-records/{masterDataId}")
    @ApiOperation(value = "Delete contact's master data record")
    @ApiResponses(
        {
            @ApiResponse(code = 204, message = "An object has been deleted", response = ContactModel.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "An object with such identifier doesn't exists"),
            @ApiResponse(code = 500, message = "An unexpected error occurred", response =  UnexpectedServerError.class)
        }
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteMasterData(
        @ApiParam("Contact identifier")
        @PathVariable
            String contactId,
        @ApiParam("Master data identifier")
        @PathVariable
            String masterDataId
    ) {
        contactService.deleteMasterData(contactId, masterDataId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
