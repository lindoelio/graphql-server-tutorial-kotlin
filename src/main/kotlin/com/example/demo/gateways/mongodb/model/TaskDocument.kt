package com.example.demo.gateways.mongodb.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "tasks")
data class TaskDocument(
    var title: String,
    var completed: Boolean
) {
    @Id
    var id: String = ""
}