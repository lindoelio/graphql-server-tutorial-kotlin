package com.example.demo.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.example.demo.gateways.mongodb.TaskRepository
import com.example.demo.gateways.mongodb.model.TaskDocument
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class TaskQueryResolver(private val taskRepository: TaskRepository, private val db: MongoOperations): GraphQLQueryResolver {

    fun findAllTasks(): List<TaskDocument> {
        return taskRepository.findAll()
    }

    fun findTasks(completed: Boolean): List<TaskDocument> {
        return taskRepository.findByCompleted(completed)
    }

    fun findTaskById(id: String): TaskDocument {
        return taskRepository.findById(id).get()
    }
}