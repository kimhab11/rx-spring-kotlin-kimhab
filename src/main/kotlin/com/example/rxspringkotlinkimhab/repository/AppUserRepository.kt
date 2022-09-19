package com.example.rxspringkotlinkimhab.repository

import com.example.rxspringkotlinkimhab.model.entity.AppUser
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface AppUserRepository: ReactiveCrudRepository<AppUser, Long> {
}