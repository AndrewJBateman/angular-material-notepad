import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { NoteService } from '../../services/notes.service';

@Component({
  selector: 'app-note-create',
  styleUrls: ['note-create.component.css'],
  templateUrl: './note-create.component.html',
})
export class NoteCreateComponent {
  constructor(public noteService: NoteService) {}

  onAddNote(form: NgForm) {
    if (form.invalid) return;
    const { title, description, body } = form.value;
    this.noteService.addNote(title, description, body);
    form.resetForm();
  }
}
