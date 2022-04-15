import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MaterialModule } from '../material/material.module';
import { FlexLayoutModule } from '@angular/flex-layout';
import { NotesComponent } from './notes.component';

import { NoteCreateComponent } from './components/note-create/note-create.component';
import { NoteListComponent } from './components/note-list/note-list.component';
import { FormsModule } from '@angular/forms';
import { NotesRoutingModule } from './notes-routing.module';

@NgModule({
  declarations: [NotesComponent, NoteCreateComponent, NoteListComponent],
  imports: [CommonModule, NotesRoutingModule, FormsModule, FlexLayoutModule, MaterialModule],
  exports: [NotesComponent, NoteListComponent, NoteCreateComponent],
})
export class NotesModule {}
