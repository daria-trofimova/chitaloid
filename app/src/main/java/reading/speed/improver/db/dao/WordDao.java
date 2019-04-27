package reading.speed.improver.db.dao;

import androidx.room.*;
import reading.speed.improver.exercises.materials.Word;

import java.util.List;

@Dao
public interface WordDao {

    @Query("SELECT * FROM Word")
    List<Word> getAll();

    @Query("SELECT * FROM Word WHERE _id = :id")
    Word getById(Integer id);

    @Insert
    void insert(Word word);

    @Update
    void update(Word word);

    @Delete
    void delete(Word word);

}