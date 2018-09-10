package com.buagile.agileapplicationapi.repo

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import com.buagile.agileapplicationapi.model.User


@Repository
interface UserRepository : CrudRepository<User, Long> {

    fun findByLastName(lastName: String): Iterable<User>
}