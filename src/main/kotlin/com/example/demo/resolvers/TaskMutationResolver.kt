package com.example.demo.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.example.demo.gateways.mongodb.TaskRepository
import com.example.demo.gateways.mongodb.model.TaskDocument
import org.springframework.stereotype.Component

@Component
class TaskMutationResolver(private val taskRepository: TaskRepository): GraphQLMutationResolver {

    fun createTask(title: String): TaskDocument {
        val task = taskRepository.save(TaskDocument(title, false))

        return task
    }

    fun updateTask(id: String, title: String, completed: Boolean): TaskDocument {
        val task = taskRepository.findById(id)

        task.ifPresent {
            it.title = title
            it.completed = completed

            taskRepository.save(it)
        }

        return task.get()
    }

    fun deleteTask(id: String): Boolean {
        taskRepository.deleteById(id)

        return true
    }
}