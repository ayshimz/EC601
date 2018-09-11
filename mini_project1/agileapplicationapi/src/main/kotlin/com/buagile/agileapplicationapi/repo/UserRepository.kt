package com.buagile.agileapplicationapi.repo

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import com.buagile.agileapplicationapi.model.TaskUser


@Repository
interface UserRepository : CrudRepository<TaskUser, Long> {

    fun findByUserId(UserId: String): Iterable<TaskUser>
}