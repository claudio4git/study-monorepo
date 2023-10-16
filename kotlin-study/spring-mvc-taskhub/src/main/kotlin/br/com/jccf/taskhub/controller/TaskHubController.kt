package br.com.jccf.taskhub.controller

import br.com.jccf.taskhub.model.TaskHubEntity
import br.com.jccf.taskhub.model.TaskHubRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors

@CrossOrigin
@RestController
@RequestMapping("/task")
class TaskHubController @Autowired constructor(val repository: TaskHubRepository) {

    @PostMapping
    fun insert(@RequestBody task: TaskHubEntity): ResponseEntity<TaskHubEntity> =
            ResponseEntity.ok(repository.save(TaskHubEntity(title = task.title, description = task.description, status = task.status)))

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody task: TaskHubEntity): ResponseEntity<TaskHubEntity> {
        val uuid = UUID.fromString(id)
        if (repository.existsById(uuid))
            return ResponseEntity.ok(repository.save(TaskHubEntity(id = uuid, title = task.title, description = task.description, status = task.status)))

        return ResponseEntity.notFound().build()
    }

    @GetMapping
    fun list(): ResponseEntity<List<TaskHubEntity>> =
            ResponseEntity.ok(repository.findAll().stream().collect(Collectors.toList()))

    @GetMapping("/{id}")
    fun retrieve(@PathVariable("id") id: String): ResponseEntity<TaskHubEntity> {
        val uuid = UUID.fromString(id)
        if (repository.existsById(uuid))
            return ResponseEntity.ok(repository.findById(uuid).get())

        return ResponseEntity.notFound().build()
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable("id") id: String) {
        val uuid = UUID.fromString(id)
        if (repository.existsById(uuid))
            repository.deleteById(uuid)
    }
}
