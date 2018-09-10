package com.buagile.agileapplicationapi.controller

import org.springframework.beans.factory.annotation.Autowired

import com.buagile.agileapplicationapi.repo.UserRepository
import com.buagile.agileapplicationapi.model.User
import org.springframework.web.bind.annotation.*

@RestController
class WebController {

    @Autowired
    lateinit var repository: UserRepository

    @RequestMapping("/save", method = arrayOf(RequestMethod.POST))
    fun save(@RequestBody user: User): String {
        repository.save(User(
                userId = user.userId,
                userName = user.userName,
                userEmail = user.userEmail
        ))

        return "User Saved"
    }

    @RequestMapping("/findall")
    fun findAll() = repository.findAll()

    @RequestMapping("findbylastname/{lastName}")
    fun findByLastName(@PathVariable lastName: String)
            = repository.findByLastName(lastName)

}