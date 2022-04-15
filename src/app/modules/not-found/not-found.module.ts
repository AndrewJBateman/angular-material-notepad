import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';

import { NotFoundRoutingModule } from './not-found-routing.module';
import { NotFoundComponent } from '../not-found/not-found.component';

@NgModule({
  declarations: [NotFoundComponent],
  imports: [
    CommonModule,
    NotFoundRoutingModule,
    MatButtonModule,
    MatCardModule,
  ],
  exports: [NotFoundComponent, RouterModule],
})
export class NotFoundModule {}
