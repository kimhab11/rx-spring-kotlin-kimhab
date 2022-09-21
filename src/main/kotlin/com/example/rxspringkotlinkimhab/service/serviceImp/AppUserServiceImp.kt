package com.example.rxspringkotlinkimhab.service.serviceImp

import com.example.rxspringkotlinkimhab.model.dto.AppUserDto
import com.example.rxspringkotlinkimhab.model.request.AppUserReq
import com.example.rxspringkotlinkimhab.repository.AppUserRepository
import com.example.rxspringkotlinkimhab.service.AppUserService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.UUID

@Service
class AppUserServiceImp(private val appUserRepository: AppUserRepository) : AppUserService {
    override fun findAll(): Flux<AppUserDto> {
        return appUserRepository.findAll()
//            .map { it.toDto() }
            .map { appUser -> appUser.toDto() }
    }

    override fun findById(id: UUID): Mono<AppUserDto> {
        return appUserRepository.findById(id).map { it.toDto() }
    }

    override fun save(appUser: AppUserReq): Mono<AppUserDto> {
        return appUserRepository.save(appUser.toEntity()).map { it.toDto() }
    }


}