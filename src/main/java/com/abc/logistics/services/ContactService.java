package com.abc.logistics.services;

import com.abc.logistics.dto.models.ContactModel;
import com.abc.logistics.dto.models.MasterDataModel;
import com.abc.logistics.dto.requests.get.ContactRequest;
import com.abc.logistics.dto.requests.post.ContactCreateRequest;
import com.abc.logistics.dto.requests.post.MasterDataCreateRequest;
import com.abc.logistics.dto.requests.put.ContactUpdateRequest;
import com.abc.logistics.dto.requests.put.MasterDataUpdateRequest;
import java.util.List;

public interface ContactService {

    List<ContactModel> get(ContactRequest request);

    ContactModel getById(String id);

    ContactModel create(ContactCreateRequest request);

    ContactModel update(String id, ContactUpdateRequest request);

    void delete(String id);

    List<MasterDataModel> getMasterDataRecords(String contactId);

    MasterDataModel createMasterDataRecord(String contactId, MasterDataCreateRequest request);

    MasterDataModel updateMasterData(String contactId, String masterDataId, MasterDataUpdateRequest request);

    void deleteMasterData(String contactId, String masterDataId);
}
