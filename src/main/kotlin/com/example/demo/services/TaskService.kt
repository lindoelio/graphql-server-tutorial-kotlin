package com.example.demo.services

import com.example.demo.types.Task

interface TaskService {

    fun findAllTasks()

    fun findTasks(completed: Boolean): List<Task>

    fun findTaskById(id: String): Task
}