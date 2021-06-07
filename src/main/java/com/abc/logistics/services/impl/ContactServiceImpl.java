package com.abc.logistics.services.impl;

import com.abc.logistics.dto.models.ContactModel;
import com.abc.logistics.dto.models.MasterDataModel;
import com.abc.logistics.dto.requests.post.ContactCreateRequest;
import com.abc.logistics.dto.requests.get.ContactRequest;
import com.abc.logistics.dto.requests.post.MasterDataCreateRequest;
import com.abc.logistics.dto.requests.put.ContactUpdateRequest;
import com.abc.logistics.dto.requests.put.MasterDataUpdateRequest;
import com.abc.logistics.services.ContactService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@CacheConfig(cacheManager = "logisticsCacheManager")
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    @Override
    public List<ContactModel> get(ContactRequest request) {

        // todo: validate request and throw InvalidRequestException if request contains incorrect fields

        // todo: add a logic by searching and paginating..

        return List.of();
    }

    @Override
    public ContactModel getById(String id) {

        // todo: return model if exists or throw ItemNotFoundException

        return ContactModel.builder().build();
    }

    @Override
    public ContactModel create(ContactCreateRequest request) {

        // todo: validate request and throw InvalidRequestException if request contains incorrect fields

        // todo: add a logic by creating new entity

        // todo: return created entity

        return ContactModel.builder().build();
    }

    @Override
    public ContactModel update(String id, ContactUpdateRequest request) {
        // todo: validate request and throw InvalidRequestException if request contains incorrect fields

        // todo: add a logic by updating an existing entity

        // todo: return updated entity

        return ContactModel.builder().build();
    }

    @Override
    public void delete(String id) {
        // todo: delete if exists with relations of throw NotFoundException
    }

    @Override
    @Cacheable(value = "master-data", key = "#contactId") // get master data from redis by contact_id
    public List<MasterDataModel> getMasterDataRecords(String contactId) {
        return List.of(MasterDataModel.builder().build());
    }

    @Override
    @CacheEvict(value = "master-data", key = "#contactId") // clear master data from redis by contact_id
    public MasterDataModel createMasterDataRecord(String contactId, MasterDataCreateRequest request) {
        // todo: create contact master data
        return MasterDataModel.builder().build();
    }

    @Override
    @CacheEvict(value = "master-data", key = "#contactId") // clear master data from redis by contact_id
    public MasterDataModel updateMasterData(String contactId, String masterDataId, MasterDataUpdateRequest request) {
        // todo: get master data by id and update

        return MasterDataModel.builder().build();
    }

    @Override
    @CacheEvict(value = "master-data", key = "#contactId") // clear master data from redis by contact_id
    public void deleteMasterData(String contactId, String masterDataId) {
    }
}
