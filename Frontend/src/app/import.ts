// Import PrimeNG modules
import { TableModule } from 'primeng/table';
import { CommonModule } from '@angular/common';
import { ButtonModule } from 'primeng/button';
import { BadgeModule } from 'primeng/badge';
import { InputTextModule } from 'primeng/inputtext';
import {DialogModule} from 'primeng/dialog';
import { DynamicDialogModule } from 'primeng/dynamicdialog';
import { NgModule } from '@angular/core';
import { RadioButtonModule } from 'primeng/radiobutton';
import { InputSwitchModule } from 'primeng/inputswitch';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { InputNumberModule } from 'primeng/inputnumber';
import { InputGroupModule } from 'primeng/inputgroup';
import { InputGroupAddonModule } from 'primeng/inputgroupaddon';
import { InputOtpModule } from 'primeng/inputotp';
import { FormsModule } from '@angular/forms';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { DividerModule } from 'primeng/divider';

@NgModule({
  imports: [
    ButtonModule,
    BadgeModule,
    CommonModule,
    DialogModule,
    DividerModule,
    DynamicDialogModule,
    FormsModule,
    InputSwitchModule,
    InputTextModule, 
    InputTextareaModule,
    InputNumberModule,
    InputGroupModule,
    InputGroupAddonModule,
    InputOtpModule,
    RadioButtonModule,
    TableModule,
    RouterOutlet, 
    RouterLinkActive, 
    RouterLink
  ],
  exports: [
    ButtonModule,
    BadgeModule, 
    CommonModule,
    DialogModule,
    DividerModule,
    DynamicDialogModule,
    FormsModule,
    InputSwitchModule,
    InputTextModule, 
    InputTextareaModule,
    InputNumberModule,
    InputGroupModule,
    InputGroupAddonModule,
    InputOtpModule,
    RadioButtonModule,
    TableModule,
    RouterOutlet, 
    RouterLinkActive, 
    RouterLink
  ],
})
export class ImportsModule {}
