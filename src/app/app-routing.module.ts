import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/notes',
    pathMatch: 'full',
  },
  {
    path: 'notes',
    loadChildren: () =>
      import('./modules/notes/notes.module').then((mod) => mod.NotesModule),
  },
  {
    path: "**",
    loadChildren: () =>
      import("./modules/not-found/not-found.module").then(
        (mod) => mod.NotFoundModule
      ),
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
