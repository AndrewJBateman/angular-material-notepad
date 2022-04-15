import { Injectable } from "@angular/core"
import { Note } from "../../notes/notes.model"
import { Subject } from 'rxjs'

@Injectable({providedIn : 'root'})
export class NoteService {
    private notes: Note[] = [{
        id : 1,
        title : "Sunt aut facere",
        description : "Repellat provident occaecati excepturi",
        body : "Quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut quas totam nostrum rerum est autem sunt rem eveniet architecto."
    },{
        id : 2,
        title : "Qui est esse",
        description : "Est rerum tempore vitae sequi",
        body : "Sint nihil reprehenderit dolor beatae ea dolores neque fugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis qui aperiam non debitis possimus qui neque nisi nulla."
    }, {
        id : 3,
        title : "Ea molestias quasi exercitationem",
        description : "Rullam et saepe reiciendis voluptatem ad",
        body : "Delectus reiciendis molestiae occaecati non minima eveniet qui voluptatibus accusamus in eum beatae sit vel qui neque voluptates ut commodi qui incidunt ut animi commodi."
    }]
    private notesUpdated = new Subject<Note[]>()

    getNotes() {
        return [...this.notes]
    }

    getNoteUpdateListener() {
        return this.notesUpdated.asObservable()
    }

    addNote(title: string, description: string, body: string) {
        const lastId : number = this.notes[ this.notes.length - 1]?.id ?? 1
        const note : Note = {id: lastId, title: title, description: description, body: body}
        this.notes.push(note)
        this.notesUpdated.next([...this.notes])
    }

    setNotes(notes: Note[]) {
        this.notes = notes
    }

    deleteNote(id : number) {
      const noteToDelete = this.notes.findIndex((note) => note.id === id)
      this.notes.splice(noteToDelete, 1)
    }

}
