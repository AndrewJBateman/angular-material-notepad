import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Note } from '../../notes.model';
import { NoteService } from '../../services/notes.service';

@Component({
  selector: 'app-note-list',
  templateUrl: 'note-list.component.html',
  styleUrls: ['note-list.component.css'],
})
export class NoteListComponent implements OnInit, OnDestroy {
  panelOpenState = false;
  notes: Note[] = [];

  constructor(public noteService: NoteService) {}

  private notesSub: Subscription = new Subscription();

  ngOnInit() {
    this.notes = this.noteService.getNotes();
    this.notesSub = this.noteService
      .getNoteUpdateListener()
      .subscribe((notes: Note[]) => {
        this.notes = notes;
      });
  }

  trackByFn = (index: number, note: any) => {
    return index;
  }

  ngOnDestroy() {
    this.notesSub.unsubscribe();
  }

  deleteEvent(id: number) {
    this.noteService.deleteNote(id);
    this.notes = this.noteService.getNotes();
  }
}
