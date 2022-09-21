package com.example.rxspringkotlinkimhab.repository

import com.example.rxspringkotlinkimhab.model.entity.AppUser
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import java.util.UUID

interface AppUserRepository: ReactiveCrudRepository<AppUser, UUID> {
}