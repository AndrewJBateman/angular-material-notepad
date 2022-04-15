import { Component } from '@angular/core';

@Component({
  selector: 'app-notes-component',
  template: `
    <app-note-create></app-note-create>
    <app-note-list></app-note-list>
  `,
})
export class NotesComponent {
  title = 'angular-tailwind-notepad';
}
