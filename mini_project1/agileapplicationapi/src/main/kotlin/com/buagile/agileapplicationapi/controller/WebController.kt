package com.buagile.agileapplicationapi.controller

import org.springframework.beans.factory.annotation.Autowired

import com.buagile.agileapplicationapi.repo.UserRepository
import com.buagile.agileapplicationapi.model.TaskUser
import org.springframework.web.bind.annotation.*

@RestController
class WebController {

    @Autowired
    lateinit var repository: UserRepository

    @RequestMapping("/save", method = arrayOf(RequestMethod.POST))
    fun save(@RequestBody taskuser: TaskUser): String {
        repository.save(TaskUser(taskuser.userId, taskuser.userName, taskuser.userEmail))
        return repository.findAll().toString()
    }

    @RequestMapping("/findall")
    fun findAll() = repository.findAll()

    @RequestMapping("findbyUserId/{userId}")
    fun findByUserId(@PathVariable userId: String)
            = repository.findByUserId(userId)

}