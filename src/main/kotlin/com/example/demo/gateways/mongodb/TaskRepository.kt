package com.example.demo.gateways.mongodb

import com.example.demo.gateways.mongodb.model.TaskDocument
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : MongoRepository<TaskDocument, String> {

    fun findByCompleted(completed: Boolean): List<TaskDocument>
}