# Notes Manager (Java)

A simple text-based Notes Manager written in Java.  
This program allows users to write and read notes from a text file using `FileWriter` and `FileReader`.

---

## Features
- **Write a note**: Append new notes to `notes.txt`
- **Read notes**: Display all notes from the file
- **Menu-driven interface**: Easy-to-use text-based menu

---

## How It Works
1. The program creates or uses an existing file named `notes.txt`.
2. The user can:
   - Enter a note (which gets saved to the file)
   - Read all saved notes
   - Exit the application
3. Notes are stored in **append mode**, so existing notes are not overwritten.
