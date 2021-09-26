package ru.btelepov.to_do_compose.data.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ru.btelepov.to_do_compose.data.models.ToDoTask
import ru.btelepov.to_do_compose.util.Constants.DATABASE_TABLE

@Dao
interface ToDoDao {
    @Query("SELECT * FROM $DATABASE_TABLE ORDER BY id ASC")
    fun getAllTasks(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM $DATABASE_TABLE WHERE id=:taskId")
    fun getSelectedTask(taskId: Int): Flow<ToDoTask>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(toDoTask: ToDoTask)

    @Update
    suspend fun updateTask(task: ToDoTask)

    @Delete
    suspend fun deleteTask(task: ToDoTask)

    @Query("DELETE FROM $DATABASE_TABLE")
    suspend fun deleteAllTasks()

    @Query("SELECT * FROM $DATABASE_TABLE WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>>

    @Query("SELECT * FROM $DATABASE_TABLE ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun sortByLowPriority(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM $DATABASE_TABLE ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun sortByHighPriority(): Flow<List<ToDoTask>>


}