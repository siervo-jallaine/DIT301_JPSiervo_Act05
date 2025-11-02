package com.example.notekeeperapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddEditNoteActivity : AppCompatActivity() {

    private lateinit var db: NotesDatabaseHelper
    private lateinit var titleEditText: EditText
    private lateinit var contentEditText: EditText
    private lateinit var saveButton: Button

    private var noteId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_note)

        db = NotesDatabaseHelper(this)
        titleEditText = findViewById(R.id.edit_title)
        contentEditText = findViewById(R.id.edit_content)
        saveButton = findViewById(R.id.button_save)

        // Check if we are editing an existing note
        noteId = intent.getIntExtra("note_id", -1)

        if (noteId != -1) {
            // Edit mode
            title = "Edit Note"
            val note = db.getNoteByID(noteId)
            titleEditText.setText(note.title)
            contentEditText.setText(note.content)
        } else {
            // Add mode
            title = "Add Note"
        }

        saveButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val content = contentEditText.text.toString()

            if (noteId == -1) {
                // Add new note
                db.addNote(title, content)
            } else {
                // Update existing note
                val updatedNote = Note(noteId, title, content, "")
                db.updateNote(updatedNote)
            }

            finish()
        }
    }
}